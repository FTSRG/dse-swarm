package program;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.BeeStrategyWorkerThread;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;
import org.eclipse.viatra.dse.mainStrategy.OnePatchStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class Run {
	
	
	@Parameters
	   public static Collection<String> primeNumbers() {
	      return Arrays.asList(new String[] {
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt1.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt2.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt3.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt4.serverpark", 
	    		// "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt5.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt6.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt7.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt8.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt9.serverpark", 
	    		  "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt10.serverpark"
	    		  
	      });
	   }
	
	public Run() {
		// TODO Auto-generated constructor stub
		
	}
	@Parameter
	public String source;
	
	@Test 
		public void test(){
		System.out.println(source);
		//String modeluri = "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt3.serverpark";
		BasicConfigurator.configure();
	   Logger.getRootLogger().setLevel(Level.ERROR);
	    Logger.getLogger(CreateBeeWithHillClimbing.class).setLevel(Level.DEBUG);
	   Logger.getLogger(BeeStrategyWorkerThread.class).setLevel(Level.DEBUG); 
	   Logger.getLogger(StrategyCombiner.class).setLevel(Level.ALL);
	   Logger.getLogger(OnePatchStrategy.class).setLevel(Level.ALL);
//	    Logger.getLogger(BeeStrategy3.class).setLevel(Level.DEBUG); 
	   // Logger.getLogger(CreateBeeWithDFS.class).setLevel(Level.DEBUG); 
		SetUp su = new SetUp();
	
		
		try {			
			su.setUpProject(source);		
			su.startProject();
			su.writeOutProject();
			Collection<Solution> solutions = su.dse.getSolutions();
			for (Solution solution : solutions) {
				System.out.println(solution.getStateCode());
				System.out.println(solution.getShortestTrajectory().getTrajectoryLength());
				System.out.println(solution.getTrajectories().iterator().next().getTrajectoryLength());
				
			}
			System.out.println();
			//ArrayList<Solution> sols = (ArrayList<Solution>) su.dse.getGlobalContext().getSolutionStore().getSolutions();
			
			//System.out.println("length: "+su.dse.getGlobalContext().getSolutionStore().getSolutions().
		} catch (IncQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
