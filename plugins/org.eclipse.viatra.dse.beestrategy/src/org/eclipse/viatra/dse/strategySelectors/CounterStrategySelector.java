package org.eclipse.viatra.dse.strategySelectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.combineStrategies.ministrategy.IMiniStrategy;
import org.eclipse.viatra.dse.designspace.api.IState;

public class CounterStrategySelector implements IStrategySelector{
	ArrayList<ArrayList<IMiniStrategy>> availableStrategies;
	HashMap <IState, IMiniStrategy> reachedStatesAndStrategies;
	@Override
	public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext) {
		IMiniStrategy lastStrategy = reachedStatesAndStrategies.get(searchData.getParentTrajectory().getCurrentState());
		Boolean next =false;
		Random rand=new Random();
		for (int i = 0; i < availableStrategies.size(); i++) {
			
			if(availableStrategies.get(i).contains(lastStrategy)){
				ArrayList<IMiniStrategy> actlist = availableStrategies.get(i+1);
				return  actlist.get(rand.nextInt(actlist.size()-1));
			} 
		}
		if(availableStrategies.get(0).size()==1) return availableStrategies.get(0).get(0);
		return availableStrategies.get(0).get(rand.nextInt(availableStrategies.get(0).size()-1));
	}

	@Override
	public boolean initStrategy(ArrayList<ArrayList<IMiniStrategy>> initData) {
		if(initData == null) return false;
		if(initData.size()==0) return false;
		this.availableStrategies = new ArrayList<ArrayList<IMiniStrategy>>();
		for (ArrayList<IMiniStrategy> strategies: initData) {					
			if (strategies.size()>0) this.availableStrategies.add(strategies);						
		}
		if(availableStrategies.size()==0) return false;
		reachedStatesAndStrategies = new HashMap<IState, IMiniStrategy>();
		return true;
	}

}
