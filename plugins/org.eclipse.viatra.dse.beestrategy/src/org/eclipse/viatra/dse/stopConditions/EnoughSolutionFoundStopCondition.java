package org.eclipse.viatra.dse.stopConditions;

import java.util.ArrayList;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class EnoughSolutionFoundStopCondition implements IStopCondition{

	ArrayList<TrajectoryFitness> solutions = new ArrayList<TrajectoryFitness>();
	Integer NumberOfSolutions;
	ThreadContext context;
	
	@Override
	public Boolean isStopConditionReached() {
		if(solutions.size()>=NumberOfSolutions){
			return true;
		}			
		return false;
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
		return null;
	}

	@Override
	public void setContext(ThreadContext context) {
		this.context=context;
	}
	
	public ArrayList<TrajectoryFitness> getSolutions() {
		return solutions;
	}

	public void setSolutions(ArrayList<TrajectoryFitness> solutions) {
		this.solutions = solutions;
	}

	public Integer getNumberOfSolutions() {
		return NumberOfSolutions;
	}

	public void setNumberOfSolutions(Integer numberOfSolutions) {
		NumberOfSolutions = numberOfSolutions;
	}
	
	public void addSolution(TrajectoryFitness tf){
		this.solutions.add(tf);
	}
	
	public void addSolution(){
		if(this.context.calculateFitness().isSatisifiesHardObjectives()){
			this.solutions.add(new TrajectoryFitness(context.getDesignSpaceManager().getTrajectoryInfo().clone(), context.getLastFitness()));
		}
	}


}
