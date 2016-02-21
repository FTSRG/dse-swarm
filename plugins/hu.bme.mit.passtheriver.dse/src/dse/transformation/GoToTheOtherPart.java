package dse.transformation;

import onlab.Land;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;

import constraints.SwitchLandMatch;
import constraints.SwitchLandMatcher;
import constraints.util.SwitchLandProcessor;
import constraints.util.SwitchLandQuerySpecification;

public class GoToTheOtherPart {
	public DSETransformationRule<SwitchLandMatch, SwitchLandMatcher>  getinto() throws IncQueryException{
		SwitchLandProcessor ap = new SwitchLandProcessor(){			

			@Override
			public void process(EObject pE1, EObject pE2, EObject pE3) {
				Vehichle pV = (Vehichle) pE1;
				Land pStart = (Land) pE2;
				Land pCel = (Land) pE3;
				Land l= pV.getActualLand();
				if (pStart.getName().equals(l.getName())){
					pV.setActualLand(pCel);
					for (Passanger passanger : pV.getPassanger()) {
						pCel.getPassangers().add(passanger);
						passanger.setTravelOn(null);
						passanger.setLand(pCel);
					}
					
				}
				else{
					pV.setActualLand(pStart);
					for (Passanger passanger : pV.getPassanger()) {
						pStart.getPassangers().add(passanger);
						passanger.setTravelOn(null);
						passanger.setLand(pStart);
					}
				}
				pV.getPassanger().clear();
				
			}
		};
		
		DSETransformationRule<SwitchLandMatch, SwitchLandMatcher> tr = new DSETransformationRule<SwitchLandMatch, SwitchLandMatcher>(SwitchLandQuerySpecification.instance(), ap);
		return tr;
		
	}

}
