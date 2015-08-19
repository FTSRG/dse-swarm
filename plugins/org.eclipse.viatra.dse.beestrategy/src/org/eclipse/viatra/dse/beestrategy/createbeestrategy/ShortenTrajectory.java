package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.HashSet;
import java.util.Random;

import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class ShortenTrajectory extends AbstractMiniStrategy{

	public ShortenTrajectory(StrategyCombiner bs) {
		super(bs);
	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		return new ShortenTrajectory(bs);
	}

	@Override
	public void explore() {
		Random randgen = new Random();		
		int low = 0;
		int high = this.searchData.getParentTrajectory().getDepthFromCrawlerRoot()-1;
		int randomNumber = randgen.nextInt(high-low) + low;
		TrajectoryInfo newti = new TrajectoryInfo(this.bs.getRootState(), this.bs.getRootTrajectory());
		for (ITransition tran  :  this.searchData.getParentTrajectory().getFullTransitionTrajectory()) {
			if(randomNumber!=0){
				randomNumber--;
				if(dsm.getTransitionsFromCurrentState().contains(tran)){
					dsm.fireActivation(tran);
					newti.addStep(tran);
				}					
			}
		}
		searchData.setActualState(newti);
		searchData.setOwnfitness(context.calculateFitness());
		searchData.setOwntrajectoryFitness(new TrajectoryFitness(searchData.getActualState(), context.getLastFitness()));

	}
	
	@Override
	public void setStatesInTrajectory(HashSet<IState> states) {
		
	}

}
