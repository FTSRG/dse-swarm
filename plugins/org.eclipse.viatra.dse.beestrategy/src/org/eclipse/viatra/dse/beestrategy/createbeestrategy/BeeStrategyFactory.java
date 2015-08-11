package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

public class BeeStrategyFactory {
	public enum StrategiesOfBeeStrategy {
		DFS, HillClimbing, BFS
	}
	
	public ICreateBee buildstrategy(StrategiesOfBeeStrategy strategy) {
		if (strategy == null) {
			return null;
		}
		ICreateBee createdstrategy = null;
		switch (strategy) {
		case DFS:
			createdstrategy = new CreateBeeWithDFS();
			break;

		case HillClimbing:
			createdstrategy = new CreateBeeWithHillClimbing();
			break;

		case BFS:
			//TODO
			break;

		default:
			createdstrategy = new CreateBeeWithDFS();
			break;
		}
		return createdstrategy;
	}

}
