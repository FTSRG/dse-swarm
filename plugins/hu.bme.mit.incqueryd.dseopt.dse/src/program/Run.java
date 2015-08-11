package program;

import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.Solution;
import org.junit.Test;

public class Run {
	@Test 
		public void test(){
		//String modeluri = "D:/git/git/viatra-dse-swarm/plugins/test/beetesztek/teszt3.serverpark";
		BasicConfigurator.configure();
	    Logger.getRootLogger().setLevel(Level.ERROR);
	    Logger.getLogger("log").setLevel(Level.DEBUG); 
		SetUp su = new SetUp();
	
		
		try {			
			su.setUpProject();		
			su.startProject();
			su.writeOutProject();
			Collection<Solution> solutions = su.dse.getSolutions();
			for (Solution solution : solutions) {
				System.out.println(solution.getStateCode());
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
