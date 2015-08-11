package org.eclipse.viatra.dse.beestrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.incquery.runtime.rete.traceability.TraceInfo;
import org.eclipse.viatra.dse.beestrategy.PathStep;
import org.eclipse.viatra.dse.beestrategy.StatePath;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;

@SuppressWarnings("all")
public class BeeStratexUtil {
  private final static int magnitude = 20000;
  
  private final Map<TrajectoryInfo, StatePath> reachedStates = new HashMap<TrajectoryInfo, StatePath>(BeeStratexUtil.magnitude);
  
  private final Map<TraceInfo, Set<PathStep>> exploredTransitions = new HashMap<TraceInfo, Set<PathStep>>(BeeStratexUtil.magnitude);
  
  public BeeStratexUtil() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor CreateBeeWithDFS(BeeStrategy3, SearchData, HashSet<IState>) is not visible");
  }
}
