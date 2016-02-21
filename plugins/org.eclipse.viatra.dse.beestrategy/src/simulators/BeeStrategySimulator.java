package simulators;

import java.util.ArrayList;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.combineStrategies.ministrategy.AbstractMiniStrategy;
import org.eclipse.viatra.dse.combineStrategies.ministrategy.IMiniStrategy;
import org.eclipse.viatra.dse.mainStrategy.BeeStrategy;
import org.eclipse.viatra.dse.mainStrategy.IMainStrategy;
import org.eclipse.viatra.dse.stopConditions.CombinedStopCondition;
import org.eclipse.viatra.dse.stopConditions.NumberOfFiredTransitionCondition;
import org.eclipse.viatra.dse.stopConditions.SolutionFoundStopCondition;
import org.eclipse.viatra.dse.strategySelectors.CounterStrategySelector;
import org.eclipse.viatra.dse.strategySelectors.IStrategySelector;

import instanceSelector.BeeStrategySelector;
import instanceSelector.IInstanceSelector;

public class BeeStrategySimulator {
	private StrategyCombiner strategyCombiner;
	public BeeStrategySimulator(StrategyCombiner sc){
		strategyCombiner = sc;
	}
	
	public StrategyCombiner init(AbstractMiniStrategy ms1, AbstractMiniStrategy ms2){
		
		//create ministrategies
		ArrayList<ArrayList<IMiniStrategy>> ministrategies = new ArrayList<ArrayList<IMiniStrategy>>();
		ArrayList<IMiniStrategy> list = new ArrayList<IMiniStrategy>();
		list.add(ms1);
		ministrategies.add(list);
		list = new ArrayList<IMiniStrategy>();
		list.add(ms2);
		ministrategies.add(list);
		//create the selector of ministrategy
		IStrategySelector selector = new CounterStrategySelector();
		selector.initStrategy(ministrategies);
		//set initial parameters of strategyCombiner 
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
		
		//create stopconditions 
		NumberOfFiredTransitionCondition noft = new NumberOfFiredTransitionCondition();
		noft.setMaxNumberOfFiredTransitions(60);
		SolutionFoundStopCondition sfsc = new SolutionFoundStopCondition();
		
		CombinedStopCondition stopConditions = new CombinedStopCondition();
		stopConditions.addStopCondition(noft);
		stopConditions.addStopCondition(sfsc);
		
		//set stopconditions for ministrategies
		strategyCombiner.setMiniStrategyStopCondition(stopConditions);
		//create and set mainstrategy
		IMainStrategy ms = new BeeStrategy();
		strategyCombiner.setMainStrategy(ms);
		
		IInstanceSelector instanceSelector = new BeeStrategySelector();
		strategyCombiner.setNextInstanceSelector(instanceSelector);
		return strategyCombiner;
	}
}
