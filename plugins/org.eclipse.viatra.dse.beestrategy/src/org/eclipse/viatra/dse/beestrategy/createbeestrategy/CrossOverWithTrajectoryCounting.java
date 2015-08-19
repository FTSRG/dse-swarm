package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class CrossOverWithTrajectoryCounting extends AbstractMiniStrategy{
	HashMap<ITransition, Integer> transitions = new HashMap<ITransition, Integer>();
	List<ITransition> firstTrajectoryInfo;
	List<ITransition> secondTrajectoryInfo;

	
	
	
	public  CrossOverWithTrajectoryCounting(StrategyCombiner bs) {
		super(bs);
	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {
		return new  CrossOverWithTrajectoryCounting(bs);
		
	}

	@Override
	public void explore() {
		SearchTrajectory ti = generateTrajectoryCrossover(this.searchData.getTrajectories().get(0), this.searchData.getTrajectories().get(1));
		SearchTrajectory ti2 = generateTrajectoryCrossover(this.searchData.getTrajectories().get(1), this.searchData.getTrajectories().get(0));
		ArrayList<SearchTrajectory> newtrajectories = new ArrayList<SearchTrajectory>();
		newtrajectories.add(ti);
		newtrajectories.add(ti2);
		this.searchData.setTrajectories(newtrajectories);
	}
		
	private SearchTrajectory generateTrajectoryCrossover(SearchTrajectory firstTrajectory, SearchTrajectory secondTrajectory){
		List<ITransition> firstTrajectoryInfo = firstTrajectory.getParentTrajectory().getFullTransitionTrajectory();
		List<ITransition> secondTrajectoryInfo = secondTrajectory.getParentTrajectory().getFullTransitionTrajectory();
		
		//Add all trajectories in firstTrajectoryInfo to a hashmap
				for (ITransition iTransition : firstTrajectoryInfo) {
					if(this.transitions.containsKey(iTransition)){
						Integer value = this.transitions.get(iTransition)+1;
						this.transitions.replace(iTransition, value);
					}
					else{
						this.transitions.put(iTransition, 1);
					}
				}
				//Remove all trajectories in secondTrajectoryInfo from the hashmap
				for (ITransition iTransition : secondTrajectoryInfo) {
					if(this.transitions.containsKey(iTransition)){
						Integer value = this.transitions.get(iTransition)-1;
						if(value < 1 ){
							this.transitions.remove(iTransition);
						}
						else{
							this.transitions.replace(iTransition, value);
						}
					}
				}
				for (ITransition iTransition: firstTrajectoryInfo){
					if(this.transitions.containsKey(iTransition)){
						if(dsm.getTransitionsFromCurrentState().contains(iTransition)){
							dsm.fireActivation(iTransition);
						}	
						Integer value = this.transitions.get(iTransition)-1;
						if(value < 1 ){
							this.transitions.remove(iTransition);
						}
						else{
							this.transitions.replace(iTransition, value);
						}
					}
					
				}
		SearchTrajectory searchTrajectory = new SearchTrajectory();
		searchTrajectory.setParentfitness(secondTrajectory.getParentfitness());
		searchTrajectory.setParentTrajectory(secondTrajectory.getParentTrajectory());
		searchTrajectory.setHasChild(false);
		searchTrajectory.setHasParent(true);	
		
		searchTrajectory.setActualState(dsm.getTrajectoryInfo());
		searchTrajectory.setOwnfitness(context.calculateFitness());
		searchTrajectory.setOwntrajectoryFitness(new TrajectoryFitness(dsm.getTrajectoryInfo(), context.getLastFitness()));
		return searchTrajectory;
		
	}
}
