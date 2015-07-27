package program;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.junit.Test;

public class Run {
	@Test 
		public void test(){
		BasicConfigurator.configure();
	    Logger.getRootLogger().setLevel(Level.ERROR);
	    Logger.getLogger("log").setLevel(Level.DEBUG); 
		SetUp su = new SetUp();
	
		
		try {			
			su.setUpProject();		
			su.startProject();
			su.writeOutProject();
			System.out.println(su.dse.prettyPrintSolutions());
			//ArrayList<Solution> sols = (ArrayList<Solution>) su.dse.getGlobalContext().getSolutionStore().getSolutions();
			
			//System.out.println("length: "+su.dse.getGlobalContext().getSolutionStore().getSolutions().
		} catch (IncQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
