package org.eclipse.viatra.dse.combineStrategies.ministrategy;

import java.util.HashSet;
import java.util.Random;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class StepBackMiniStrategy extends AbstractMiniStrategy {

	public StepBackMiniStrategy(StrategyCombiner bs) {
		super(bs);
	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		return new ShortenTrajectory(bs);
	}

	@Override
	public void explore() {

		for (ITransition tran : this.searchData.getParentTrajectory().getFullTransitionTrajectory()) {

			if (dsm.getTransitionsFromCurrentState().contains(tran)) {
				dsm.fireActivation(tran);
				
			}

		}
		dsm.undoLastTransformation();
		searchData.setParentTrajectory(dsm.getTrajectoryInfo());
		searchData.setActualState(dsm.getTrajectoryInfo());
		searchData.setOwnfitness(context.calculateFitness());
		searchData.setOwntrajectoryFitness(new TrajectoryFitness(searchData.getActualState(), context.getLastFitness()));

	}

	@Override
	public void setStatesInTrajectory(HashSet<IState> states) {

	}

}
