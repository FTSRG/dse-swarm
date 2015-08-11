package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.beestrategy.Patch;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.StupidBee;
import org.eclipse.viatra.dse.beestrategy.StupidBee.BeeType;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class CreateBeeWithDFS extends WorkerBeeStrategy {

	private Integer patchSize;
	private ThreadContext context;
	private boolean neighbour;
	private BeeStrategy3 bs;
	private StupidBee sb;
	private DesignSpaceManager dsm;
	FilterOptions fo = new FilterOptions().nothingIfCut().untraversedOnly();
	private Patch patch;
	private String id;
	private boolean interrupted;
	private Logger logger = Logger.getLogger(getClass());
	private HashSet<IState> alreadyFoundStates;

	public boolean isInterrupted() {
		return interrupted;
	}
	protected CreateBeeWithDFS(BeeStrategy3 bs, SearchData sd, HashSet<IState> states){
		super(bs, sd, states);
	}
	
	/**
	 * It will set ThreadContext and PatchSize (default == 1) if you would like
	 * to change patchsize you have to call setpatchsize
	 */
	@Override
	public synchronized void initStrategy(ThreadContext context) {
		this.context = context;
		if (patchSize == null)
			patchSize = 1;
		this.dsm = context.getDesignSpaceManager();
		logger.debug("Initied");

	}

	@Override
	public synchronized void setPatch(Patch patch) {
		this.patch = patch;
	}

	@Override
	public void explore() {
		if (this.neighbour == false) {
			createRandomBee();
		}

		else
			createNeighbourBee();
		//interruptStrategy();
	}

	@Override
	public synchronized void interruptStrategy() {
		this.interrupted = true;

	}
	
	public boolean isAlreadyFoundInThisStrategy(IState iState){
		if(this.alreadyFoundStates==null){
			alreadyFoundStates = new HashSet<IState>();
			alreadyFoundStates.add(iState);
			return false;
		}
		 return alreadyFoundStates.add(iState);
		
	}

	public boolean newStateIsProcessed(boolean isAlreadyTraversed) {
		Fitness actualFitness = context.calculateFitness();
		IState currentState = dsm.getCurrentState();

		// if (!isAlreadyTraversed) {
		// logger.debug("reached state" + currentState.getId() + "isAlreadyTrav:
		// " + isAlreadyTraversed);
		// ReachedStateData rsd = new ReachedStateData();
		// System.out.println(currentState.getId());
		// rsd.setBestfitness(10.0);
		// rsd.setBestti(dsm.getTrajectoryInfo());
		// rsd.setReachedBy(context);
		// bs.setNewStateValue(currentState, rsd);
		// }
		if (isAlreadyTraversed) {
			context.getDesignSpaceManager().undoLastTransformation();
		}

		// if(bs.getifTravelsed(currentState)){
		// System.out.println("vissza");
		// context.getDesignSpaceManager().undoLastTransformation();
		// }
		return true;
	}

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
	public synchronized Patch createRandomBee() {

		while (dsm.getTrajectoryFromRoot().size() != 0) {
			dsm.undoLastTransformation();
		}
		while (patchSize > 0) {
			ITransition nextTran = selectNextTransition();
 			while (nextTran == null && dsm.getTrajectoryFromRoot().size() > 0) {
				dsm.undoLastTransformation();
				nextTran = selectNextTransition();
			}
			if (nextTran == null && dsm.getTrajectoryFromRoot().size() == 0) return null;
			// x1
			// logger.debug("next transition: " + nextTran + " from: " +
			// dsm.getCurrentState());

			dsm.fireActivation(nextTran);
			if (this.isAlreadyFoundInThisStrategy(dsm.getCurrentState()))
				dsm.undoLastTransformation();
			// boolean b =
			// newStateIsProcessed(dsm.isNewModelStateAlreadyTraversed());
			// logger.debug("visszalepes utan: " + dsm.getCurrentState());
			// if (b)
			patchSize--;
			// x2
		}
		Patch p = new Patch();
		p.setBestfitness(context.calculateFitness());
		p.initPatch(context.getDesignSpaceManager().getTrajectoryInfo(), context);
		this.patch = p;
		return p;
	}

	private synchronized ITransition selectNextTransition() {
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

	@Override
	public synchronized StupidBee createNeighbourBee() {
		boolean start = true;
		Integer deepness = 0;
		TrajectoryInfo actualState = patch.getPatch().clone();
		// this.setThreadContextTo(patch.getPatch());

		// step patchsize many steps
		for (int i = 0; i < patchSize; i++) {
			ITransition nextTran = this.selectNextTransition();
			while (nextTran == null && deepness >= 0) {
				dsm.undoLastTransformation();
				actualState.stepBack();
				deepness--;
				nextTran = this.selectNextTransition();
			}
			if (deepness == 0 && start == false) {
				return null;
			}
			start = false;
			context.getDesignSpaceManager().fireActivation(nextTran);
			patchSize--;
			deepness++;
			actualState.addStep(nextTran);
		}
		return generateStupidBee(actualState);
	}

	private synchronized StupidBee generateStupidBee(TrajectoryInfo actualState) {
		StupidBee sb = new StupidBee();
		sb.init(actualState, BeeType.Neighbour, context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(actualState, context.getLastFitness());
		sb.setTrajectoryFitness(tf);
		// patch.getBeeList().add(sb);
		// this.numberOfActiveBees++;
		// TODO szinkronizálni!!!!!!!!!!
		this.patch.getBeeList().add(sb);
		this.bs.increasenumberOfActiveBees();
		this.sb = sb;
		// System.out.println("hali");
		//TODO
		//System.out.println(sb.getActualState().getCurrentState().getId());
		this.interruptStrategy();
		return sb;

	}

	private void setThreadContextTo(TrajectoryInfo patch) {
		DesignSpaceManager dsm = context.getDesignSpaceManager();
		while (dsm.getTrajectoryFromRoot().size() != 0) {
			dsm.undoLastTransformation();
		}
		List<ITransition> transitions = patch.getFullTransitionTrajectory();
		for (ITransition iTransition : transitions) {
			System.out.print(" allapot " + dsm.getCurrentState().getId() + " ");
			dsm.fireActivation(iTransition);
			System.out.println(iTransition.getId() + " " + dsm.getCurrentState().getId());
		}

	}

	// --------------- getters and setters --------------------

	public ThreadContext getContext() {
		return context;
	}

	public void setContext(ThreadContext context) {
		this.context = context;
	}

	@Override
	public void setStopCond(Object stopcond) {
		this.patchSize = (Integer) stopcond;

	}

	@Override
	public void setIfNeighbour(Boolean neighbour) {
		this.neighbour = neighbour;

	}

	@Override
	public String getID() {
		return this.id;
	}

	public void setBs(BeeStrategy3 beeStrategy) {
		this.bs = beeStrategy;

	}

	public Patch getPatch() {
		return patch;
	}

	public StupidBee getSb() {
		return sb;
	}

	public void setSb(StupidBee sb) {
		this.sb = sb;
	}

	@Override
	public void setMainStrategy(IStrategy beeStrategy) {
		this.bs = (BeeStrategy3) beeStrategy;

	}

	@Override
	public void setStatesInTrajectory(HashSet<IState> states) {
		// TODO Auto-generated method stub
		
	}

}
