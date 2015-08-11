package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.statecode.IStateCoder;

import ServerPark.Machines;
import ServerPark.UsedMachines;
import hu.bme.mit.incqueryd.dseopt.queries.ChangeProcessLocationMatch;
import hu.bme.mit.incqueryd.dseopt.queries.StartServerMatch;
import hu.bme.mit.incqueryd.dseopt.queries.StopServerMatch;

public class Serializer implements IStateCoder {

	private UsedMachines usedMachines;
	private ArrayList<Machines> allMachines;
	private ArrayList<Machines> runningMachines;
	private ArrayList<Machines> stoppedMachines;
	private ArrayList<ServerPark.Process> processes;

	

	@Override
	public void init(Notifier modelroot) {
		usedMachines = (UsedMachines) modelroot;

		processes = new ArrayList<ServerPark.Process>();
		for (ServerPark.Process process : usedMachines.getProcesses()) {
			processes.add(process);
		}

		allMachines = new ArrayList<Machines>();
		for (Machines machines : usedMachines.getAllMachines()) {
			allMachines.add(machines);
		}
		runningMachines = new ArrayList<Machines>();
		for (Machines machines : usedMachines.getRunning()) {
			runningMachines.add(machines);
		}

		stoppedMachines = new ArrayList<Machines>();
		for (Machines machines : usedMachines.getStopped()) {
			stoppedMachines.add(machines);
		}

		Collections.sort(allMachines, new Comparator<Machines>() {

			@Override
			public int compare(Machines arg0, Machines arg1) {

				String name1 = "ip: " + arg0.getIP();// +"cpu"+arg0.getCPUNum()+"mem"+arg0.getMemorySize()+"usedmem"+arg0.getUsedMemory();
				String name2 = "ip: " + arg1.getIP();// +"cpu"+arg1.getCPUNum()+"mem"+arg1.getMemorySize()+"usedmem"+arg1.getUsedMemory();
				return name1.compareTo(name2);
			}
		});

		Collections.sort(runningMachines, new Comparator<Machines>() {

			@Override
			public int compare(Machines arg0, Machines arg1) {

				String name1 = "ip: " + arg0.getIP();// +"cpu"+arg0.getCPUNum()+"mem"+arg0.getMemorySize()+"usedmem"+arg0.getUsedMemory();
				String name2 = "ip: " + arg1.getIP();// +"cpu"+arg1.getCPUNum()+"mem"+arg1.getMemorySize()+"usedmem"+arg1.getUsedMemory();
				return name1.compareTo(name2);
			}
		});

		Collections.sort(stoppedMachines, new Comparator<Machines>() {

			@Override
			public int compare(Machines arg0, Machines arg1) {
				String name1 = "ip: " + arg0.getIP();// +"cpu"+arg0.getCPUNum()+"mem"+arg0.getMemorySize()+"usedmem"+arg0.getUsedMemory();
				String name2 = "ip: " + arg1.getIP();// +"cpu"+arg1.getCPUNum()+"mem"+arg1.getMemorySize()+"usedmem"+arg1.getUsedMemory();
				return name1.compareTo(name2);
			}
		});

		Collections.sort(processes, new Comparator<ServerPark.Process>() {

			@Override
			public int compare(ServerPark.Process arg0, ServerPark.Process arg1) {

				return arg0.getId().compareTo(arg1.getId());
			}
		});

	}

	@Override
	public Object createStateCode() {

		StringBuilder sb = new StringBuilder();
		for (Machines machine : allMachines) {
			// sb.append("allapot: ip");

			sb.append(machine.getIP());
			if (usedMachines.getStopped().contains(machine)) {
				sb.append("stopped");
			}
			sb.append(": ");
			for (int i = 0; i < this.processes.size(); i++) {
				if (machine.getMachineProcesses().contains(processes.get(i))) {
					sb.append(" " + processes.get(i).getId());
				}
			}
			sb.append("  ");
		}
		// sb.append("regi");
		// for (Machines machine : runningMachines) {
		// sb.append("allapot: ip: ");
		// sb.append(machine.getIP());
		//// sb.append("cpu");
		//// sb.append(machine.getCPUNum());
		//// sb.append("mem");
		//// sb.append(machine.getMemorySize());
		//// sb.append("usedmem");
		//// sb.append(machine.getUsedMemory());
		//// sb.append(":");
		// // System.out.println(machine.getIP()+" processzek:
		// "+machine.getMachineProcesses().toString());
		// for (int i=0; i<this.processes.size(); i++){
		// if (machine.getMachineProcesses().contains(processes.get(i))){
		//
		// sb.append(" "+processes.get(i).getId());
		//// sb.append("size");
		//// sb.append(processes.get(i).getSize());
		//// sb.append(",");
		// }
		// }
		// sb.append(" ");
		// }
		// for (Machines machine : stoppedMachines) {
		// sb.append("stoppedip: ");
		// sb.append(machine.getIP());
		//// sb.append("cpu");
		//// sb.append(machine.getCPUNum());
		//// sb.append("mem");
		//// sb.append(machine.getMemorySize());
		//// sb.append("usedmem");
		//// sb.append(machine.getUsedMemory());
		// // sb.append(":");
		// for (int i=0; i<this.processes.size(); i++){
		// if (machine.getMachineProcesses().contains(processes.get(i))
		// ){
		// sb.append(processes.get(i).getId()+" ");
		//// sb.append("size");
		//// sb.append(processes.get(i).getSize());
		//// sb.append(",");
		// }
		// }
		// sb.append(" ");
		// }

		return sb.toString();
	}

	@Override
	public Object createActivationCode(IPatternMatch match) {
		if (match instanceof ChangeProcessLocationMatch) {
			ChangeProcessLocationMatch m = (ChangeProcessLocationMatch) match;
			return m.getProcess().getId() + ": " + m.getMachine1().getIP() + "-" + m.getMachine1().getUsedMemory()
					+ "->" + m.getMachine2().getIP() + "-" + m.getMachine2().getUsedMemory();
		} else if (match instanceof StartServerMatch) {
			StartServerMatch m = (StartServerMatch) match;
			return "started: " + m.getMachine().getIP() + "-" + m.getMachine().getMemorySize();
		} else if (match instanceof StopServerMatch) {
			StopServerMatch m = (StopServerMatch) match;
			return "stopped: " + m.getMachine().getIP() + "-" + m.getMachine().getMemorySize();
		} else {
			throw new DSEException("Unsupported rule.");
		}

	}

}
