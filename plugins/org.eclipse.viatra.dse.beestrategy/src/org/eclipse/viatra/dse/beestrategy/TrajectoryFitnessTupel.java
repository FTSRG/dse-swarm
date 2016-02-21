package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;

public class TrajectoryFitnessTupel {
	
	TrajectoryInfo ti;


	Fitness fitness;
		public TrajectoryFitnessTupel() {
		}
		
		public TrajectoryFitnessTupel(TrajectoryInfo ti) {
			this.ti = ti;
		}
		
		public TrajectoryFitnessTupel(Fitness fitness) {
			this.fitness = fitness;
		}
		
		public TrajectoryFitnessTupel(TrajectoryInfo ti, Fitness fitness) {
			this.ti = ti;
			this.fitness = fitness;
		}
		
		public TrajectoryInfo getTi() {
			return ti;
		}

		public void setTi(TrajectoryInfo ti) {
			this.ti = ti;
		}

		public Fitness getFitness() {
			return fitness;
		}

		public void setFitness(Fitness fitness) {
			this.fitness = fitness;
		}
		
	

}
