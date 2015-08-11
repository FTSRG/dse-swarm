package transformations;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;

import ServerPark.Machines;
import ServerPark.UsedMachines;
import hu.bme.mit.incqueryd.dseopt.queries.StartServerMatch;
import hu.bme.mit.incqueryd.dseopt.queries.StartServerMatcher;
import hu.bme.mit.incqueryd.dseopt.queries.util.StartServerProcessor;
import hu.bme.mit.incqueryd.dseopt.queries.util.StartServerQuerySpecification;

public class StartMachine {
	
	public DSETransformationRule<StartServerMatch, StartServerMatcher> begin() throws IncQueryException{
		StartServerProcessor ssp = new StartServerProcessor() {

			@Override
			public void process(UsedMachines pServerpark, Machines pMachine) {
				// TODO Auto-generated method stub
				pServerpark.getStopped().remove(pMachine);
				pServerpark.getRunning().add(pMachine);
//				System.out.print("futó gépek ");
//				for (int i=0; i<pServerpark.getRunning().size(); i++){
//					System.out.print(pServerpark.getRunning().get(i).getIP()+" ");
//				}
//				System.out.println();
			}
		};
		DSETransformationRule<StartServerMatch, StartServerMatcher>  tr = new DSETransformationRule<StartServerMatch, StartServerMatcher> (StartServerQuerySpecification.instance(), ssp);
		return tr;
		
	}
	
}


/*public class GetIntoBoat {

	public TransformationRule<GetIntoMatch> getinto() throws IncQueryException{
		GetIntoProcessor ap = new GetIntoProcessor(){	

			@Override
			public void process(Vehichle pV, Passanger pP) {
				pP.getLand().getPassangers().remove(pP);
				pP.setLand(null);
				pP.setTravelOn(pV);	
			}
		};
		
		TransformationRule<GetIntoMatch> tr = new TransformationRule<GetIntoMatch>(GetIntoQuerySpecification.instance(), ap);
		return tr;
		
	}*/