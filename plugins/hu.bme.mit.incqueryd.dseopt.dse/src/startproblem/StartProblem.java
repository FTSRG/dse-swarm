package startproblem;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ServerPark.Machines;
import ServerPark.Process;
import ServerPark.ServerParkPackage;
import ServerPark.UsedMachines;

public class StartProblem {
	
	UsedMachines UM;
	
	public StartProblem(){
		init();
	}

	private void init() {
		 ServerParkPackage.eINSTANCE.eClass();
		   // Defining that the files with the .erdiagram extension should be parsed as an xmi.
		   Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		   reg.getExtensionToFactoryMap().put("serverpark", new XMIResourceFactoryImpl());
		   load();	
	}

	private Resource load() {
		// TODO Auto-generated method stub
		 ResourceSet resSet = new ResourceSetImpl();
		String uristring = "D:/eclipse/eclipse_dse/runtime-EclipseApplication/test/startstate.serverpark";
		 //String uristring ="D:/eclipse/eclipse_dse/runtime-EclipseApplication/test/helper_incqueryd_machineData.serverpark";
		 URI uri = URI.createFileURI(uristring);
		 Resource resource = resSet.getResource(uri, true);
		 UM = (UsedMachines) resource.getContents().get(0);
		 //System.out.println(UM.toString());
		 
		 return resource;
		
	}

	public EList<Adapter> eAdapters() {
		return UM.eAdapters();
	}

	public boolean eDeliver() {
		return UM.eDeliver();
	}

	public void eSetDeliver(boolean deliver) {
		UM.eSetDeliver(deliver);
	}

	public void eNotify(Notification notification) {
		UM.eNotify(notification);
	}

	public EList<Process> getProcesses() {
		return UM.getProcesses();
	}

	public String getNewAttribute() {
		return UM.getNewAttribute();
	}

	public EClass eClass() {
		return UM.eClass();
	}

	public void setNewAttribute(String value) {
		UM.setNewAttribute(value);
	}

	public Resource eResource() {
		return UM.eResource();
	}

	public EObject eContainer() {
		return UM.eContainer();
	}

	public EStructuralFeature eContainingFeature() {
		return UM.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		return UM.eContainmentFeature();
	}

	public EList<EObject> eContents() {
		return UM.eContents();
	}

	public TreeIterator<EObject> eAllContents() {
		return UM.eAllContents();
	}

	public boolean eIsProxy() {
		return UM.eIsProxy();
	}

	public EList<EObject> eCrossReferences() {
		return UM.eCrossReferences();
	}

	public Object eGet(EStructuralFeature feature) {
		return UM.eGet(feature);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return UM.eGet(feature, resolve);
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		UM.eSet(feature, newValue);
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return UM.eIsSet(feature);
	}

	public void eUnset(EStructuralFeature feature) {
		UM.eUnset(feature);
	}

	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return UM.eInvoke(operation, arguments);
	}

	public UsedMachines getUsedMachines() {
		// TODO Auto-generated method stub
		return UM;
	}
	
	public EList<Machines> getRunningMachines(){
		return UM.getRunning();
	}
	
	public EList<Machines> getStoppedMachines(){
		return UM.getStopped();
	}
	public UsedMachines getModel(){
		return UM;
	}

}
