package stopConditions;

import java.util.Collection;

import org.eclipse.viatra.dse.designspace.api.IState;

public interface IStopCondition {
	public Boolean isStopConditionReached();
	public void setStopConditon(Object StopCondition);
	public void setStopConditon(Collection<?> collectionOfStopConditions);
	public void newFireTransitionHappend(IState reachedState);
	public void stepBackHappend(IState stepedBackTo);
	public void newIteration();
}
