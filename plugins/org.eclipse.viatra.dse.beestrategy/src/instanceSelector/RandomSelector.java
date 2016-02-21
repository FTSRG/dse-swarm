package instanceSelector;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;

public class RandomSelector implements IInstanceSelector{

	@Override
	public void selectInstances(StrategyCombiner combiner) {
		combiner.setBestpatches(new ArrayList<SearchTrajectory>());
		Random rand = new Random ();
		
		int length = combiner.getBestSitesNum();
		int sizeOfPatches = combiner.getPatchSize();
		int numberOfSelectedPatches;
		if(length>sizeOfPatches)  numberOfSelectedPatches = sizeOfPatches;
		else numberOfSelectedPatches = length;		
		for (int i=0; i<numberOfSelectedPatches; i++){
			combiner.getBestpatches().add(combiner.getPatches().get(rand.nextInt(sizeOfPatches-1)));
		}
		
	}

}
