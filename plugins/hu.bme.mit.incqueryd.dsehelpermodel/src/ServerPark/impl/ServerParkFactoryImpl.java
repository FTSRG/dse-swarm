/**
 */
package ServerPark.impl;

import ServerPark.EndMachine;
import ServerPark.Machines;
import ServerPark.ServerParkFactory;
import ServerPark.ServerParkPackage;
import ServerPark.UsedMachines;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServerParkFactoryImpl extends EFactoryImpl implements ServerParkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServerParkFactory init() {
		try {
			ServerParkFactory theServerParkFactory = (ServerParkFactory)EPackage.Registry.INSTANCE.getEFactory(ServerParkPackage.eNS_URI);
			if (theServerParkFactory != null) {
				return theServerParkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServerParkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerParkFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ServerParkPackage.USED_MACHINES: return createUsedMachines();
			case ServerParkPackage.MACHINES: return createMachines();
			case ServerParkPackage.INTEGER: return createInteger();
			case ServerParkPackage.PROCESS: return createProcess();
			case ServerParkPackage.END_MACHINE: return createEndMachine();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsedMachines createUsedMachines() {
		UsedMachinesImpl usedMachines = new UsedMachinesImpl();
		return usedMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machines createMachines() {
		MachinesImpl machines = new MachinesImpl();
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerPark.Integer createInteger() {
		IntegerImpl integer = new IntegerImpl();
		return integer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerPark.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndMachine createEndMachine() {
		EndMachineImpl endMachine = new EndMachineImpl();
		return endMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerParkPackage getServerParkPackage() {
		return (ServerParkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServerParkPackage getPackage() {
		return ServerParkPackage.eINSTANCE;
	}

} //ServerParkFactoryImpl
