package stopConditions;

import java.util.Collection;

import org.eclipse.viatra.dse.designspace.api.IState;

public class NumberOfReachedNewStatesCondition implements IStopCondition{
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
	@Override
	public void stepBackHappend(IState stepedBackTo) {
		this.NumberOfFiredTransitions--;
	}
	
	
	//--------------------------- unused methods ----------------------------------------
	@Override
	public void setStopConditon(Collection collectionOfStopConditions) {
		
	}


	@Override
	public void newIteration() {
		
		
	}
}
