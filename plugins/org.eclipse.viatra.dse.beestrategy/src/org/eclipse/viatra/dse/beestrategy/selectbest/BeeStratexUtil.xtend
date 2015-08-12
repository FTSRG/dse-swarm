package org.eclipse.viatra.dse.beestrategy

import java.util.HashMap
import java.util.Map
import java.util.Set
import org.eclipse.incquery.runtime.rete.traceability.TraceInfo
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS

@Data abstract class ExploredByBee {
	ICreateBee explorer
}

@Data class StatePath extends ExploredByBee {
	String stateCode
	double fittness
	int steps
	
	
	
}

@Data class PathStep extends ExploredByBee {
	TraceInfo from
	
	TraceInfo to
}

class BeeStratexUtil {
	private static val magnitude = 20000
	
	val Map<TrajectoryInfo, StatePath> reachedStates = new HashMap(magnitude)
	val Map<TraceInfo, Set<PathStep>> exploredTransitions = new HashMap(magnitude)
	
	new() {
		val x = new StatePath(new CreateBeeWithDFS(), new String(), 1.0, 3)
	}
	
	
}