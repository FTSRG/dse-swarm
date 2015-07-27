package generatorplugin;

import infrastructure.Machine;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ServerPark.Machines;
import ServerPark.ServerParkFactory;
import ServerPark.ServerParkPackage;
import ServerPark.UsedMachines;

public class DSEModels {
	
	UsedMachines startPos;
	ServerParkFactory factory;
	EList<Machine>startarchmachines;
	EList<Machine> endarchmachines;
	EList<EObject> inventorymachines;
	EList<Machines> running;
	EList<Machines> all;
	
	
	
	Resource rs;

	public void init(String output){
	
		ServerParkPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("serverpark", new XMIResourceFactoryImpl());
		URI startURI = URI.createFileURI(output);
		rs = createResource(startURI);
		//startPos = (UsedMachines) loadResource(startURI).getContents().get(0);
		//loadResource(startURI);
		//System.out.println(startPos.getAllMachines().toString());
		this.saveResource(rs);
		System.out.println("hali");
		
		factory =  ServerParkFactory.eINSTANCE;
		startPos = factory.createUsedMachines();
		rs.getContents().add(startPos);
		
	}
	
	public Resource createResource(URI uri) {
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.createResource(uri);
	 
	    return resource;
	}
	
	public Resource loadResource(URI uri) {
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.getResource(uri, true);
	    System.out.println(resource.getContents().toString());
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
	
	
/*	public void setStartArch(ArchModels start, InventoryModels inv){
		startarchmachines = start.start.getMachines();
		inventorymachines= inv.getMachineSet().eContents();
		running = getRunning();
		endarchmachines = start.end.getMachines();		
		
		for (Machine machine : startarchmachines) {
			newMachine(machine, true);			
		}
		//add stopped machines to serverpark
		for (Machine machine : endarchmachines) {
			boolean contained = false;
			for (Machines runningmachines : running) {
				if (runningmachines.getIP().equals(machine.getIp())) contained=true;
			}
			if (contained == false){
				newMachine(machine, false);
			}
		}
		//add processes to serverpark
		for (Machine machine : startarchmachines) {
			EList<infrastructure.Process> processes= machine.getProcesses();
			for (infrastructure.Process process : processes) {
				//új processz létrehozva
				this.newProcess(process);				
			}			
		}
		
		//order processes to Machines
				for (Machine machine : startarchmachines) {
					this.setMachineprocesses(machine);		
				}
		
		//setEndmachines
		for (Machine machine : endarchmachines) {
			this.setEndMachine(machine);
		}
		//set machineVaulues
		for (EObject eObject : inventorymachines) {
			inventory.Machine m = (inventory.Machine) eObject;
			this.setMachineValues(m);
		}
		
		//change the names of the processes into unique names
		this.changeProcessNames();
		
		
	}
	
	
	
	public EList<Machines> getRunning() {
		return startPos.getRunning();
	}

	public EList<Machines> getStopped() {
		return startPos.getStopped();
	}

	public EList<Process> getProcesses() {
		return startPos.getProcesses();
	}

	public EList<Machines> getAllMachines() {
		//if (startPos.getAllMachines()!=null)
			return startPos.getAllMachines();
		//else return null;
		
	}
	
	public void newMachine(Machine oldMachine, boolean running){
		Machines newMachine = factory.createMachines();
		newMachine.setIP(oldMachine.getIp());
		getAllMachines().add(newMachine);
		if (running==true){
			getRunning().add(newMachine);
		}
		else{
			getStopped().add(newMachine);
		}
	}
	
	public Process newProcess(infrastructure.Process oldprocess){
		ServerPark.Process newProcess = factory.createProcess();
		newProcess.setSize(oldprocess.getMemory());
		int id = oldprocess.getPort();
		newProcess.setId(String.valueOf(id));
		getProcesses().add(newProcess);
		return newProcess;
	}
	
	public Machine getEndArchMachine(String IP){
		for (Machine machine : endarchmachines) {
			if (machine.getIp().equals(IP)){
				return machine;
			}
		}
		return null;
	}
	
	public Machines findMachineToMachines(Machine machine){
		EList<Machines> machineslist =  getAllMachines();
		for (Machines machines : machineslist) {
			if(machines.getIP().equals(machine.getIp())){
				return machines;
			}
		}
		return null;
	}
	public Process getProcesswithIp(String ip){
		EList<Process> processes = getProcesses();
		for (Process process : processes) {
			if(process.equals(ip)){
				return process;
			}
		}
		return null;
	}
	/*	public void setEndMachine(infrastructure.Machine endmachine){
		//ha egy process ugyan onnan indult, mint ahol megallt, akkor azt nem helyezzuk at
	//	ArrayList<Processhelper> phelper = new ArrayList<Processhelper>();		
		for (Machine machine : startarchmachines) {
			EList<infrastructure.Process> machineprocesses = machine.getProcesses();
			EList<infrastructure.Process> endmachineprocesses = getEndArchMachine(machine.getIp()).getProcesses();
		for (infrastructure.Process process : machineprocesses) {				
				Processhelper phelper1 = new Processhelper(machine, process.getTraceInfo(), String.valueOf(process.getPort()), process.getMemory());
				phelper.add(phelper1);
				for (infrastructure.Process process2 : endmachineprocesses) {
					if (phelper1.isequal(getEndArchMachine(machine.getIp()), process2)==true){
						this.getProcesswithIp(String.valueOf(process2.getPort())+machine.getIp());
						phelper1.setend(getEndArchMachine(machine.getIp()), String.valueOf(process2.getPort()));
					}
				}
			}
					
			
		}
	//amugy keresunk egy ugyan olyan processzt a vegere a phelperben minden processzhez kell, hogy tartozzon egy kezdo es egy veg allapot
	for (Machine machine: this.endarchmachines) {
		EList<infrastructure.Process> endmachineprocesses = machine.getProcesses();
		for (infrastructure.Process process : endmachineprocesses) {
			for (int i=0; i<phelper.size(); i++){
				if(phelper.get(i).isEndproc(machine, process)==true) break;
			}
			
		}
	}
	
	for (int i=0; i<phelper.size(); i++){
		for (Machines machine : this.startPos.getAllMachines()) {
			EList<Process> processes = machine.getMachineProcesses();
			for (Process process : processes) {
				if (process.getId().equals(phelper.get(i).getStartPort())&& machine.getIP().equals(phelper.get(i).getStartIP())){
					process.setEndStateIp(this.getMachineswithIP(phelper.get(i).getendIp()));
				}
			}		
			
		}
		
	}
	}
	
	public void setMachineValues(inventory.Machine invmachine){
		MachineInstance mi = (MachineInstance) invmachine;
		Machines machine = this.getMachineswithIP(String.valueOf(mi.getIp()));
		if(machine==null){return;}
		machine.setCPUNum(invmachine.getCPUs());
		if (invmachine.getMemoryUnit().equals("GB")){
			machine.setMemorySize(invmachine.getMemorySize()*1024);
		}
		else{
			machine.setMemorySize(invmachine.getMemorySize());		
		}
	}
	
	public void setUsedMemory(){
		EList<Machines> machines = getAllMachines();
		for (Machines machine : machines) {			
			EList<Process> processes = machine.getMachineProcesses();
			int usedMemory = 0;
			for (Process process : processes) {
				usedMemory+=process.getSize();
				machine.setUsedMemory(usedMemory);
			}			
		}
	}
	
	public Machines getMachineswithIP(String IP){
		EList<Machines> machines = getAllMachines();
		for (Machines machines2 : machines) {
			if (machines2.getIP().equals(IP)){
				return machines2;
			}
		}
		return null;
	}
	
	public void changeProcessNames(){
		EList<Process> processes = getProcesses();
		for (Process process : processes) {
			process.setId(process.getEndStateIp().getIP()+":"+process.getId());
		}
	}
	
	
	public void setMachineprocesses(Machine m){
		String ip = m.getIp();
		EList<Machines> dseMachines = getAllMachines();
		EList<infrastructure.Process> processes = m.getProcesses();
		for (Machines machines : dseMachines) {
			if(machines.getIP().equals(ip)){
				EList<Process> dseProcesses = this.startPos.getProcesses();
				for (Process process : dseProcesses) {
					for(int i=0; i<processes.size(); i++){
						if(process.getId().equals(String.valueOf(processes.get(i).getPort()))){
							machines.getMachineProcesses().add(process);
						}
					}
				}
			}
			
			
		}
		
	}*/
}
