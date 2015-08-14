package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class CreateBeeWithDFS extends AbstractMiniStrategy {

	
	FilterOptions fo = new FilterOptions().nothingIfCut().untraversedOnly();	
	private boolean interrupted;
	private Logger logger = Logger.getLogger(getClass());
	

	public boolean isInterrupted() {
		return interrupted;
	}
	public CreateBeeWithDFS(BeeStrategy3 bs){
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
		while (!searchData.stopCond.isStopConditionReached()) {
			ITransition nextTran = selectNextTransition();
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
				dsm.undoLastTransformation();
				searchData.stopCond.stepBackHappend(dsm.getCurrentState());
			}
		
		}
		searchData.setActualState(dsm.getTrajectoryInfo());
		searchData.setOwnfitness(context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(searchData.getActualState(), context.getLastFitness());
		searchData.setOwntrajectoryFitness(tf);
		
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



	// --------------- getters and setters --------------------





	

	public void setBs(BeeStrategy3 beeStrategy) {
		this.bs = beeStrategy;

	}
	@Override
	public IMiniStrategy createMiniStrategy(BeeStrategy3 bs){
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
