package org.eclipse.viatra.dse.strategySelectors;
import java.util.ArrayList;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.combineStrategies.ministrategy.IMiniStrategy;

public interface IStrategySelector {
		
		public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext);
		public boolean initStrategy(ArrayList<ArrayList<IMiniStrategy>> ministrategies);
		
}
