package org.eclipse.viatra.dse.stopConditions;

import java.util.ArrayList;

import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;

public class CombinedStopCondition implements IStopCondition {
	ArrayList<IStopCondition> stopConditions;
	Boolean justOneSatisfied = true;

	@Override
	public Boolean isStopConditionReached() {
		if(stopConditions==null) throw new DSEException("stop conditions is not found");
		if(justOneSatisfied){
			for(int i=0; i<stopConditions.size(); i++){
				if(stopConditions.get(i).isStopConditionReached()==true)
					return true;
			}
			return false;
		}
		Boolean allreached = true;
		for(int i=0; i<stopConditions.size(); i++){
			if(stopConditions.get(i).isStopConditionReached()==false){
				allreached = false;
				break;
			}
		}
		return allreached;
	}

	@Override
	public void newFireTransitionHappend(IState reachedState) {
		for (int i=0; i<this.stopConditions.size(); i++){
			stopConditions.get(i).newFireTransitionHappend(reachedState);
		}
		
	}

	@Override
	public void stepBackHappend(IState stepedBackTo) {
		for (int i=0; i<this.stopConditions.size(); i++){
			stopConditions.get(i).stepBackHappend(stepedBackTo);
		}
		
	}
	public void setisOrType(Boolean justOneSatisfied){
		this.justOneSatisfied = justOneSatisfied;
	}
	@Override
	public void newIteration() {
		for (int i=0; i<this.stopConditions.size(); i++){
			stopConditions.get(i).newIteration();
		}
		
	}

	@Override
	public IStopCondition createNew(Object StopCondition) {
		CombinedStopCondition newStopCondition = new CombinedStopCondition();
		newStopCondition.setisOrType(this.justOneSatisfied);
		for (int i=0; i<this.stopConditions.size(); i++){
			newStopCondition.addStopCondition(this.stopConditions.get(i).createNew(StopCondition));
		}
		return newStopCondition;
	}

	@Override
	public void setContext(ThreadContext context) {
		for (int i=0; i<this.stopConditions.size(); i++){
			this.stopConditions.get(i).setContext(context);
		}
		
	}
	public void addStopCondition(IStopCondition newStopCond){
		if(this.stopConditions==null){
			this.stopConditions = new ArrayList<IStopCondition>();
		}
		stopConditions.add(newStopCond);
	}
	
	
	
	
}
