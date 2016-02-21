package org.eclipse.viatra.dse.stopConditions;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;

public class SolutionFoundStopCondition implements IStopCondition {
	Boolean isSolutionFound;
	ThreadContext context;

	@Override
	public Boolean isStopConditionReached() {		
		return context.calculateFitness().isSatisifiesHardObjectives();
	}

	@Override
	public void newFireTransitionHappend(IState reachedState) {	
	}

	@Override
	public void stepBackHappend(IState stepedBackTo) {
		
	}

	@Override
	public void newIteration() {		
	}

	@Override
	public IStopCondition createNew(Object StopCondition) {
		return new SolutionFoundStopCondition();
	}

	@Override
	public void setContext(ThreadContext context) {
		this.context = context;
		
	}
	
	
}
