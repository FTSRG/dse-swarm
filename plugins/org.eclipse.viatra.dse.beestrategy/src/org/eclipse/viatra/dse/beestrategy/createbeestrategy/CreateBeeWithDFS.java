package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class CreateBeeWithDFS extends WorkerBeeStrategy {

	
	FilterOptions fo = new FilterOptions().nothingIfCut().untraversedOnly();	
	private boolean interrupted;
	private Logger logger = Logger.getLogger(getClass());
	

	public boolean isInterrupted() {
		return interrupted;
	}
	protected CreateBeeWithDFS(BeeStrategy3 bs){
		super(bs);
	}
	
	/**
	 * It will set ThreadContext and PatchSize (default == 1) if you would like
	 * to change patchsize you have to call setpatchsize
	 */
	@Override
	public synchronized void initStrategy(ThreadContext context) {
		this.context = context;
		if (radius == null)
			radius = 1;
		this.dsm = context.getDesignSpaceManager();
		logger.debug("Initied");

	}

	
//	public boolean isAlreadyFoundInThisStrategy(IState iState){
//		if(this.alreadyFoundStates==null){
//			alreadyFoundStates = new HashSet<IState>();
//			alreadyFoundStates.add(iState);
//			return false;
//		}
//		 return alreadyFoundStates.add(iState);
//		
//	}

//	public boolean newStateIsProcessed(boolean isAlreadyTraversed) {
//		Fitness actualFitness = context.calculateFitness();
//		IState currentState = dsm.getCurrentState();
//
//		// if (!isAlreadyTraversed) {
//		// logger.debug("reached state" + currentState.getId() + "isAlreadyTrav:
//		// " + isAlreadyTraversed);
//		// ReachedStateData rsd = new ReachedStateData();
//		// System.out.println(currentState.getId());
//		// rsd.setBestfitness(10.0);
//		// rsd.setBestti(dsm.getTrajectoryInfo());
//		// rsd.setReachedBy(context);
//		// bs.setNewStateValue(currentState, rsd);
//		// }
//		if (isAlreadyTraversed) {
//			context.getDesignSpaceManager().undoLastTransformation();
//		}
//
//		// if(bs.getifTravelsed(currentState)){
//		// System.out.println("vissza");
//		// context.getDesignSpaceManager().undoLastTransformation();
//		// }
//		return true;
//	}

	// createRandomBee-be mehetne talan maskepp implementalva
	// ExplorerThread explorerThread =
	// context.getGlobalContext().tryStartNewThread(context,
	// context.getModelRoot(), true,
	// Strategies.createDFSStrategy(patchSize2));
	// ArrayList<String> reachedStates = new ArrayList<String>();

	// x1: System.out.println("decision: " + dsm.getCurrentState());

	// x2:
	/*
	 * if (!reachedStates.contains(dsm.getCurrentState().getId().toString() ) ||
	 * dsm.getCurrentState().getId() == bs.getStartstate().getId()) {
	 * patchSize--; ti.addStep(nextTran);
	 * reachedStates.add(dsm.getCurrentState().getId().toString());
	 * System.out.println("reached state: " + dsm.getCurrentState()); } else {
	 * dsm.undoLastTransformation(); patchSize--; }
	 */

	// x3:
	// bs.getPatches().add(p);
	// bs.setNumberOfActiveBees(NumberOfActiveBees++);

	@Override
	public synchronized SearchData createBee() {
		while (radius > 0) {
			ITransition nextTran = selectNextTransition();
 			while (nextTran == null && dsm.getTrajectoryFromRoot().size() > 0) {
				dsm.undoLastTransformation();
				nextTran = selectNextTransition();
			}
			if (nextTran == null && dsm.getTrajectoryFromRoot().size() == 0) return null;

			dsm.fireActivation(nextTran);
			if (this.isAlreadyFoundInThisTrajectory(dsm.getCurrentState()))
				dsm.undoLastTransformation();
			radius--;
		}
		searchData.setActualState(dsm.getTrajectoryInfo());
		searchData.setOwnfitness(context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(searchData.getActualState(), context.getLastFitness());
		searchData.setOwntrajectoryFitness(tf);
		return searchData;
	}

	@Override
	public synchronized ITransition selectNextTransition() {
		// if there is a state from here, which were not processed
		Integer actTranNum = dsm.getTransitionsFromCurrentState(fo).size();
		if (actTranNum > 0) {
			Collection<? extends ITransition> transitions = dsm.getTransitionsFromCurrentState(fo);
			int index = new Random().nextInt(transitions.size());
			Iterator<? extends ITransition> iterator = transitions.iterator();
			while (iterator.hasNext() && index != 0) {
				index--;
				iterator.next();
			}
			// give back the selected transition
			ITransition transition = iterator.next();
			return transition;
		}

		return null;
	}

//	@Override
//	public synchronized StupidBee createNeighbourBee() {
//		boolean start = true;
//		Integer deepness = 0;
//		TrajectoryInfo actualState = patch.getPatch().clone();
//		// this.setThreadContextTo(patch.getPatch());
//
//		// step patchsize many steps
//		for (int i = 0; i < radius; i++) {
//			ITransition nextTran = this.selectNextTransition();
//			while (nextTran == null && deepness >= 0) {
//				dsm.undoLastTransformation();
//				actualState.stepBack();
//				deepness--;
//				nextTran = this.selectNextTransition();
//			}
//			if (deepness == 0 && start == false) {
//				return null;
//			}
//			start = false;
//			context.getDesignSpaceManager().fireActivation(nextTran);
//			radius--;
//			deepness++;
//			actualState.addStep(nextTran);
//		}
//		return generateStupidBee(actualState);
//	}

//	private synchronized StupidBee generateStupidBee(TrajectoryInfo actualState) {
//		StupidBee sb = new StupidBee();
//		sb.init(actualState, BeeType.Neighbour, context.calculateFitness());
//		TrajectoryFitness tf = new TrajectoryFitness(actualState, context.getLastFitness());
//		sb.setTrajectoryFitness(tf);
//		// patch.getBeeList().add(sb);
//		// this.numberOfActiveBees++;
//		// TODO szinkronizálni!!!!!!!!!!
//		this.patch.getBeeList().add(sb);
//		this.bs.increasenumberOfActiveBees();
//		this.sb = sb;
//		// System.out.println("hali");
//		//TODO
//		//System.out.println(sb.getActualState().getCurrentState().getId());
//		this.interruptStrategy();
//		return sb;
//
//	}

//	private void setThreadContextTo(TrajectoryInfo patch) {
//		DesignSpaceManager dsm = context.getDesignSpaceManager();
//		while (dsm.getTrajectoryFromRoot().size() != 0) {
//			dsm.undoLastTransformation();
//		}
//		List<ITransition> transitions = patch.getFullTransitionTrajectory();
//		for (ITransition iTransition : transitions) {
//			System.out.print(" allapot " + dsm.getCurrentState().getId() + " ");
//			dsm.fireActivation(iTransition);
//			System.out.println(iTransition.getId() + " " + dsm.getCurrentState().getId());
//		}

//	}

	// --------------- getters and setters --------------------





	

	public void setBs(BeeStrategy3 beeStrategy) {
		this.bs = beeStrategy;

	}

	


	
	@Override
	public void setInitialState(SearchData sd) {
		
	}
	@Override
	public void setStopCond(Object stopcond) {
		// TODO Auto-generated method stub
		
	}


}
