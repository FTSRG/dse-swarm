package org.eclipse.viatra.dse.combineStrategies.ministrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

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

public class RandomHillClimbingMiniStrategy extends AbstractMiniStrategy {
	enum HillClimbingStrategyState {
		TRY_AND_SAVE, COMPARE_AND_STEP
	}

	private Collection<ITransition> besttransitions;
	private DesignSpaceManager dsm;
	private Random rand = new Random();

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

	public RandomHillClimbingMiniStrategy(StrategyCombiner bs) {
		super(bs);
	}
	//
	// public CreateBeeWithHillClimbing() {
	// this(1.001);
	// }
	//
	// public CreateBeeWithHillClimbing(double percentOfOpenedStates) {
	// this.percentOfOpenedStates = percentOfOpenedStates;
	// filterOptions = new FilterOptions().nothingIfCut().untraversedOnly();
	// }

	// public void init(ThreadContext context) {
	// this.context = context;
	// dsm = context.getDesignSpaceManager();
	// objectiveComparatorHelper = context.getObjectiveComparatorHelper();
	// solutionStore = context.getGlobalContext().getSolutionStore();
	// if (!solutionStore.isStrategyDependent()) {
	// throw new DSEException("This strategy needs a strategy dependent solution
	// store.");
	// }
	// }

	public void newStateIsProcessed(boolean isAlreadyTraversed, Fitness fitness, boolean constraintsNotSatisfied) {

		if (dsm.getTrajectoryInfo().getDepthFromRoot() == 0) {
			bestFitness = fitness;
			logger.debug("Fitness of the root state: " + fitness);
			return;
		}

		if (state == HillClimbingStrategyState.TRY_AND_SAVE) {
			if (!constraintsNotSatisfied) {
				logger.debug("Fitness of last transformation: " + fitness);
				objectiveComparatorHelper.addTrajectoryFitness(
						new TrajectoryFitness(dsm.getTrajectoryInfo().getLastTransition(), fitness));
			} else {
				logger.debug("Global constraints are unsatisfied.");
			}
			dsm.undoLastTransformation();
			searchData.stopCond.stepBackHappend(dsm.getCurrentState());
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
		ITransition bestTransition = null;
		Collection<? extends ITransition> transitions = null;
		bestFitness = null;

		if (besttransitions == null) {
			besttransitions = new ArrayList<ITransition>();
			transitions = dsm.getTransitionsFromCurrentState(filterOptions);
			if (transitions.size() == 0)
				return null;
			bestTransition = transitions.iterator().next();
			Fitness bestFitness = null;
			Iterator<? extends ITransition> it = transitions.iterator();
			//int rounds = rand.nextInt(transitions.size() / 1) + 1;
			int rounds = 1;
			int actround = 0;
			System.out.println(rounds);
			while (it.hasNext()) {
				actround++;
				if (actround % rounds == 0) {
					ITransition actualTran = it.next();
					// System.out.print(actualTran + " from: "+
					// dsm.getCurrentState());
					dsm.fireActivation(actualTran);
					// System.out.println(" "+context.calculateFitness());
					if (bestFitness == null) {
						bestFitness = context.calculateFitness();
					} else {
						if (context.getObjectiveComparatorHelper().compare(context.calculateFitness(), bestFitness) == 1
								&& !this.statesInTrajectory.contains(dsm.getCurrentState())) {
							bestFitness = context.getLastFitness();
							bestTransition = actualTran;
						}
					}
					dsm.undoLastTransformation();
				}
				if(bestTransition == null){
					
				}
			}
			it = transitions.iterator();
			if (searchData.getParentfitness() != null && context.getObjectiveComparatorHelper().compare(bestFitness,
					searchData.getParentfitness()) == -1) {
				return null;
			}
			while (it.hasNext()) {
				ITransition actualTran = it.next();
				dsm.fireActivation(actualTran);

				if (context.getObjectiveComparatorHelper().compare(context.calculateFitness(), bestFitness) != -1
						&& !this.statesInTrajectory.contains(dsm.getCurrentState())) {
					this.besttransitions.add(actualTran);
				}

				dsm.undoLastTransformation();
			}
		}
		if (besttransitions.size() == 0) {
			return null;
		}

		bestTransition = besttransitions.iterator().next();

		// System.out.println("selected transition: "+bestTransition);
		besttransitions.remove(bestTransition);
		return bestTransition;

	}

	@Override
	public void explore() {
		this.objectiveComparatorHelper
				.addTrajectoryFitness(new TrajectoryFitness(dsm.getTrajectoryInfo(), context.calculateFitness()));
		this.bestFitness = context.getLastFitness();
		System.out.println(this.getClass().getName() + ".createBee");
		if (this.searchData == null || this.searchData.getActualState() == null || this.searchData.stopCond == null) {
			return;
		}

		boolean start = true;
		Integer deepness = 0;

		// step patchsize many steps
		while (!searchData.stopCond.isStopConditionReached()) {
			ITransition nextTran = this.selectNextTransition();
			while (nextTran == null && deepness >= 0) {
				dsm.undoLastTransformation();
				besttransitions = null;
				searchData.stopCond.stepBackHappend(dsm.getCurrentState());
				deepness--;
				nextTran = this.selectNextTransition();
			}
			if (deepness == 0 && start == false || nextTran == null) {
				this.searchData.setParentTrajectory(null);
				// System.out.println("return :
				// CreateBeeWith_nextTranselection");
				return;
			}
			// System.out.println("CreateBeeWith_nextTranselection");
			start = false;
			dsm.fireActivation(nextTran);
			System.out.println("do");
			Fitness actualFitness = context.calculateFitness();
			searchData.stopCond.newFireTransitionHappend(dsm.getCurrentState());
			if (isAlreadyFoundInThisTrajectory(dsm.getCurrentState())) {
				dsm.undoLastTransformation();
				// System.out.println("undo");
				searchData.stopCond.stepBackHappend(dsm.getCurrentState());
				deepness--;
			} else {
				this.besttransitions = null;
			}
			deepness++;

		}
		this.searchData.setActualState(context.getDesignSpaceManager().getTrajectoryInfo());
		this.searchData.setOwnfitness(context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(searchData.getActualState(), context.getLastFitness());
		this.searchData.setOwntrajectoryFitness(tf);

	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		return new CreateBeeWithHillClimbing(bs);
	}

}
