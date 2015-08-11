package dse.onlab;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.incquery.runtime.exception.IncQueryException;
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
		// BasicConfigurator.configure();
	    // Logger.getRootLogger().setLevel(Level.ERROR);
	    // Logger.getLogger(CreateBeeWithDFS.class).setLevel(Level.ALL);
		 //Logger.getLogger(CreateBeeWithDFS.class).setLevel(Level.DEBUG);
		// Logger.getLogger(CreateBeeWithHillClimbing.class).setLevel(Level.DEBUG);
		// Logger.getLogger(DepthFirstStrategy.class).setLevel(Level.DEBUG);
		// Logger.getLogger(BeeStrategyWorkerThread.class).setLevel(Level.DEBUG);
	     //System.out.println("elkezdve");
		 setUp su = new setUp();
		
		try {
			System.out.println("set");			
			su.setUpProject();
			System.out.println("started");
			su.startProject();
			System.out.println("finished");
			su.writeOutProject();
			System.out.println(su.dse.toStringSolutions());
			//ArrayList<Solution> sols = (ArrayList<Solution>) su.dse.getGlobalContext().getSolutionStore().getSolutions();
			
			//System.out.println("length: "+su.dse.getGlobalContext().getSolutionStore().getSolutions().
		} catch (IncQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
