package generatorplugin;

import inventory.Inventory;
import inventory.InventoryPackage;
import inventory.MachineSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class InventoryModels {
	Inventory inv;
	public MachineSet getMachineSet() {
		return inv.getMachineSet();
	}
	public void setMachineSet(MachineSet value) {
		inv.setMachineSet(value);
	}
	public void init(String inventory){
		InventoryPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("inventory", new XMIResourceFactoryImpl());
		URI uri = URI.createFileURI(inventory);
		inv = (Inventory) loadResource(uri).getContents().get(0);
		System.out.println(inv.getMachineSet().eContents().toString());
		//System.out.println(inv.getMachines().get(0).getName());
	}
	public Resource loadResource(URI uri) {
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.getResource(uri, true);
	    System.out.println(resource.getContents().toString());
	    return resource;
	}
	


}
