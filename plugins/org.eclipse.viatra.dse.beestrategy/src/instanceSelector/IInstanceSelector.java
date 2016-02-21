package instanceSelector;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;

public interface IInstanceSelector {
	public void selectInstances(StrategyCombiner sc);
}
