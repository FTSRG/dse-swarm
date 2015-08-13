package stopConditions;

import java.util.Collection;

import org.eclipse.viatra.dse.designspace.api.IState;

public class NumberOfFiredTransitionCondition implements IStopCondition{
	Integer NumberOfFiredTransitions;
	Integer StopCond;
	@Override
	public Boolean isStopConditionReached() {
		if(StopCond>NumberOfFiredTransitions) return false;
		return true;
	}
	@Override
	public void setStopConditon(Object StopCondition) {
		StopCond = (Integer) StopCondition;
		NumberOfFiredTransitions = 0;
		
	}
	
	@Override
	public void newFireTransitionHappend(IState reachedState) {
		this.NumberOfFiredTransitions++;
		
	}
	
	
	// ----------------------------------- unused methods of the interface --------------------------------- 
	@Override
	public void stepBackHappend(IState stepedBackTo) {
	}


	@Override
	public void newIteration() {
		
		
	}
	
	@Override
	public void setStopConditon(Collection collectionOfStopConditions) {
		
	}
	
	
}
