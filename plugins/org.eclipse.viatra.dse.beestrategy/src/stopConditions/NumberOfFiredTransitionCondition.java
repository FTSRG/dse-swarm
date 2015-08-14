package stopConditions;

import java.util.Collection;

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
		radius = radius;
		numberOfFiredTransitions = 0;
		
	}
	
	@Override
	public void newFireTransitionHappend(IState reachedState) {
		this.numberOfFiredTransitions++;
		
	}
	
	@Override
	public IStopCondition createNew(Object StopCondition) {
		NumberOfFiredTransitionCondition stopcondClass = new NumberOfFiredTransitionCondition();
		stopcondClass.setMaxNumberOfFiredTransitions(maxNumberOfFiredTransitons);
		return stopcondClass;
		
	}
	
	// ----------------------------------- unused methods of the interface --------------------------------- 
	@Override
	public void stepBackHappend(IState stepedBackTo) {
	}


	@Override
	public void newIteration() {
		
		
	}
	

	
	
}
