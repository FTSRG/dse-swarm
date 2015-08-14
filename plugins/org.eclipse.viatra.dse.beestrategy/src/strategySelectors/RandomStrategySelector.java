package strategySelectors;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.IMiniStrategy;

public class RandomStrategySelector implements IStrategySelector{
	IMiniStrategy randomSearch;
	IMiniStrategy localSearch;
	
	@Override
	public IStrategy selectStrategy(SearchData searchData, SearchContext searchContext){
		if(searchData.getHasParent() == false) return randomSearch;
		return localSearch;
	}
	
	public void setStrategies(IMiniStrategy randomSearch, IMiniStrategy localSearch){
		this.randomSearch = randomSearch;
		this.localSearch =  localSearch;
	}


}
