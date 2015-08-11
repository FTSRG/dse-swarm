package org.eclipse.viatra.dse.beestrategy;

import java.util.ArrayList;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.StupidBee.BeeType;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class Patch {
	ArrayList<StupidBee> beeList = new ArrayList<StupidBee>();
	TrajectoryInfo patch;
	Fitness bestfitness;
	StupidBee bestBee;
	Integer neighbourbeesnum;
	
	
	public Patch(){
		beeList= new ArrayList<StupidBee>();
	}	
	
	//getters and setters 
	public ArrayList<StupidBee> getBeeList() {
		if(beeList!=null){
			return beeList;
		}
		return null;
	}
	public void setBeeList(ArrayList<StupidBee> beeList) {
		this.beeList = beeList;
	}
	
	
	public TrajectoryInfo getPatch() {
		return patch;
	}
	
	public void initPatch(TrajectoryInfo patch, ThreadContext context) {
		this.bestBee= new StupidBee();
		if (patch == null) this.bestBee.setTrajectoryFitness(null);
		else{
			TrajectoryFitness tf = new TrajectoryFitness(patch.getLastTransition(), context.calculateFitness()); 
			this.bestBee.setTrajectoryFitness(tf);
			TrajectoryInfo clone = patch.clone();
			this.bestBee.init(clone, BeeType.Explorer, context.calculateFitness());
			this.bestBee.setInitialState(clone);
			this.patch = clone;
		}
	}
	
	
	public StupidBee getBestBee() {
		/*System.out.println("bestBee: "+this.bestBee.getActualState());
		for (int i=0; i<this.beeList.size(); i++){
			System.out.println(this.beeList.get(i).getActualState());
		}
		System.out.println("patch end ----");*/
		if (beeList.size()==0) return bestBee;
		for (StupidBee stupidBee : beeList) {
			if (stupidBee.getFitness().isSatisifiesHardObjectives()==true) {
				this.bestBee = new StupidBee();
				bestBee.init(stupidBee.getActualState().clone(), BeeType.Neighbour, (Fitness)stupidBee.getFitness().clone());
				return stupidBee;
			}
		}
		return bestBee;
		
	}
	
	public Fitness getBestfitness() {
		return bestfitness;
	}
	public void setBestfitness(Fitness bestfitness) {
		this.bestfitness = bestfitness;
	}
	

	
	public void CalculateBestBee(ThreadContext context){
		for (int i = 0; i < this.beeList.size(); i++) {
			TrajectoryFitness tf = new TrajectoryFitness(beeList.get(i).getActualState(),
					beeList.get(i).getFitness());
			beeList.get(i).setTrajectoryFitness(tf);
			context.getObjectiveComparatorHelper().addTrajectoryFitness(tf);
		}
		TrajectoryFitness bestfitness = context.getObjectiveComparatorHelper().getRandomBest();
		
		for (StupidBee stupidBee : beeList) {
			if(stupidBee.getTrajectoryFitness().equals(bestfitness)){
				this.bestBee= stupidBee.clone();
			}
		}
			
		
	}
	
	
	
	
	
}
