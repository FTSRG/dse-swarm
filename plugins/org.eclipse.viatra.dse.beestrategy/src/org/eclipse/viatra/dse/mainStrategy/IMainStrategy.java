package org.eclipse.viatra.dse.mainStrategy;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;

public interface IMainStrategy {
	public void exploreParalell();
	public void exploreOneThread();
	public void initMainStrategy(StrategyCombiner sc);
}
