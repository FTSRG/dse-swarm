package org.eclipse.viatra.dse.strategySelectors;

import java.util.ArrayList;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.combineStrategies.ministrategy.IMiniStrategy;

public class RandomStrategySelector implements IStrategySelector {
	IMiniStrategy randomSearch;
	IMiniStrategy localSearch;

	@Override
	public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext) {
		if (searchData.getHasParent() == false)
			return randomSearch;
		return localSearch;
	}

	public void setStrategies(IMiniStrategy randomSearch, IMiniStrategy localSearch) {
		this.randomSearch = randomSearch;
		this.localSearch = localSearch;
	}

	@Override
	public boolean initStrategy(ArrayList<ArrayList<IMiniStrategy>> Data) {
		if (Data == null)
			return false;
		if (Data.size() != 0)
			return false;
		ArrayList<IMiniStrategy> initData = Data.get(0);
		if (initData.size() != 2)
			return false;

		this.randomSearch = initData.get(0);
		this.localSearch = initData.get(1);

		return true;
	}

}
