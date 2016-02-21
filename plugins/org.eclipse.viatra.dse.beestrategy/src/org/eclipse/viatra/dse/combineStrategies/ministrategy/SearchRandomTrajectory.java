package org.eclipse.viatra.dse.combineStrategies.ministrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class SearchRandomTrajectory extends AbstractMiniStrategy {
	static Random randgen;

	public SearchRandomTrajectory(StrategyCombiner bs) {
		super(bs);
		if (randgen == null)
			randgen = new Random();
	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		// TODO Auto-generated method stub
		return new SearchRandomTrajectory(bs);
	}

	@Override
	public void explore() {
		while(dsm.undoLastTransformation()==true);

		int low = 0;
		int high = 100;
		int randomNumber = randgen.nextInt(high - low) + low;
		
		while (randomNumber > 0) {
			ITransition tran = selectNextTransition();
			while (tran == null) {
				low = 1;
				high = dsm.getTrajectoryFromRoot().size();
				if(high<10){high = 10;}
				int stepBack = randgen.nextInt(high - low) + low;
				System.out.println(stepBack);
				while (stepBack > 0) {
					dsm.undoLastTransformation();
					stepBack--;					
				}
				tran = selectNextTransition();
			}
			dsm.fireActivation(tran);
			randomNumber--;
		}
		System.out.println("SearchRandomStrategy: ");
		List<Object> traj= dsm.getTrajectoryFromRoot();
		for (Object object : traj) {
			System.out.print(object+" ");
		}
		System.out.println("end randomsearched traj");
		searchData.setActualState(dsm.getTrajectoryInfo());
		searchData.setOwnfitness(context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(searchData.getActualState(), context.getLastFitness());
		searchData.setOwntrajectoryFitness(tf);
	}

	private ITransition selectNextTransition() {
		Collection<? extends ITransition> transitions = dsm.getTransitionsFromCurrentState();
		if(transitions.size()==0) {
			System.out.println("ok, hogy null");
			return null;
		}
		int low = 0;
		int high = transitions.size() - 1;
		int randomNumber = randgen.nextInt(high - low) + low;
		int steps= 0;
//		System.out.println("random num"+randomNumber);
		Iterator<?> it = transitions.iterator();
		ITransition nextTran = null;
		while (randomNumber> -1 && it.hasNext()) {
			nextTran = (ITransition) it.next();
			randomNumber--;
			steps++;
		}
		if(nextTran == null) System.out.println("nem ok, hogy null" + transitions.size() +" "+ steps);
		return nextTran;
	}

}
