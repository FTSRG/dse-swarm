package dse.transformation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;

import constraints.DriverGetIntoBoatMatch;
import constraints.DriverGetIntoBoatMatcher;
import constraints.util.DriverGetIntoBoatProcessor;
import constraints.util.DriverGetIntoBoatQuerySpecification;
import onlab.Driver;
import onlab.Vehichle;

public class GetDriverIntoBoat {

	public DSETransformationRule<DriverGetIntoBoatMatch, DriverGetIntoBoatMatcher> getinto() throws IncQueryException{
		DriverGetIntoBoatProcessor ap = new DriverGetIntoBoatProcessor() {

			@Override
			public void process(EObject pE1, EObject pE2) {
				Vehichle pV = (Vehichle)pE1;
				Driver pP = (Driver) pE2;
				pP.getLand().getPassangers().remove(pP);
				pP.setLand(null);
				pP.setTravelOn(pV);	
				pV.getPassanger().add(pP);
				
			}
		};
		
		DSETransformationRule<DriverGetIntoBoatMatch, DriverGetIntoBoatMatcher> tr = new DSETransformationRule<DriverGetIntoBoatMatch, DriverGetIntoBoatMatcher>(DriverGetIntoBoatQuerySpecification.instance(), ap);
		return tr;
		
	}
	
	
	
}