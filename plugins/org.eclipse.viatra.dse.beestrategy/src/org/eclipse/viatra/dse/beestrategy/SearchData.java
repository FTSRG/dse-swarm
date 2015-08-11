package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class SearchData {
	//is it random/neighbourBee
	private Boolean hasParent;
	//if it has Child than we should not use it 
	private Boolean hasChild;
	
	private TrajectoryInfo parentTrajectory;
	private TrajectoryInfo actualState;
	private Fitness parentfitness;
	private Fitness ownfitness;


	private TrajectoryFitness owntrajectoryFitness;
	private ICreateBee strategy;
	private Integer radius;



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

	
	public Integer getRadiusSize() {
		return radius;
	}

	public void setRadiusSize(Integer radius) {
		this.radius = radius;
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
		this.parentTrajectory = parentTrajectory;
	}

	public TrajectoryInfo getActualState() {
		return actualState;
	}

	public void setActualState(TrajectoryInfo actualState) {
		this.actualState = actualState;
	}

	public Fitness getParentfitness() {
		return parentfitness;
	}

	public void setParentfitness(Fitness parentfitness) {
		this.parentfitness = parentfitness;
	}




	public Integer getPatchSize() {
		return radius;
	}

	public void setPatchSize(Integer patchSize) {
		this.radius = patchSize;
	}


}
