package org.eclipse.viatra.dse.stopConditions;

import java.util.Collection;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;

public interface IStopCondition {
	public Boolean isStopConditionReached();

	public void newFireTransitionHappend(IState reachedState);
	public void stepBackHappend(IState stepedBackTo);
	public void newIteration();
	public IStopCondition createNew(Object StopCondition);
	public void setContext(ThreadContext context);
}
