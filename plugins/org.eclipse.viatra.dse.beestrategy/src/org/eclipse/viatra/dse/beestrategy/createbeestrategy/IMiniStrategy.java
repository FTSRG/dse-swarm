package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.HashSet;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.Patch;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.StupidBee;
import org.eclipse.viatra.dse.designspace.api.IState;

public interface IMiniStrategy extends IStrategy{



	public void setMainStrategy(IStrategy beeStrategy);
	public void setStatesInTrajectory(HashSet<IState> states);
	public void setSearchData(SearchData sd);
	public SearchData returnResult();
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs);
}
