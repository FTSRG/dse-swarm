/**
 */
package ServerPark.impl;

import ServerPark.Machines;
import ServerPark.ServerParkPackage;

import java.lang.Integer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machines</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ServerPark.impl.MachinesImpl#getIP <em>IP</em>}</li>
 *   <li>{@link ServerPark.impl.MachinesImpl#getUsedMemory <em>Used Memory</em>}</li>
 *   <li>{@link ServerPark.impl.MachinesImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link ServerPark.impl.MachinesImpl#getDataTransitionOverhead <em>Data Transition Overhead</em>}</li>
 *   <li>{@link ServerPark.impl.MachinesImpl#getCPUNum <em>CPU Num</em>}</li>
 *   <li>{@link ServerPark.impl.MachinesImpl#getSerialNumber <em>Serial Number</em>}</li>
 *   <li>{@link ServerPark.impl.MachinesImpl#getMachineProcesses <em>Machine Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MachinesImpl extends MinimalEObjectImpl.Container implements Machines {
	/**
	 * The default value of the '{@link #getIP() <em>IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIP()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIP() <em>IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIP()
	 * @generated
	 * @ordered
	 */
	protected String ip = IP_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsedMemory() <em>Used Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedMemory()
	 * @generated
	 * @ordered
	 */
	protected static final int USED_MEMORY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUsedMemory() <em>Used Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedMemory()
	 * @generated
	 * @ordered
	 */
	protected int usedMemory = USED_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected static final int MEMORY_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected int memorySize = MEMORY_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataTransitionOverhead() <em>Data Transition Overhead</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTransitionOverhead()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerPark.Integer> dataTransitionOverhead;

	/**
	 * The default value of the '{@link #getCPUNum() <em>CPU Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCPUNum()
	 * @generated
	 * @ordered
	 */
	protected static final int CPU_NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCPUNum() <em>CPU Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCPUNum()
	 * @generated
	 * @ordered
	 */
	protected int cpuNum = CPU_NUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSerialNumber() <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int SERIAL_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSerialNumber() <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialNumber()
	 * @generated
	 * @ordered
	 */
	protected int serialNumber = SERIAL_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMachineProcesses() <em>Machine Processes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerPark.Process> machineProcesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachinesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerParkPackage.Literals.MACHINES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIP() {
		return ip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIP(String newIP) {
		String oldIP = ip;
		ip = newIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.MACHINES__IP, oldIP, ip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUsedMemory() {
		return usedMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedMemory(int newUsedMemory) {
		int oldUsedMemory = usedMemory;
		usedMemory = newUsedMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.MACHINES__USED_MEMORY, oldUsedMemory, usedMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMemorySize() {
		return memorySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySize(int newMemorySize) {
		int oldMemorySize = memorySize;
		memorySize = newMemorySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.MACHINES__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerPark.Integer> getDataTransitionOverhead() {
		if (dataTransitionOverhead == null) {
			dataTransitionOverhead = new EObjectContainmentEList<ServerPark.Integer>(ServerPark.Integer.class, this, ServerParkPackage.MACHINES__DATA_TRANSITION_OVERHEAD);
		}
		return dataTransitionOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCPUNum() {
		return cpuNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCPUNum(int newCPUNum) {
		int oldCPUNum = cpuNum;
		cpuNum = newCPUNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.MACHINES__CPU_NUM, oldCPUNum, cpuNum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerialNumber(int newSerialNumber) {
		int oldSerialNumber = serialNumber;
		serialNumber = newSerialNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.MACHINES__SERIAL_NUMBER, oldSerialNumber, serialNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerPark.Process> getMachineProcesses() {
		if (machineProcesses == null) {
			machineProcesses = new EObjectResolvingEList<ServerPark.Process>(ServerPark.Process.class, this, ServerParkPackage.MACHINES__MACHINE_PROCESSES);
		}
		return machineProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServerParkPackage.MACHINES__DATA_TRANSITION_OVERHEAD:
				return ((InternalEList<?>)getDataTransitionOverhead()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServerParkPackage.MACHINES__IP:
				return getIP();
			case ServerParkPackage.MACHINES__USED_MEMORY:
				return getUsedMemory();
			case ServerParkPackage.MACHINES__MEMORY_SIZE:
				return getMemorySize();
			case ServerParkPackage.MACHINES__DATA_TRANSITION_OVERHEAD:
				return getDataTransitionOverhead();
			case ServerParkPackage.MACHINES__CPU_NUM:
				return getCPUNum();
			case ServerParkPackage.MACHINES__SERIAL_NUMBER:
				return getSerialNumber();
			case ServerParkPackage.MACHINES__MACHINE_PROCESSES:
				return getMachineProcesses();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServerParkPackage.MACHINES__IP:
				setIP((String)newValue);
				return;
			case ServerParkPackage.MACHINES__USED_MEMORY:
				setUsedMemory((Integer)newValue);
				return;
			case ServerParkPackage.MACHINES__MEMORY_SIZE:
				setMemorySize((Integer)newValue);
				return;
			case ServerParkPackage.MACHINES__DATA_TRANSITION_OVERHEAD:
				getDataTransitionOverhead().clear();
				getDataTransitionOverhead().addAll((Collection<? extends ServerPark.Integer>)newValue);
				return;
			case ServerParkPackage.MACHINES__CPU_NUM:
				setCPUNum((Integer)newValue);
				return;
			case ServerParkPackage.MACHINES__SERIAL_NUMBER:
				setSerialNumber((Integer)newValue);
				return;
			case ServerParkPackage.MACHINES__MACHINE_PROCESSES:
				getMachineProcesses().clear();
				getMachineProcesses().addAll((Collection<? extends ServerPark.Process>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ServerParkPackage.MACHINES__IP:
				setIP(IP_EDEFAULT);
				return;
			case ServerParkPackage.MACHINES__USED_MEMORY:
				setUsedMemory(USED_MEMORY_EDEFAULT);
				return;
			case ServerParkPackage.MACHINES__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case ServerParkPackage.MACHINES__DATA_TRANSITION_OVERHEAD:
				getDataTransitionOverhead().clear();
				return;
			case ServerParkPackage.MACHINES__CPU_NUM:
				setCPUNum(CPU_NUM_EDEFAULT);
				return;
			case ServerParkPackage.MACHINES__SERIAL_NUMBER:
				setSerialNumber(SERIAL_NUMBER_EDEFAULT);
				return;
			case ServerParkPackage.MACHINES__MACHINE_PROCESSES:
				getMachineProcesses().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ServerParkPackage.MACHINES__IP:
				return IP_EDEFAULT == null ? ip != null : !IP_EDEFAULT.equals(ip);
			case ServerParkPackage.MACHINES__USED_MEMORY:
				return usedMemory != USED_MEMORY_EDEFAULT;
			case ServerParkPackage.MACHINES__MEMORY_SIZE:
				return memorySize != MEMORY_SIZE_EDEFAULT;
			case ServerParkPackage.MACHINES__DATA_TRANSITION_OVERHEAD:
				return dataTransitionOverhead != null && !dataTransitionOverhead.isEmpty();
			case ServerParkPackage.MACHINES__CPU_NUM:
				return cpuNum != CPU_NUM_EDEFAULT;
			case ServerParkPackage.MACHINES__SERIAL_NUMBER:
				return serialNumber != SERIAL_NUMBER_EDEFAULT;
			case ServerParkPackage.MACHINES__MACHINE_PROCESSES:
				return machineProcesses != null && !machineProcesses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (IP: ");
		result.append(ip);
		result.append(", UsedMemory: ");
		result.append(usedMemory);
		result.append(", MemorySize: ");
		result.append(memorySize);
		result.append(", CPUNum: ");
		result.append(cpuNum);
		result.append(", serialNumber: ");
		result.append(serialNumber);
		result.append(')');
		return result.toString();
	}

} //MachinesImpl
