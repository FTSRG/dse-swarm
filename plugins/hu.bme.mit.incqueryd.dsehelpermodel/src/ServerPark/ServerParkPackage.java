/**
 */
package ServerPark;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ServerPark.ServerParkFactory
 * @model kind="package"
 * @generated
 */
public interface ServerParkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ServerPark";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "mit.bme.hu.serverpark";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mit.bme.hu.serverpark";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServerParkPackage eINSTANCE = ServerPark.impl.ServerParkPackageImpl.init();

	/**
	 * The meta object id for the '{@link ServerPark.impl.UsedMachinesImpl <em>Used Machines</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ServerPark.impl.UsedMachinesImpl
	 * @see ServerPark.impl.ServerParkPackageImpl#getUsedMachines()
	 * @generated
	 */
	int USED_MACHINES = 0;

	/**
	 * The feature id for the '<em><b>Running</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES__RUNNING = 0;

	/**
	 * The feature id for the '<em><b>Stopped</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES__STOPPED = 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES__PROCESSES = 2;

	/**
	 * The feature id for the '<em><b>New Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES__NEW_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>All Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES__ALL_MACHINES = 4;

	/**
	 * The number of structural features of the '<em>Used Machines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Used Machines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_MACHINES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ServerPark.impl.MachinesImpl <em>Machines</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ServerPark.impl.MachinesImpl
	 * @see ServerPark.impl.ServerParkPackageImpl#getMachines()
	 * @generated
	 */
	int MACHINES = 1;

	/**
	 * The feature id for the '<em><b>IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__IP = 0;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__USED_MEMORY = 1;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__MEMORY_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Data Transition Overhead</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__DATA_TRANSITION_OVERHEAD = 3;

	/**
	 * The feature id for the '<em><b>CPU Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__CPU_NUM = 4;

	/**
	 * The feature id for the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__SERIAL_NUMBER = 5;

	/**
	 * The feature id for the '<em><b>Machine Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES__MACHINE_PROCESSES = 6;

	/**
	 * The number of structural features of the '<em>Machines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Machines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ServerPark.impl.IntegerImpl <em>Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ServerPark.impl.IntegerImpl
	 * @see ServerPark.impl.ServerParkPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Communication</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER__COMMUNICATION = 1;

	/**
	 * The number of structural features of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ServerPark.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ServerPark.impl.ProcessImpl
	 * @see ServerPark.impl.ServerParkPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ID = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SIZE = 1;

	/**
	 * The feature id for the '<em><b>Brother Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__BROTHER_PROCESSES = 2;

	/**
	 * The feature id for the '<em><b>End Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__END_MACHINE = 3;

	/**
	 * The feature id for the '<em><b>End State Ip</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__END_STATE_IP = 4;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ServerPark.impl.EndMachineImpl <em>End Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ServerPark.impl.EndMachineImpl
	 * @see ServerPark.impl.ServerParkPackageImpl#getEndMachine()
	 * @generated
	 */
	int END_MACHINE = 4;

	/**
	 * The feature id for the '<em><b>CPU Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_MACHINE__CPU_NUM = 0;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_MACHINE__MEMORY_SIZE = 1;

	/**
	 * The number of structural features of the '<em>End Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_MACHINE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>End Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_MACHINE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link ServerPark.UsedMachines <em>Used Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Used Machines</em>'.
	 * @see ServerPark.UsedMachines
	 * @generated
	 */
	EClass getUsedMachines();

	/**
	 * Returns the meta object for the reference list '{@link ServerPark.UsedMachines#getRunning <em>Running</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Running</em>'.
	 * @see ServerPark.UsedMachines#getRunning()
	 * @see #getUsedMachines()
	 * @generated
	 */
	EReference getUsedMachines_Running();

	/**
	 * Returns the meta object for the reference list '{@link ServerPark.UsedMachines#getStopped <em>Stopped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stopped</em>'.
	 * @see ServerPark.UsedMachines#getStopped()
	 * @see #getUsedMachines()
	 * @generated
	 */
	EReference getUsedMachines_Stopped();

	/**
	 * Returns the meta object for the containment reference list '{@link ServerPark.UsedMachines#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see ServerPark.UsedMachines#getProcesses()
	 * @see #getUsedMachines()
	 * @generated
	 */
	EReference getUsedMachines_Processes();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.UsedMachines#getNewAttribute <em>New Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Attribute</em>'.
	 * @see ServerPark.UsedMachines#getNewAttribute()
	 * @see #getUsedMachines()
	 * @generated
	 */
	EAttribute getUsedMachines_NewAttribute();

	/**
	 * Returns the meta object for the containment reference list '{@link ServerPark.UsedMachines#getAllMachines <em>All Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All Machines</em>'.
	 * @see ServerPark.UsedMachines#getAllMachines()
	 * @see #getUsedMachines()
	 * @generated
	 */
	EReference getUsedMachines_AllMachines();

	/**
	 * Returns the meta object for class '{@link ServerPark.Machines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machines</em>'.
	 * @see ServerPark.Machines
	 * @generated
	 */
	EClass getMachines();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Machines#getIP <em>IP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IP</em>'.
	 * @see ServerPark.Machines#getIP()
	 * @see #getMachines()
	 * @generated
	 */
	EAttribute getMachines_IP();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Machines#getUsedMemory <em>Used Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used Memory</em>'.
	 * @see ServerPark.Machines#getUsedMemory()
	 * @see #getMachines()
	 * @generated
	 */
	EAttribute getMachines_UsedMemory();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Machines#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see ServerPark.Machines#getMemorySize()
	 * @see #getMachines()
	 * @generated
	 */
	EAttribute getMachines_MemorySize();

	/**
	 * Returns the meta object for the containment reference list '{@link ServerPark.Machines#getDataTransitionOverhead <em>Data Transition Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Transition Overhead</em>'.
	 * @see ServerPark.Machines#getDataTransitionOverhead()
	 * @see #getMachines()
	 * @generated
	 */
	EReference getMachines_DataTransitionOverhead();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Machines#getCPUNum <em>CPU Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CPU Num</em>'.
	 * @see ServerPark.Machines#getCPUNum()
	 * @see #getMachines()
	 * @generated
	 */
	EAttribute getMachines_CPUNum();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Machines#getSerialNumber <em>Serial Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serial Number</em>'.
	 * @see ServerPark.Machines#getSerialNumber()
	 * @see #getMachines()
	 * @generated
	 */
	EAttribute getMachines_SerialNumber();

	/**
	 * Returns the meta object for the reference list '{@link ServerPark.Machines#getMachineProcesses <em>Machine Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Machine Processes</em>'.
	 * @see ServerPark.Machines#getMachineProcesses()
	 * @see #getMachines()
	 * @generated
	 */
	EReference getMachines_MachineProcesses();

	/**
	 * Returns the meta object for class '{@link ServerPark.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer</em>'.
	 * @see ServerPark.Integer
	 * @generated
	 */
	EClass getInteger();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Integer#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ServerPark.Integer#getValue()
	 * @see #getInteger()
	 * @generated
	 */
	EAttribute getInteger_Value();

	/**
	 * Returns the meta object for the reference '{@link ServerPark.Integer#getCommunication <em>Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Communication</em>'.
	 * @see ServerPark.Integer#getCommunication()
	 * @see #getInteger()
	 * @generated
	 */
	EReference getInteger_Communication();

	/**
	 * Returns the meta object for class '{@link ServerPark.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see ServerPark.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Process#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ServerPark.Process#getId()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Id();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.Process#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see ServerPark.Process#getSize()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Size();

	/**
	 * Returns the meta object for the containment reference list '{@link ServerPark.Process#getBrotherProcesses <em>Brother Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Brother Processes</em>'.
	 * @see ServerPark.Process#getBrotherProcesses()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_BrotherProcesses();

	/**
	 * Returns the meta object for the containment reference '{@link ServerPark.Process#getEndMachine <em>End Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Machine</em>'.
	 * @see ServerPark.Process#getEndMachine()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_EndMachine();

	/**
	 * Returns the meta object for the reference '{@link ServerPark.Process#getEndStateIp <em>End State Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End State Ip</em>'.
	 * @see ServerPark.Process#getEndStateIp()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_EndStateIp();

	/**
	 * Returns the meta object for class '{@link ServerPark.EndMachine <em>End Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Machine</em>'.
	 * @see ServerPark.EndMachine
	 * @generated
	 */
	EClass getEndMachine();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.EndMachine#getCPUNum <em>CPU Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CPU Num</em>'.
	 * @see ServerPark.EndMachine#getCPUNum()
	 * @see #getEndMachine()
	 * @generated
	 */
	EAttribute getEndMachine_CPUNum();

	/**
	 * Returns the meta object for the attribute '{@link ServerPark.EndMachine#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see ServerPark.EndMachine#getMemorySize()
	 * @see #getEndMachine()
	 * @generated
	 */
	EAttribute getEndMachine_MemorySize();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServerParkFactory getServerParkFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ServerPark.impl.UsedMachinesImpl <em>Used Machines</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ServerPark.impl.UsedMachinesImpl
		 * @see ServerPark.impl.ServerParkPackageImpl#getUsedMachines()
		 * @generated
		 */
		EClass USED_MACHINES = eINSTANCE.getUsedMachines();

		/**
		 * The meta object literal for the '<em><b>Running</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_MACHINES__RUNNING = eINSTANCE.getUsedMachines_Running();

		/**
		 * The meta object literal for the '<em><b>Stopped</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_MACHINES__STOPPED = eINSTANCE.getUsedMachines_Stopped();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_MACHINES__PROCESSES = eINSTANCE.getUsedMachines_Processes();

		/**
		 * The meta object literal for the '<em><b>New Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USED_MACHINES__NEW_ATTRIBUTE = eINSTANCE.getUsedMachines_NewAttribute();

		/**
		 * The meta object literal for the '<em><b>All Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_MACHINES__ALL_MACHINES = eINSTANCE.getUsedMachines_AllMachines();

		/**
		 * The meta object literal for the '{@link ServerPark.impl.MachinesImpl <em>Machines</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ServerPark.impl.MachinesImpl
		 * @see ServerPark.impl.ServerParkPackageImpl#getMachines()
		 * @generated
		 */
		EClass MACHINES = eINSTANCE.getMachines();

		/**
		 * The meta object literal for the '<em><b>IP</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINES__IP = eINSTANCE.getMachines_IP();

		/**
		 * The meta object literal for the '<em><b>Used Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINES__USED_MEMORY = eINSTANCE.getMachines_UsedMemory();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINES__MEMORY_SIZE = eINSTANCE.getMachines_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Data Transition Overhead</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINES__DATA_TRANSITION_OVERHEAD = eINSTANCE.getMachines_DataTransitionOverhead();

		/**
		 * The meta object literal for the '<em><b>CPU Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINES__CPU_NUM = eINSTANCE.getMachines_CPUNum();

		/**
		 * The meta object literal for the '<em><b>Serial Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINES__SERIAL_NUMBER = eINSTANCE.getMachines_SerialNumber();

		/**
		 * The meta object literal for the '<em><b>Machine Processes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINES__MACHINE_PROCESSES = eINSTANCE.getMachines_MachineProcesses();

		/**
		 * The meta object literal for the '{@link ServerPark.impl.IntegerImpl <em>Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ServerPark.impl.IntegerImpl
		 * @see ServerPark.impl.ServerParkPackageImpl#getInteger()
		 * @generated
		 */
		EClass INTEGER = eINSTANCE.getInteger();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER__VALUE = eINSTANCE.getInteger_Value();

		/**
		 * The meta object literal for the '<em><b>Communication</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER__COMMUNICATION = eINSTANCE.getInteger_Communication();

		/**
		 * The meta object literal for the '{@link ServerPark.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ServerPark.impl.ProcessImpl
		 * @see ServerPark.impl.ServerParkPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__ID = eINSTANCE.getProcess_Id();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__SIZE = eINSTANCE.getProcess_Size();

		/**
		 * The meta object literal for the '<em><b>Brother Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__BROTHER_PROCESSES = eINSTANCE.getProcess_BrotherProcesses();

		/**
		 * The meta object literal for the '<em><b>End Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__END_MACHINE = eINSTANCE.getProcess_EndMachine();

		/**
		 * The meta object literal for the '<em><b>End State Ip</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__END_STATE_IP = eINSTANCE.getProcess_EndStateIp();

		/**
		 * The meta object literal for the '{@link ServerPark.impl.EndMachineImpl <em>End Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ServerPark.impl.EndMachineImpl
		 * @see ServerPark.impl.ServerParkPackageImpl#getEndMachine()
		 * @generated
		 */
		EClass END_MACHINE = eINSTANCE.getEndMachine();

		/**
		 * The meta object literal for the '<em><b>CPU Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute END_MACHINE__CPU_NUM = eINSTANCE.getEndMachine_CPUNum();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute END_MACHINE__MEMORY_SIZE = eINSTANCE.getEndMachine_MemorySize();

	}

} //ServerParkPackage
