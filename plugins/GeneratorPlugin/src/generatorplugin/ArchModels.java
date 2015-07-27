package generatorplugin;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import arch.Configuration;

public class ArchModels {
	
	public Configuration start;
	public Configuration end;
	public void init(String startarch, String endarch){
		arch.ArchPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
		URI uri = URI.createFileURI(startarch);
		start = (arch.Configuration) loadResource(uri).getContents().get(0);
		URI uri2 = URI.createFileURI(endarch);
		end = (arch.Configuration) loadResource(uri2).getContents().get(0);
		//System.out.println(inv.getMachines().get(0).getName());
		
	}
	
	public Resource loadResource(URI uri) {
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
