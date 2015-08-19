package org.eclipse.viatra.dse.stopConditions;

import java.util.Collection;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;

public class NumberOfReachedNewStatesCondition implements IStopCondition{
	Integer numberOfFiredTransitions;
	Integer maxNumberOfFiredTransitions;
	@Override
	
	public Boolean isStopConditionReached() {
		if(maxNumberOfFiredTransitions>numberOfFiredTransitions) return false;
		return true;
	}
	
	public void setMaxNumberOfFiredTransitions(Integer StopCondition) {
		maxNumberOfFiredTransitions =  StopCondition;
		numberOfFiredTransitions = 0;
		
	}

	@Override
	public void newFireTransitionHappend(IState reachedState) {
		this.numberOfFiredTransitions++;
		
	}
	@Override
	public void stepBackHappend(IState stepedBackTo) {
		this.numberOfFiredTransitions--;
	}
	
	
	//--------------------------- unused methods ----------------------------------------



	@Override
	public void newIteration() {
		
		
	}

	@Override
	public IStopCondition createNew(Object StopCondition) {
		
		NumberOfReachedNewStatesCondition stopcondClass = new NumberOfReachedNewStatesCondition();
		stopcondClass.setMaxNumberOfFiredTransitions(maxNumberOfFiredTransitions);
		return stopcondClass;
	}

	@Override
	public void setContext(ThreadContext context) {
		
	}

}
