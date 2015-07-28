package org.eclipse.viatra.dse.beestrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.incquery.runtime.rete.traceability.TraceInfo;
import org.eclipse.viatra.dse.beestrategy.PathStep;
import org.eclipse.viatra.dse.beestrategy.StatePath;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;

@SuppressWarnings("all")
public class BeeStratexUtil {
  private final static int magnitude = 20000;
  
  private final Map<StatePath, TrajectoryInfo> reachedStates = new HashMap<StatePath, TrajectoryInfo>(BeeStratexUtil.magnitude);
  
  private final Map<TraceInfo, Set<PathStep>> exploredTransitions = new HashMap<TraceInfo, Set<PathStep>>(BeeStratexUtil.magnitude);
  
  public BeeStratexUtil() {
    CreateBeeWithDFS _createBeeWithDFS = new CreateBeeWithDFS();
    String _string = new String();
    final StatePath x = new StatePath(_createBeeWithDFS, _string, 1.0, 3);
  }
}
