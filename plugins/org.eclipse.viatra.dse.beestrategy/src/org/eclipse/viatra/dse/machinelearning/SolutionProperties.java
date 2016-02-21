package org.eclipse.viatra.dse.machinelearning;

import org.eclipse.viatra.dse.mainStrategy.AlwaysGoMore;
import org.eclipse.viatra.dse.mainStrategy.IMainStrategy;
import org.eclipse.viatra.dse.stopConditions.CombinedStopCondition;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;
import org.eclipse.viatra.dse.stopConditions.NumberOfFiredTransitionCondition;
import org.eclipse.viatra.dse.stopConditions.SolutionFoundStopCondition;
import org.eclipse.viatra.dse.strategySelectors.IStrategySelector;
import org.eclipse.viatra.dse.strategySelectors.RandomStrategySelector;

public class SolutionProperties {
	IStrategySelector selector;
	int BestSitesNum;
	int EliteBeesNum;
	int EliteSitesNum;
	int NumberOfMaxBees;
	int OtherBeesNum;
	int PatchSize;
	int Sitesnum;
	IStopCondition stopcond;
	IStopCondition miniStrategyStopCondition;
	IMainStrategy ms;
	

	

	
	

}
