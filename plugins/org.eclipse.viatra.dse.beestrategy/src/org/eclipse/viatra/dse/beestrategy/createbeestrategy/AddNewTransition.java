package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class AddNewTransition extends AbstractMiniStrategy{
	
	protected AddNewTransition(BeeStrategy3 bs) {
		super(bs);
	}



	@Override
	public IMiniStrategy createMiniStrategy(BeeStrategy3 bs) {
		return new AddNewTransition(bs);
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
				try{
					dsm.fireActivation(tran);
					newti.addStep(tran);
					}
				catch (DSEException e){
					
				}				
			}
			else{
				if (selectNextTransition()!=null){
					dsm.fireActivation(tran);
					newti.addStep(tran);
				}
			}
		}
		searchData.setActualState(newti);
		searchData.setOwnfitness(context.calculateFitness());
		searchData.setOwntrajectoryFitness(new TrajectoryFitness(searchData.getActualState(), context.getLastFitness()));

	}
	
	private ITransition selectNextTransition(){
		Collection<? extends ITransition> transitions = dsm.getTransitionsFromCurrentState();
		Random randgen = new Random();
		int low = 0;
		int high = transitions.size()-1;
		int randomNumber = randgen.nextInt(high-low) + low;
		Iterator<?> it = transitions.iterator();
		ITransition nextTran = null;
		while(randomNumber!=0 && it.hasNext()){
			nextTran = (ITransition) it.next();
		}
		return nextTran;
		
	}
	
	@Override
	public void setStatesInTrajectory(HashSet<IState> states) {
		
	}

}
