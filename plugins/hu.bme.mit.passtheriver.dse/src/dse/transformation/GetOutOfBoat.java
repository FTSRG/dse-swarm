package dse.transformation;

import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;

import constraints.*;
import constraints.util.*;


public class GetOutOfBoat {
	
	public DSETransformationRule<GetOutMatch, GetOutMatcher> getinto() throws IncQueryException{
		GetOutProcessor ap = new GetOutProcessor(){			


			

			@Override
			public void process(EObject pE1, EObject pE2) {
				Vehichle pV = (Vehichle) pE1;
				Passanger pP = (Passanger) pE2;
				pV.getActualLand().getPassangers().add(pP);
				pP.setTravelOn(null);
				pP.setLand(pV.getActualLand());
				pV.getPassanger().remove(pP);
			}
		};
		
		DSETransformationRule<GetOutMatch, GetOutMatcher>  tr = new DSETransformationRule<GetOutMatch, GetOutMatcher> (GetOutQuerySpecification.instance(), ap);
		return tr;
		
	}

}
