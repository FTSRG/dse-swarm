package dse.onlab;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.strategy.impl.DepthFirstStrategy;
import org.eclipse.viatra.dse.beestrategy.BeeStrategyWorkerThread;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class runDse {
	
	public runDse(int runId) {
		// TODO Auto-generated constructor stub
	}
	
	@Parameterized.Parameters
	   public static Collection primeNumbers() {
	      return Arrays.asList(new Object[] {
	         1,2,3,4
	      });
	   }
	
	@Test
	public void test1(){
//		 BasicConfigurator.configure();
	     Logger.getRootLogger().setLevel(Level.ERROR);
	     Logger.getLogger(CreateBeeWithDFS.class).setLevel(Level.ALL);
//		 //Logger.getLogger(CreateBeeWithDFS.class).setLevel(Level.DEBUG);
		 Logger.getLogger(StrategyCombiner.class).setLevel(Level.DEBUG);
		 Logger.getLogger(DepthFirstStrategy.class).setLevel(Level.DEBUG);
		 Logger.getLogger(BeeStrategyWorkerThread.class).setLevel(Level.DEBUG);
	     //System.out.println("elkezdve");
		 setUp su = new setUp();
		
		try {
			System.out.println("set");			
			su.setUpProject();
			System.out.println("started");
			su.startProject();
			System.out.println("finished");
			su.writeOutProject();
		
			Collection<Solution> solutions = su.dse.getSolutions();
			for (Solution solution : solutions) {
				System.out.println(su.dse.toStringSolutions());
				System.out.println(solution.getStateCode());
				System.out.println(solution.getShortestTrajectory().getTrajectoryLength());
				System.out.println(solution.getTrajectories().iterator().next().getTrajectoryLength());
				
			}
			//ArrayList<Solution> sols = (ArrayList<Solution>) su.dse.getGlobalContext().getSolutionStore().getSolutions();
			
			//System.out.println("length: "+su.dse.getGlobalContext().getSolutionStore().getSolutions().
		} catch (IncQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
