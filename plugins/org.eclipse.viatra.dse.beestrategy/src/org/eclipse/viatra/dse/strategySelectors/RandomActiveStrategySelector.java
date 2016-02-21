package org.eclipse.viatra.dse.strategySelectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.combineStrategies.ministrategy.IMiniStrategy;

public class RandomActiveStrategySelector implements IStrategySelector {

	
	HashMap<IMiniStrategy, Integer> statistic;

	@Override
	public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext) {
		int minimalfound = 0;
		IMiniStrategy minimalStrategy = null;
		for (Entry<IMiniStrategy, Integer> entry  : statistic.entrySet()) {
			if(minimalStrategy==null){
				minimalfound = entry.getValue();
				minimalStrategy = entry.getKey();
			}
			else{
				if (minimalfound>entry.getValue()){
					minimalfound = entry.getValue();
					minimalStrategy = entry.getKey();
				}
			}
		}
		return minimalStrategy;
		
	}

	@Override
	public boolean initStrategy(ArrayList<ArrayList<IMiniStrategy>> Data) {
		
		this.statistic = new HashMap<IMiniStrategy, Integer>();
		if (Data == null)
			return false;
		if (Data.size() == 0)
			return false;
		ArrayList<IMiniStrategy> initData = Data.get(0);
		if (initData.size() == 0)
			return false;
		
			for (int i = 0; i < initData.size(); i++) {
				this.statistic.put(initData.get(i), 0);
			}
		
		return true;
	}

}
