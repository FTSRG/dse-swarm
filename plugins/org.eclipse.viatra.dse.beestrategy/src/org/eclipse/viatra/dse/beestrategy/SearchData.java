package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class SearchData {
	// is it random/neighbourBee
	private Boolean hasParent;
	// if it has Child than we should not use it
	private Boolean hasChild;

	private TrajectoryInfo parentTrajectory;
	private TrajectoryInfo actualState;
	private Fitness parentfitness;
	private Fitness ownfitness;

	private TrajectoryFitness owntrajectoryFitness;
	private ICreateBee strategy;
	private Object stopCond;

	public Object getStopCond() {
		return stopCond;
	}

	public void setStopCond(Object stopCond) {
		this.stopCond = stopCond;
	}

	public ICreateBee getStrategy() {
		return strategy;
	}

	public void setStrategy(ICreateBee strategy) {
		this.strategy = strategy;
	}

	public Fitness getOwnfitness() {
		return ownfitness;
	}

	public void setOwnfitness(Fitness ownfitness) {
		this.ownfitness = ownfitness;
	}

	public TrajectoryFitness getOwntrajectoryFitness() {
		return owntrajectoryFitness;
	}

	public void setOwntrajectoryFitness(TrajectoryFitness owntrajectoryFitness) {
		this.owntrajectoryFitness = owntrajectoryFitness;
	}



	public Boolean getHasParent() {
		return hasParent;
	}

	public void setHasParent(Boolean hasParent) {
		this.hasParent = hasParent;
	}

	public Boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	public TrajectoryInfo getParentTrajectory() {
		return parentTrajectory;
	}

	public void setParentTrajectory(TrajectoryInfo parentTrajectory) {
		if (parentTrajectory == null)
			this.parentTrajectory = null;
		else
			this.parentTrajectory = parentTrajectory.clone();
	}

	public TrajectoryInfo getActualState() {
		return actualState;
	}

	public void setActualState(TrajectoryInfo actualState) {
		if (actualState == null)
			this.actualState = null;
		else
		this.actualState = actualState.clone();
	}

	public Fitness getParentfitness() {
		return parentfitness;
	}

	public void setParentfitness(Fitness parentfitness) {
		this.parentfitness = parentfitness;
	}

}
