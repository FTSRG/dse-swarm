package org.eclipse.viatra.dse.mainStrategy;

import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.IMiniStrategy;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;

public class CombinedDFSLocalSearch implements IMainStrategy{
	public IMiniStrategy localSearch;
	public IMiniStrategy randomSearch;
	public IStopCondition mainStrategyStopCondition;
	public StrategyCombiner sc;
	@Override
	public void exploreParalell() {
		
		
	}
	@Override
	public void exploreOneThread() {
	
		
	}
	@Override
	public void initMainStrategy(StrategyCombiner sc) {
		for (int i=0; i<sc.getBestSitesNum(); i++){
			
		}
		while(!mainStrategyStopCondition.isStopConditionReached()){
			
		}
		
	}
	@Override
	public void SearchDataOut(SearchData sc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void SearchDataBack(SearchData sc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void isSolution(SearchTrajectory searchTrajectory) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
