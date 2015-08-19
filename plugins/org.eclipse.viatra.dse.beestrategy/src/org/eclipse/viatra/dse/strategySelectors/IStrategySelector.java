package org.eclipse.viatra.dse.strategySelectors;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.SearchData;

public interface IStrategySelector {
		
		public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext);
}
