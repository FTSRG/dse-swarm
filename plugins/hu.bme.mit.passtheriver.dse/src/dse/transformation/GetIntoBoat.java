package dse.transformation;

import onlab.Land;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;

import constraints.GetIntoMatch;
import constraints.GetIntoMatcher;
import constraints.util.GetIntoProcessor;
import constraints.util.GetIntoQuerySpecification;


public class GetIntoBoat {

	public DSETransformationRule<GetIntoMatch, GetIntoMatcher> getinto() throws IncQueryException{
		GetIntoProcessor ap = new GetIntoProcessor(){	

			@Override
			public void process(EObject pE1, EObject pE2) {
				Vehichle pV = (Vehichle) pE1;
				Passanger pP = (Passanger) pE2;
				pP.getLand().getPassangers().remove(pP);
				pP.setLand(null);
				pP.setTravelOn(pV);	
				pV.getPassanger().add(pP);
			}

		};
		
		DSETransformationRule<GetIntoMatch, GetIntoMatcher> tr = new DSETransformationRule<GetIntoMatch, GetIntoMatcher>(GetIntoQuerySpecification.instance(), ap);
		return tr;
		
	}
	
	
	
}
