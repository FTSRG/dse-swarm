package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.ObjectiveComparatorHelper;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class DFSWithHillClimbingMiniStrategy extends AbstractMiniStrategy {
	enum HillClimbingStrategyState {
		TRY_AND_SAVE, COMPARE_AND_STEP
	}

	private Collection<? extends ITransition> besttransitions;
	private DesignSpaceManager dsm;

	
	
	private HillClimbingStrategyState state = HillClimbingStrategyState.TRY_AND_SAVE;

	
	private Fitness bestFitness = null;
	

	private ObjectiveComparatorHelper objectiveComparatorHelper;

	

	private Logger logger = Logger.getLogger(getClass());

	private FilterOptions filterOptions = new FilterOptions().nothingIfCut().untraversedOnly();

	

	// private Integer patchSize;

	@Override
	public void setSearchData(SearchData sd) {
		this.searchData = sd;
	}

	public DFSWithHillClimbingMiniStrategy(StrategyCombiner bs) {
		super(bs);
	}
	

	public void newStateIsProcessed(boolean isAlreadyTraversed, Fitness fitness, boolean constraintsNotSatisfied) {

		if (dsm.getTrajectoryInfo().getDepthFromRoot() == 0) {
			bestFitness = fitness;
			logger.debug("Fitness of the root state: " + fitness);
			return;
		}

		

	}

	public void interrupted() {
		interrupted = true;

	}

	@Override
	public void initStrategy(ThreadContext context) {
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		logger.debug("Initied");
		this.objectiveComparatorHelper = context.getObjectiveComparatorHelper();
		this.besttransitions = null;

	}




	ITransition selectNextTransition() {
		Collection<? extends ITransition> transitions = null;
		bestFitness = context.calculateFitness();
		
		besttransitions = dsm.getTransitionsFromCurrentState(filterOptions);
		Iterator<? extends ITransition> it = besttransitions.iterator();
		while(it.hasNext()){
			ITransition actualTran = it.next();
			dsm.fireActivation(actualTran);
			it.remove();
			
			if (context.getObjectiveComparatorHelper().compare(context.calculateFitness(), bestFitness) == 1
					&& !this.statesInTrajectory.contains(dsm.getCurrentState())){
				System.out.println(actualTran);
				dsm.undoLastTransformation();
				return actualTran;
			}
			dsm.undoLastTransformation();
			
			
		}
		return null;
	}

	@Override
	public void explore() {
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
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		return new CreateBeeWithHillClimbing(bs);
	}

}
