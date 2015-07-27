/**
 */
package ServerPark.impl;

import ServerPark.EndMachine;
import ServerPark.ServerParkPackage;

import java.lang.Integer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ServerPark.impl.EndMachineImpl#getCPUNum <em>CPU Num</em>}</li>
 *   <li>{@link ServerPark.impl.EndMachineImpl#getMemorySize <em>Memory Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndMachineImpl extends MinimalEObjectImpl.Container implements EndMachine {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerParkPackage.Literals.END_MACHINE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.END_MACHINE__CPU_NUM, oldCPUNum, cpuNum));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.END_MACHINE__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServerParkPackage.END_MACHINE__CPU_NUM:
				return getCPUNum();
			case ServerParkPackage.END_MACHINE__MEMORY_SIZE:
				return getMemorySize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServerParkPackage.END_MACHINE__CPU_NUM:
				setCPUNum((Integer)newValue);
				return;
			case ServerParkPackage.END_MACHINE__MEMORY_SIZE:
				setMemorySize((Integer)newValue);
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
			case ServerParkPackage.END_MACHINE__CPU_NUM:
				setCPUNum(CPU_NUM_EDEFAULT);
				return;
			case ServerParkPackage.END_MACHINE__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
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
			case ServerParkPackage.END_MACHINE__CPU_NUM:
				return cpuNum != CPU_NUM_EDEFAULT;
			case ServerParkPackage.END_MACHINE__MEMORY_SIZE:
				return memorySize != MEMORY_SIZE_EDEFAULT;
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
		result.append(" (CPUNum: ");
		result.append(cpuNum);
		result.append(", MemorySize: ");
		result.append(memorySize);
		result.append(')');
		return result.toString();
	}

} //EndMachineImpl
