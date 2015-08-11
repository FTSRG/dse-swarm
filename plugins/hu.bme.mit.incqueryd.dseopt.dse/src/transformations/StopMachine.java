package transformations;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;

import ServerPark.Machines;
import ServerPark.UsedMachines;
import hu.bme.mit.incqueryd.dseopt.queries.StopServerMatch;
import hu.bme.mit.incqueryd.dseopt.queries.StopServerMatcher;
import hu.bme.mit.incqueryd.dseopt.queries.util.StopServerProcessor;
import hu.bme.mit.incqueryd.dseopt.queries.util.StopServerQuerySpecification;

public class StopMachine {
	
	public DSETransformationRule<StopServerMatch, StopServerMatcher> begin() throws IncQueryException{
		StopServerProcessor ssp = new StopServerProcessor() {

			@Override
			public void process(UsedMachines pServerpark, Machines pMachine) {
				// TODO Auto-generated method stub
				pServerpark.getStopped().add(pMachine);
				pServerpark.getRunning().remove(pMachine);
			/*	System.out.print("leállított gépek ");
				for (int i=0; i<pServerpark.getStopped().size(); i++){
					System.out.print(pServerpark.getStopped().get(i).getIP()+" ");
				}
				System.out.println();
				System.out.print("futó gépek ");
				for (int i=0; i<pServerpark.getRunning().size(); i++){
					System.out.print(pServerpark.getRunning().get(i).getIP()+" ");
				}
				System.out.println();*/
				
			}
		};
		
		DSETransformationRule<StopServerMatch, StopServerMatcher> tr = new DSETransformationRule<StopServerMatch, StopServerMatcher>(StopServerQuerySpecification.instance(), ssp);
		
		return tr;
		
		
	}
	
}