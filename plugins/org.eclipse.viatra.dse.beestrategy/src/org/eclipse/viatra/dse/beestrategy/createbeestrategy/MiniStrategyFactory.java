package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.beestrategy.SearchData;

public class MiniStrategyFactory {
	public enum StrategyType {
		DFS, HillClimbing, BFS
	}
	
	public ICreateBee buildstrategy(StrategyType strategy, BeeStrategy3 bs) {
		if (strategy == null) {
			return null;
		}
		ICreateBee createdstrategy = null;
		switch (strategy) {
		case DFS:
			createdstrategy = new CreateBeeWithDFS(bs);
			break;

		case HillClimbing:
			createdstrategy = new CreateBeeWithHillClimbing(bs);
			break;

		case BFS:
			//TODO
			break;

		default:
			createdstrategy = new CreateBeeWithDFS(bs);
			break;
		}
		return createdstrategy;
	}

}
