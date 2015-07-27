/**
 */
package ServerPark.impl;

import ServerPark.Machines;
import ServerPark.ServerParkPackage;
import ServerPark.UsedMachines;

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
 * An implementation of the model object '<em><b>Used Machines</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ServerPark.impl.UsedMachinesImpl#getRunning <em>Running</em>}</li>
 *   <li>{@link ServerPark.impl.UsedMachinesImpl#getStopped <em>Stopped</em>}</li>
 *   <li>{@link ServerPark.impl.UsedMachinesImpl#getProcesses <em>Processes</em>}</li>
 *   <li>{@link ServerPark.impl.UsedMachinesImpl#getNewAttribute <em>New Attribute</em>}</li>
 *   <li>{@link ServerPark.impl.UsedMachinesImpl#getAllMachines <em>All Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsedMachinesImpl extends MinimalEObjectImpl.Container implements UsedMachines {
	/**
	 * The cached value of the '{@link #getRunning() <em>Running</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunning()
	 * @generated
	 * @ordered
	 */
	protected EList<Machines> running;

	/**
	 * The cached value of the '{@link #getStopped() <em>Stopped</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopped()
	 * @generated
	 * @ordered
	 */
	protected EList<Machines> stopped;

	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerPark.Process> processes;

	/**
	 * The default value of the '{@link #getNewAttribute() <em>New Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewAttribute() <em>New Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewAttribute()
	 * @generated
	 * @ordered
	 */
	protected String newAttribute = NEW_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllMachines() <em>All Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<Machines> allMachines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsedMachinesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerParkPackage.Literals.USED_MACHINES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Machines> getRunning() {
		if (running == null) {
			running = new EObjectResolvingEList<Machines>(Machines.class, this, ServerParkPackage.USED_MACHINES__RUNNING);
		}
		return running;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Machines> getStopped() {
		if (stopped == null) {
			stopped = new EObjectResolvingEList<Machines>(Machines.class, this, ServerParkPackage.USED_MACHINES__STOPPED);
		}
		return stopped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerPark.Process> getProcesses() {
		if (processes == null) {
			processes = new EObjectContainmentEList<ServerPark.Process>(ServerPark.Process.class, this, ServerParkPackage.USED_MACHINES__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewAttribute() {
		return newAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewAttribute(String newNewAttribute) {
		String oldNewAttribute = newAttribute;
		newAttribute = newNewAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.USED_MACHINES__NEW_ATTRIBUTE, oldNewAttribute, newAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Machines> getAllMachines() {
		if (allMachines == null) {
			allMachines = new EObjectContainmentEList<Machines>(Machines.class, this, ServerParkPackage.USED_MACHINES__ALL_MACHINES);
		}
		return allMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServerParkPackage.USED_MACHINES__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
			case ServerParkPackage.USED_MACHINES__ALL_MACHINES:
				return ((InternalEList<?>)getAllMachines()).basicRemove(otherEnd, msgs);
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
			case ServerParkPackage.USED_MACHINES__RUNNING:
				return getRunning();
			case ServerParkPackage.USED_MACHINES__STOPPED:
				return getStopped();
			case ServerParkPackage.USED_MACHINES__PROCESSES:
				return getProcesses();
			case ServerParkPackage.USED_MACHINES__NEW_ATTRIBUTE:
				return getNewAttribute();
			case ServerParkPackage.USED_MACHINES__ALL_MACHINES:
				return getAllMachines();
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
			case ServerParkPackage.USED_MACHINES__RUNNING:
				getRunning().clear();
				getRunning().addAll((Collection<? extends Machines>)newValue);
				return;
			case ServerParkPackage.USED_MACHINES__STOPPED:
				getStopped().clear();
				getStopped().addAll((Collection<? extends Machines>)newValue);
				return;
			case ServerParkPackage.USED_MACHINES__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends ServerPark.Process>)newValue);
				return;
			case ServerParkPackage.USED_MACHINES__NEW_ATTRIBUTE:
				setNewAttribute((String)newValue);
				return;
			case ServerParkPackage.USED_MACHINES__ALL_MACHINES:
				getAllMachines().clear();
				getAllMachines().addAll((Collection<? extends Machines>)newValue);
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
			case ServerParkPackage.USED_MACHINES__RUNNING:
				getRunning().clear();
				return;
			case ServerParkPackage.USED_MACHINES__STOPPED:
				getStopped().clear();
				return;
			case ServerParkPackage.USED_MACHINES__PROCESSES:
				getProcesses().clear();
				return;
			case ServerParkPackage.USED_MACHINES__NEW_ATTRIBUTE:
				setNewAttribute(NEW_ATTRIBUTE_EDEFAULT);
				return;
			case ServerParkPackage.USED_MACHINES__ALL_MACHINES:
				getAllMachines().clear();
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
			case ServerParkPackage.USED_MACHINES__RUNNING:
				return running != null && !running.isEmpty();
			case ServerParkPackage.USED_MACHINES__STOPPED:
				return stopped != null && !stopped.isEmpty();
			case ServerParkPackage.USED_MACHINES__PROCESSES:
				return processes != null && !processes.isEmpty();
			case ServerParkPackage.USED_MACHINES__NEW_ATTRIBUTE:
				return NEW_ATTRIBUTE_EDEFAULT == null ? newAttribute != null : !NEW_ATTRIBUTE_EDEFAULT.equals(newAttribute);
			case ServerParkPackage.USED_MACHINES__ALL_MACHINES:
				return allMachines != null && !allMachines.isEmpty();
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
		result.append(" (newAttribute: ");
		result.append(newAttribute);
		result.append(')');
		return result.toString();
	}

} //UsedMachinesImpl
