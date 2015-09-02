package org.eclipse.viatra.dse.stopConditions;

import java.util.Collection;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;

public class NumberOfFiredTransitionCondition implements IStopCondition{
	Integer numberOfFiredTransitions;
	Integer maxNumberOfFiredTransitons;
	@Override
	public Boolean isStopConditionReached() {
		if(maxNumberOfFiredTransitons>numberOfFiredTransitions) return false;
		return true;
	}

	public void setMaxNumberOfFiredTransitions(Integer radius) {
		this.maxNumberOfFiredTransitons = radius;
		this.numberOfFiredTransitions = 0;
		
	}
	
	@Override
	public void newFireTransitionHappend(IState reachedState) {
		this.numberOfFiredTransitions++;
		
	}
	
	@Override
	public IStopCondition createNew(Object StopCondition) {
		NumberOfFiredTransitionCondition newStopCond = new NumberOfFiredTransitionCondition();
		newStopCond.setMaxNumberOfFiredTransitions(this.maxNumberOfFiredTransitons);
		return newStopCond;
		
	}
	
	// ----------------------------------- unused methods of the interface --------------------------------- 
	@Override
	public void stepBackHappend(IState stepedBackTo) {
	}


	@Override
	public void newIteration() {
		
		
	}

	@Override
	public void setContext(ThreadContext context) {		
	}
	

	
	
}
