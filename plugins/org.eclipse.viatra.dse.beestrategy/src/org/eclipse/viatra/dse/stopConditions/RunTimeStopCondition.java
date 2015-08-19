package org.eclipse.viatra.dse.stopConditions;

import java.sql.Time;
import java.util.Collection;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;

public class RunTimeStopCondition implements IStopCondition {

	@Override
	public Boolean isStopConditionReached() {
		return null;
	}



	@Override
	public void newFireTransitionHappend(IState reachedState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepBackHappend(IState stepedBackTo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newIteration() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public IStopCondition createNew(Object StopCondition) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setContext(ThreadContext context) {
	}


	
}
