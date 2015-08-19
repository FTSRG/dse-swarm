package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.stopConditions.SimmulatedAnnealingStopCondition;

public class SimulatedAnnealingMiniStrategy extends AbstractMiniStrategy {

	private Collection<? extends ITransition> transitions;
	private FilterOptions filterOptions;
	private Fitness lastFitness;
	private Fitness bestFitnessInNextStep;
	private Random randgen = new Random();
	private SimmulatedAnnealingStopCondition stopCond;

	public SimulatedAnnealingMiniStrategy(StrategyCombiner bs) {
		super(bs);
	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		return new SimulatedAnnealingMiniStrategy(bs);

	}

	@Override
	public void explore() {
		lastFitness = searchData.getParentfitness();
		while (!searchData.stopCond.isStopConditionReached()) {

			ITransition actualtran = selectNextStep();
			if(context.getObjectiveComparatorHelper().compare(lastFitness, bestFitnessInNextStep)!=1){
				dsm.fireActivation(actualtran);
				stopCond.newFireTransitionHappend(dsm.getCurrentState());
				transitions = null;
			}
			else{
				double randomNumber = randgen.nextDouble();
				if (randomNumber<stopCond.getT()){
					dsm.fireActivation(actualtran);
					stopCond.newFireTransitionHappend(dsm.getCurrentState());
					transitions = null;
				}				
			}
		stopCond.newFireTransitionHappend(dsm.getCurrentState());;
		}
	}

	ITransition selectNextStep() {
		ITransition bestTransition = null;

		if (transitions == null) {
			transitions = dsm.getTransitionsFromCurrentState(filterOptions);
			if (transitions.size() == 0)
				return null;
		}
		bestTransition = transitions.iterator().next();
		Fitness bestFitness = null;
		Iterator<? extends ITransition> it = transitions.iterator();
		while (it.hasNext()) {
			ITransition actualTran = it.next();
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
		transitions.remove(bestTransition);
		return bestTransition;

	}

}
