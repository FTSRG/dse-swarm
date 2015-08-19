package org.eclipse.viatra.dse.strategySelectors;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;

public class AnnealingStrategySelector implements IStrategySelector{

	private CreateBeeWithHillClimbing hillClimbingStrategy;


	@Override
	public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext) {
		return hillClimbingStrategy;
	
	}
	
	
	public void setStrategies(StrategyCombiner sc){
		this.hillClimbingStrategy = new CreateBeeWithHillClimbing(sc);
	}

}
