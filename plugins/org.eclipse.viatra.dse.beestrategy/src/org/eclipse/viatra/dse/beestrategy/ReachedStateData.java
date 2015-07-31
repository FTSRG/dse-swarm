package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;

public class ReachedStateData {
	private TrajectoryInfo Bestti;
	private Double Bestfitness;
	private ThreadContext reachedBy;
	
	public TrajectoryInfo getBestti() {
		return Bestti;
	}
	public void setBestti(TrajectoryInfo bestti) {
		Bestti = bestti;
	}
	public Double getBestfitness() {
		return Bestfitness;
	}
	public void setBestfitness(Double bestfitness) {
		Bestfitness = bestfitness;
	}
	public ThreadContext getReachedBy() {
		return reachedBy;
	}
	public void setReachedBy(ThreadContext reachedBy) {
		this.reachedBy = reachedBy;
	}
	
}
