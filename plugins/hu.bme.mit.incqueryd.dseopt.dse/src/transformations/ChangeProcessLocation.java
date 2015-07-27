package transformations;

import hu.bme.mit.incqueryd.dseopt.queries.ChangeProcessLocationMatch;
import hu.bme.mit.incqueryd.dseopt.queries.util.ChangeProcessLocationProcessor;
import hu.bme.mit.incqueryd.dseopt.queries.util.ChangeProcessLocationQuerySpecification;
import infrastructure.Process;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.TransformationRule;

import ServerPark.Machines;
import ServerPark.UsedMachines;

public class ChangeProcessLocation {
	public TransformationRule<ChangeProcessLocationMatch> begin() throws IncQueryException{
		ChangeProcessLocationProcessor ssp = new ChangeProcessLocationProcessor() {

			@Override
			public void process(UsedMachines pServerpark, Machines pMachine1,
					Machines pMachine2, ServerPark.Process pProcess, Integer pI) {
				// TODO Auto-generated method stub
				pMachine1.getMachineProcesses().remove(pProcess);
				pMachine2.getMachineProcesses().add(pProcess);
				Integer processSize=pProcess.getSize();
				pMachine1.setUsedMemory(pMachine1.getUsedMemory()-processSize);
				pMachine2.setUsedMemory(pMachine2.getUsedMemory()+processSize);
			//	System.out.println(pProcess.getId()+": "+pMachine1.getIP()+" ->"+pMachine2.getIP());
			//	System.out.println("db: "+pI);
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
		TransformationRule<ChangeProcessLocationMatch> tr = new TransformationRule<ChangeProcessLocationMatch>(ChangeProcessLocationQuerySpecification.instance(), ssp);
		return tr;
		
	}
}
