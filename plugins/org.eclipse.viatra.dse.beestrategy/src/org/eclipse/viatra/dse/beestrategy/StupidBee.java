package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class StupidBee {
	
	public enum BeeType {
        Explorer,
        Neighbour
    }
		//Integer ID;
		TrajectoryInfo actualState;
		//it is null if it started from the hive
//		TrajectoryInfo patchState;
		
		BeeType beeType;



		Fitness fitness;
		TrajectoryFitness trajectoryFitness;
		
		public TrajectoryFitness getTrajectoryFitness() {
			return trajectoryFitness;
		}

		public void setTrajectoryFitness(TrajectoryFitness trajectoryFitness) {
			this.trajectoryFitness = trajectoryFitness;
		}

//		public StupidBee(Integer ID){
//			this.ID=ID;
//			this.patchState=patchState;
//		}
//		
//		public StupidBee(Integer ID, TrajectoryInfo patchState){
//			this.ID=ID;
//	//		this.patchState=patchState;
//		}
		
//		public Integer getID() {
//			return ID;
//		}
		
		

//		public void setID(Integer ID) {
//			this.ID = ID;
//		}

//		public TrajectoryInfo getPatchState() {
//			return patchState;
//		}
//
//		public void setPatchState(TrajectoryInfo patchState) {
//			this.patchState = patchState;
//		}

		public BeeType getBeeType() {
			return beeType;
		}

		public void setBeeType(BeeType beeType) {
			this.beeType = beeType;
		}

		public TrajectoryInfo getActualState() {
			return actualState;
		}

		public Fitness getFitness() {
			return fitness;
		}
		
		public void init(TrajectoryInfo actualState, BeeType beeType, Fitness fitness){
//		this.ID = ID;
//			this.patchState = patchState;
			this.beeType = beeType;
			this.fitness=(Fitness)fitness.clone();	
			this.actualState=actualState.clone();
		}
		
		public void stepFoward(TrajectoryInfo  actualState, Fitness fitness){
			this.fitness=fitness;
			this.actualState=actualState;
		}

		
		public StupidBee clone(){
//			StupidBee sb = new StupidBee(this.ID, null);
			StupidBee sb = new StupidBee();
			sb.init(this.actualState, this.beeType, (Fitness) this.fitness.clone());
			sb.setTrajectoryFitness(this.trajectoryFitness
			);
			return sb;
		}
		
}
