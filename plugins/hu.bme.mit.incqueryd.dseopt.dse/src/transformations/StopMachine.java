package transformations;

import hu.bme.mit.incqueryd.dseopt.queries.StopServerMatch;
import hu.bme.mit.incqueryd.dseopt.queries.util.StopServerProcessor;
import hu.bme.mit.incqueryd.dseopt.queries.util.StopServerQuerySpecification;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.TransformationRule;

import ServerPark.Machines;
import ServerPark.UsedMachines;

public class StopMachine {
	
	public TransformationRule<StopServerMatch> begin() throws IncQueryException{
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
		
		TransformationRule<StopServerMatch> tr = new TransformationRule<StopServerMatch>(StopServerQuerySpecification.instance(), ssp);
		
		return tr;
		
		
	}
	
}