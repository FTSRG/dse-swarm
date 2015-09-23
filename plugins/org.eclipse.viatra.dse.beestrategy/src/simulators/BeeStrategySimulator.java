package simulators;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.AbstractMiniStrategy;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;
import org.eclipse.viatra.dse.mainStrategy.AlwaysGoMore;
import org.eclipse.viatra.dse.mainStrategy.IMainStrategy;
import org.eclipse.viatra.dse.mainStrategy.OnePatchStrategy;
import org.eclipse.viatra.dse.stopConditions.CombinedStopCondition;
import org.eclipse.viatra.dse.stopConditions.NumberOfFiredTransitionCondition;
import org.eclipse.viatra.dse.stopConditions.SolutionFoundStopCondition;
import org.eclipse.viatra.dse.strategySelectors.RandomStrategySelector;

public class BeeStrategySimulator {
	private StrategyCombiner strategyCombiner;
	public BeeStrategySimulator(StrategyCombiner sc){
		strategyCombiner = sc;
	}
	
	public StrategyCombiner init(AbstractMiniStrategy ms1, AbstractMiniStrategy ms2){
		RandomStrategySelector selector = new RandomStrategySelector();
		selector.setStrategies(ms1,ms2);
		strategyCombiner.setStrategySelector(selector);
		strategyCombiner.setBestSitesNum(2);
		strategyCombiner.setEliteBeesNum(2);
		strategyCombiner.setEliteSitesNum(1);
		try {
			strategyCombiner.setNumberOfMaxBees(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strategyCombiner.setOtherBeesNum(1);
		strategyCombiner.setPatchSize(10);
		strategyCombiner.setSitesnum(2);
		
		
		NumberOfFiredTransitionCondition noft = new NumberOfFiredTransitionCondition();
		noft.setMaxNumberOfFiredTransitions(60);
		SolutionFoundStopCondition sfsc = new SolutionFoundStopCondition();
		
		CombinedStopCondition stopConditions = new CombinedStopCondition();
		stopConditions.addStopCondition(noft);
		stopConditions.addStopCondition(sfsc);
		
		strategyCombiner.setMiniStrategyStopCondition(stopConditions);
		IMainStrategy ms = new AlwaysGoMore();
		strategyCombiner.setMainStrategy(ms);
		return strategyCombiner;
	}
}
