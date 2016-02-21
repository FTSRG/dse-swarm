package org.eclipse.viatra.dse.combineStrategies.ministrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.IState.TraversalStateType;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class CreateBeeWithDFS extends AbstractMiniStrategy {

	
	FilterOptions fo = new FilterOptions().nothingIfCut().untraversedOnly();	
	private boolean interrupted;
	private Logger logger = Logger.getLogger(getClass());
	private Collection<? extends ITransition> transitions = null;
	

	public boolean isInterrupted() {
		return interrupted;
	}
	public CreateBeeWithDFS(StrategyCombiner bs){
		super(bs);
	}
	
	/**
	 * It will set ThreadContext and PatchSize (default == 1) if you would like
	 * to change patchsize you have to call setpatchsize
	 */
	@Override
	public synchronized void initStrategy(ThreadContext context) {
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		logger.debug("Initied");

	}

	@Override
	public synchronized void explore() {
		System.out.println("startingpoint2: "+dsm.getCurrentState());
		this.transitions=null;
		while (!searchData.stopCond.isStopConditionReached()) {			
			ITransition nextTran = selectNextTransition();
			Boolean stepped = true;
 			while (nextTran == null && dsm.getTrajectoryFromRoot().size() > 0) {
				dsm.undoLastTransformation();
				searchData.stopCond.stepBackHappend(dsm.getCurrentState());
				nextTran = selectNextTransition();
				
			}
			if (nextTran == null && dsm.getTrajectoryFromRoot().size() == 0){
				this.searchData=null;
				return;
			}
			dsm.fireActivation(nextTran);
			
			logger.debug("state: "+ context.getDesignSpaceManager().getCurrentState());
			searchData.stopCond.newFireTransitionHappend(dsm.getCurrentState());
			if (this.isAlreadyFoundInThisTrajectory(dsm.getCurrentState())){
				context.getDesignSpaceManager().getCurrentState().setTraversalState(TraversalStateType.TRAVERSED);
				dsm.undoLastTransformation();
				stepped = false;
				
				searchData.stopCond.stepBackHappend(dsm.getCurrentState());
			}
			System.out.println("stepped: "+stepped);
			if(stepped) this.transitions=null;
		
		}
		System.out.println(searchData.getActualState());
		searchData.setActualState(dsm.getTrajectoryInfo());
		searchData.setOwnfitness(context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(searchData.getActualState(), context.getLastFitness());
		searchData.setOwntrajectoryFitness(tf);
		
	}



	public ITransition selectNextTransition() {
		// if there is a state from here, which were not processed
		if(transitions==null){
			transitions = dsm.getTransitionsFromCurrentState(fo);
		}
		
		if (transitions.size() > 0) {
			int index = new Random().nextInt(transitions.size());
			Iterator<? extends ITransition> iterator = transitions.iterator();
			while (iterator.hasNext() && index != 0) {
				index--;
				iterator.next();
			}
			// give back the selected transition
			ITransition transition = iterator.next();
			iterator.remove();
			return transition;
		}
		this.transitions=null;
		return null;
	}



	// --------------- getters and setters --------------------





	

	public void setBs(StrategyCombiner beeStrategy) {
		this.bs = beeStrategy;

	}
	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs){
		return new CreateBeeWithDFS(bs);
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


	


}
