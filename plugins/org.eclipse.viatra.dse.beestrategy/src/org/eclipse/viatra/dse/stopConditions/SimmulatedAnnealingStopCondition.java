package org.eclipse.viatra.dse.stopConditions;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.objectives.Fitness;

/**
 * 
 * @author It will go down from 1 to 0 and if it will reach 0 it will stop
 *
 */
public class SimmulatedAnnealingStopCondition implements IStopCondition {
	private Double temperature;
	private Boolean isHardObjectivesSatisfied = false;
	private ThreadContext context;

	@Override
	public Boolean isStopConditionReached() {
		return  (isHardObjectivesSatisfied || temperature == 0);
		
	}

	@Override
	public void newFireTransitionHappend(IState reachedState) {

		if (!isHardObjectivesSatisfied) {
			isHardObjectivesSatisfied = context.getLastFitness().isSatisifiesHardObjectives();
		}

	}

	@Override
	public void stepBackHappend(IState stepedBackTo) {

	}

	@Override
	public void newIteration() {
		if(temperature<0.1) temperature=0.0;
		else temperature= temperature -0.1;
	}

	@Override
	public IStopCondition createNew(Object StopCondition) {
		SimmulatedAnnealingStopCondition newCondition = new SimmulatedAnnealingStopCondition();
		newCondition.setT((Double)StopCondition);
		return newCondition;
	}

	@Override
	public void setContext(ThreadContext context) {
		this.context = context;

	}
	
	public void setT(Double temerature){
		this.temperature = temerature;
	}
	
	public Double getT(){
		 return temperature;
	}

}
