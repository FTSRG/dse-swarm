package generatorplugin;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ServerPark.ServerParkPackage;



public class Generator {
	/***
	 * 
	 * @param startarch: waiting the pathname of the architecture-file of the start position
	 * example: D:/eclipse/eclipse_dse/runtime-EclipseApplication/test/peldak/pelda1/kezdeti/kimenet/pelda1-kezdeti.arch
	 * @param endarch: waiting the pathname of the architecture-file of the end position
	 * example: D:/eclipse/eclipse_dse/runtime-EclipseApplication/test/peldak/pelda1/kezdeti/kimenet/pelda1-veg.arch
	 * @param inventory:  waiting the pathname of the inventory-file
	 * example: D:/eclipse/eclipse_dse/runtime-EclipseApplication/test/peldak/pelda1/kezdeti/kimenet/pelda1-inventory.inventory
	 * @param serverpark:  waiting the pathname of the serverpark-file of the end position
	 * example for the pathnames: D:/eclipse/eclipse_dse/runtime-EclipseApplication/test/peldak/pelda1/kezdeti/kimenet/pelda1-kezdeti.serverpark
	 */
	
	public void generateNewServerpark(String startarch, String endarch, String inventory, String serverpark){
		DSEModels dsem = new DSEModels();
	    dsem.init(serverpark);
	    ArchModels archModels = new ArchModels();
	    archModels.init(startarch, endarch);
	    InventoryModels invModels = new InventoryModels();
	    invModels.init(inventory);
	   // dsem.setStartArch(archModels, invModels);
	    dsem.saveResource(dsem.rs);
	   // System.out.println(dsem.getAllMachines().toString());
	    // create
	   /* EntityRelationDiagram model = erdiagramModels.createModel();
	    // save
	    URI uri = URI.createFileURI("C:/workspace/hu.bme.mit.mdsd.erdiagram.example/samplemodel.erdiagram");
	    Resource resource = erdiagramModels.createResource(uri);
	    resource.getContents().add(model);
	    erdiagramModels.saveResource(resource);
	    // load
	    Resource resource2 = erdiagramModels.loadResource(uri);
	    EntityRelationDiagram model2 = erdiagramModels.getModelFromResource(resource2);
	    // print
	    erdiagramModels.printERDiagram(model2);
		
		
		
		
		URI uri = URI.createFileURI("/test/initial_incqueryd_allocation.arch");
		Resource resource1 = loadResource(uri);
		System.out.println(resource1.getURI());*/
	}
	
	public static void main(String[] args) {
		// init
	  
	   
		DSEModels dsem = new DSEModels();
	    dsem.init(args[3]);
	    ArchModels archModels = new ArchModels();
	    archModels.init(args[0], args[1]);
	    InventoryModels invModels = new InventoryModels();
	    invModels.init(args[2]);
	    //dsem.setStartArch(archModels, invModels);
	    dsem.saveResource(dsem.rs);
	   // System.out.println(dsem.getAllMachines().toString());
	   
	}
	
	public static void init(){
		ServerParkPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("serverpark", new XMIResourceFactoryImpl());
		
	}
	
	public static Resource loadResource(URI uri) {
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.getResource(uri, true);
	    return resource;
	}
		
	public void saveResource(Resource resource) {
		   try {
		     resource.save(Collections.EMPTY_MAP);
		   } catch (IOException e) {
		      System.out.println("The following error occured during saving the resource: "
		        + e.getMessage());
		   }
		}
	
}
