package org.eclipse.viatra.dse.mainStrategy;

import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;

public interface IMainStrategy {
	public void exploreParalell();
	public void exploreOneThread();
	public void initMainStrategy(StrategyCombiner sc);
	public void SearchDataOut(SearchData sd);
	public void SearchDataBack(SearchData sd);
	public void isSolution(SearchTrajectory searchTrajectory);
	
}
