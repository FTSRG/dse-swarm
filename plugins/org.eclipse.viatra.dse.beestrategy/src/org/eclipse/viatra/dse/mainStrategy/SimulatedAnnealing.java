package org.eclipse.viatra.dse.mainStrategy;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;
import org.eclipse.viatra.dse.strategySelectors.AnnealingStrategySelector;
import org.eclipse.viatra.dse.strategySelectors.IStrategySelector;

public class SimulatedAnnealing implements IMainStrategy{
	
	StrategyCombiner sc;

	@Override
	public void exploreParalell() {
		for (int i = 0; i < sc.getNumberOfMaxBees(); i++) {
			IStopCondition cond = sc.getMiniStrategyStopCondition().createNew(sc.getRadiusOfRandomSearch() * sc.getIterations());
			if (!sc.createRandomBee(cond)) {
				return;
			}
		}
		// we wait till we get back the solution from workerthreads
		while (sc.getNumberOfActiveBees() >= 1 && sc.isInterrupted() != true) {
			sc.getBackBees();
		}
		// collect the bests from patches (sc.getsitesnum can be set by the user at
		// the beginning of the strategy), a better patch has a better best bee,
		// the other bees does not count
		if (sc.isInterrupted() == true)
			return;
		sc.getBestPatches(sc.getSitesnum());
		while(!sc.isInterrupted()){
			if(sc.getBestpatches().size()!=0){
				
			}
		}
		
	}

	@Override
	public void exploreOneThread() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initMainStrategy(StrategyCombiner sc) {
		this.sc = new StrategyCombiner();
		AnnealingStrategySelector ss = new AnnealingStrategySelector();
		ss.setStrategies(sc);
		this.sc.setStrategySelector(ss);
		
	}

	
}
