package org.eclipse.viatra.dse.beestrategy;

import java.util.ArrayList;

import org.eclipse.viatra.dse.beestrategy.createbeestrategy.IMiniStrategy;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;

public class SearchData {
	private IMiniStrategy strategy;
	public IStopCondition stopCond;
	private ArrayList<SearchTrajectory> trajectories = new ArrayList<SearchTrajectory>();

	public ArrayList<SearchTrajectory> getTrajectories() {
		return trajectories;
	}

	public void setTrajectories(ArrayList<SearchTrajectory> trajectories) {
		this.trajectories = trajectories;
	}

	public IMiniStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IMiniStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Fitness getOwnfitness() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return this.trajectories.get(0).getOwnfitness();
	}

	public void setOwnfitness(Fitness ownfitness) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}
		this.trajectories.get(0).setOwnfitness(ownfitness);
	}

	public TrajectoryFitness getOwntrajectoryFitness() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return trajectories.get(0).getOwntrajectoryFitness();
	}

	public void setOwntrajectoryFitness(TrajectoryFitness owntrajectoryFitness) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}
		this.trajectories.get(0).setOwntrajectoryFitness(owntrajectoryFitness);
	}



	public Boolean getHasParent() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return this.trajectories.get(0).getHasParent();
	}

	public void setHasParent(Boolean hasParent) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}
		this.trajectories.get(0).setHasParent(hasParent);
	}

	public Boolean getHasChild() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return this.trajectories.get(0).getHasChild();
	}

	public void setHasChild(Boolean hasChild) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}
		this.trajectories.get(0).setHasChild(hasChild);
	}

	public TrajectoryInfo getParentTrajectory() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return this.trajectories.get(0).getParentTrajectory();
	}

	public void setParentTrajectory(TrajectoryInfo parentTrajectory) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}
		
		if (parentTrajectory == null)
			this.trajectories.get(0).setParentTrajectory(null);
		else
			this.trajectories.get(0).setParentTrajectory(parentTrajectory);
	}

	public TrajectoryInfo getActualState() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return this.trajectories.get(0).getActualState();
	}

	public void setActualState(TrajectoryInfo actualState) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}
		
		if (actualState == null)
			this.trajectories.get(0).setActualState(null);
		else
			this.trajectories.get(0).setActualState(actualState);
	}

	public Fitness getParentfitness() {
		if(this.trajectories.size() == 0){
			return null;
		}
		return this.trajectories.get(0).getParentfitness();
	}

	public void setParentfitness(Fitness parentfitness) {
		if(this.trajectories.size() == 0){
			trajectories.add(new SearchTrajectory());
		}	
		this.trajectories.get(0).setParentfitness(parentfitness);		
	}

	
}
