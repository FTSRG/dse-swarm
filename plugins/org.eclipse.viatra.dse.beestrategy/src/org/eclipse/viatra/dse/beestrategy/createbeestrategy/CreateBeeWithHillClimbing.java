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

public class CreateBeeWithHillClimbing extends AbstractMiniStrategy {
	enum HillClimbingStrategyState {
		TRY_AND_SAVE, COMPARE_AND_STEP
	}

	private Collection<ITransition> besttransitions;
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

	public CreateBeeWithHillClimbing(StrategyCombiner bs) {
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

	// @Override
	// public Patch createRandomBee() {
	// while (dsm.getTrajectoryFromRoot().size() != 0) {
	// dsm.undoLastTransformation();
	// }
	// TrajectoryInfo ti = dsm.getTrajectoryInfo().clone();
	// while (patchSize > 0) {
	// ITransition nextTran = selectNextTransition(true);
	// while (nextTran == null && dsm.getTrajectoryFromRoot().size() >= 0) {
	// dsm.undoLastTransformation();
	// nextTran = selectNextTransition(true);
	// ti.stepBack();
	// }
	// if (nextTran == null && dsm.getTrajectoryFromRoot().size() == 0) return
	// null;
	//
	// dsm.fireActivation(nextTran);
	// if (this.isAlreadyFoundInThisStrategy(dsm.getCurrentState()))
	// dsm.undoLastTransformation();
	//
	// patchSize--;
	// }
	// Patch p = new Patch();
	// if (ti.getTransitionTrajectory().size() != 0)
	// p.initPatch(ti, context);
	// p.setBestfitness(context.calculateFitness());
	// p.initPatch(context.getDesignSpaceManager().getTrajectoryInfo(),
	// context);
	// this.patch = p;
	// return p;
	// }

	// public boolean isAlreadyFoundInThisStrategy(IState iState){
	// if(this.alreadyFoundStates==null){
	// alreadyFoundStates = new HashSet<IState>();
	// alreadyFoundStates.add(iState);
	// return false;
	// }
	// return alreadyFoundStates.add(iState);
	//
	// }

	// @Override
	// public StupidBee createNeighbourBee() {
	// boolean start = true;
	// Integer deepness = 0;
	// TrajectoryInfo actualState = patch.getPatch().clone();
	// // this.setThreadContextTo(patch.getPatch());
	//
	// // step patchsize many steps
	// for (int i = 0; i < patchSize; i++) {
	// ITransition nextTran = this.selectNextTransition(true);
	// while (nextTran == null && deepness >= 0) {
	// dsm.undoLastTransformation();
	// actualState.stepBack();
	// deepness--;
	// nextTran = this.selectNextTransition(false);
	// }
	// if (deepness == 0 && start == false) {
	// return null;
	// }
	// start = false;
	// context.getDesignSpaceManager().fireActivation(nextTran);
	// patchSize--;
	// deepness++;
	// actualState.addStep(nextTran);
	// }
	// return generateStupidBee(actualState);
	// }

	// private synchronized StupidBee generateStupidBee(TrajectoryInfo
	// actualState) {
	// StupidBee sb = new StupidBee();
	// sb.init(actualState, BeeType.Neighbour, context.calculateFitness());
	// TrajectoryFitness tf = new TrajectoryFitness(actualState,
	// context.getLastFitness());
	// sb.setTrajectoryFitness(tf);
	// // patch.getBeeList().add(sb);
	// // this.numberOfActiveBees++;
	// // szinkronizálni!!!!!!!!!!
	// this.patch.getBeeList().add(sb);
	// this.bs.increasenumberOfActiveBees();
	// this.sb = sb;
	// // System.out.println("hali");
	// //System.out.println(sb.getActualState().getCurrentState().getId());
	// this.interruptStrategy();
	// return sb;
	//
	// }

	// @Override
	// ITransition selectNextTransition() {
	// while (!interrupted && !searchData.stopCond.isStopConditionReached()) {
	// if (dsm.getTransitionsFromCurrentState().size() <= 0) {
	// return null;
	// }
	// Collection<? extends ITransition> transitions =
	// dsm.getTransitionsFromCurrentState(filterOptions);
	//
	// if (transitions.size() <= 0) {
	// logger.debug("No more transitions to try.");
	// return null;
	// }
	//
	// if (state == HillClimbingStrategyState.TRY_AND_SAVE) {
	// ITransition transition;
	// if (percentOfOpenedStates >= 1) {
	// transition = transitions.iterator().next();
	// } else {
	// if (percentOfOpenedStates <= triedTransitions /
	// dsm.getTransitionsFromCurrentState().size()) {
	// state = HillClimbingStrategyState.COMPARE_AND_STEP;
	// continue;
	// } else {
	// int index = rnd.nextInt(transitions.size());
	// Iterator<? extends ITransition> iterator = transitions.iterator();
	// while (iterator.hasNext() && index != 0) {
	// index--;
	// iterator.next();
	// }
	// transition = iterator.next();
	// }
	// triedTransitions++;
	// }
	// logger.debug("Trying " + transition.getId());
	// return transition;
	// } else {
	// logger.debug("Comparing fitnesses.");
	//
	// TrajectoryFitness bestTrajectoryFitness =
	// this.objectiveComparatorHelper.getRandomBest();
	// objectiveComparatorHelper.clearTrajectoryFitnesses();
	//
	// int compare = objectiveComparatorHelper.compare(bestFitness,
	// bestTrajectoryFitness.fitness);
	//
	// if (compare >= 0) {
	// context.calculateFitness();
	// logger.debug(dsm.getTrajectoryInfo().toString());
	// return null;
	// } else {
	// bestFitness = bestTrajectoryFitness.fitness;
	// }
	//
	// triedTransitions = 0;
	// state = HillClimbingStrategyState.TRY_AND_SAVE;
	//
	// ITransition bestTransition = bestTrajectoryFitness.trajectory[0];
	// logger.debug("Best transition: " + bestTransition.getId() + " with
	// fitness " + bestFitness);
	// dsm.fireActivation(bestTransition);
	// searchData.stopCond.newFireTransitionHappend(dsm.getCurrentState());
	// }
	//
	// }
	//
	// return null;
	// }


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
			System.out.println(transitions.toString());
			while (it.hasNext()) {
				ITransition actualTran = it.next();
				System.out.println(actualTran + " from: "+ dsm.getCurrentState());
				dsm.fireActivation(actualTran);
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
			it = transitions.iterator();
			if(context.getObjectiveComparatorHelper().compare(bestFitness, searchData.getParentfitness())==-1){
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
		if(besttransitions.size() == 0){
			return null;
		}
		
		bestTransition = besttransitions.iterator().next();

		System.out.println(bestTransition);
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
				System.out.println("undo");
				searchData.stopCond.stepBackHappend(dsm.getCurrentState());
				deepness--;
				nextTran = this.selectNextTransition();
			}
			if (deepness == 0 && start == false) {
				this.searchData.setParentTrajectory(null);
				return;
			}
			start = false;
			dsm.fireActivation(nextTran);
			System.out.println("do");
			searchData.stopCond.newFireTransitionHappend(dsm.getCurrentState());
			if (isAlreadyFoundInThisTrajectory(dsm.getCurrentState())) {
				dsm.undoLastTransformation();
				System.out.println("undo");
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
