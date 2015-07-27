/**
 */
package ServerPark.impl;

import ServerPark.EndMachine;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ServerPark.impl.ProcessImpl#getId <em>Id</em>}</li>
 *   <li>{@link ServerPark.impl.ProcessImpl#getSize <em>Size</em>}</li>
 *   <li>{@link ServerPark.impl.ProcessImpl#getBrotherProcesses <em>Brother Processes</em>}</li>
 *   <li>{@link ServerPark.impl.ProcessImpl#getEndMachine <em>End Machine</em>}</li>
 *   <li>{@link ServerPark.impl.ProcessImpl#getEndStateIp <em>End State Ip</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessImpl extends MinimalEObjectImpl.Container implements ServerPark.Process {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBrotherProcesses() <em>Brother Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrotherProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerPark.Process> brotherProcesses;

	/**
	 * The cached value of the '{@link #getEndMachine() <em>End Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndMachine()
	 * @generated
	 * @ordered
	 */
	protected EndMachine endMachine;

	/**
	 * The cached value of the '{@link #getEndStateIp() <em>End State Ip</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndStateIp()
	 * @generated
	 * @ordered
	 */
	protected Machines endStateIp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServerParkPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.PROCESS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.PROCESS__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerPark.Process> getBrotherProcesses() {
		if (brotherProcesses == null) {
			brotherProcesses = new EObjectContainmentEList<ServerPark.Process>(ServerPark.Process.class, this, ServerParkPackage.PROCESS__BROTHER_PROCESSES);
		}
		return brotherProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndMachine getEndMachine() {
		return endMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndMachine(EndMachine newEndMachine, NotificationChain msgs) {
		EndMachine oldEndMachine = endMachine;
		endMachine = newEndMachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServerParkPackage.PROCESS__END_MACHINE, oldEndMachine, newEndMachine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndMachine(EndMachine newEndMachine) {
		if (newEndMachine != endMachine) {
			NotificationChain msgs = null;
			if (endMachine != null)
				msgs = ((InternalEObject)endMachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServerParkPackage.PROCESS__END_MACHINE, null, msgs);
			if (newEndMachine != null)
				msgs = ((InternalEObject)newEndMachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServerParkPackage.PROCESS__END_MACHINE, null, msgs);
			msgs = basicSetEndMachine(newEndMachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.PROCESS__END_MACHINE, newEndMachine, newEndMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machines getEndStateIp() {
		if (endStateIp != null && endStateIp.eIsProxy()) {
			InternalEObject oldEndStateIp = (InternalEObject)endStateIp;
			endStateIp = (Machines)eResolveProxy(oldEndStateIp);
			if (endStateIp != oldEndStateIp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServerParkPackage.PROCESS__END_STATE_IP, oldEndStateIp, endStateIp));
			}
		}
		return endStateIp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machines basicGetEndStateIp() {
		return endStateIp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndStateIp(Machines newEndStateIp) {
		Machines oldEndStateIp = endStateIp;
		endStateIp = newEndStateIp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerParkPackage.PROCESS__END_STATE_IP, oldEndStateIp, endStateIp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServerParkPackage.PROCESS__BROTHER_PROCESSES:
				return ((InternalEList<?>)getBrotherProcesses()).basicRemove(otherEnd, msgs);
			case ServerParkPackage.PROCESS__END_MACHINE:
				return basicSetEndMachine(null, msgs);
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
			case ServerParkPackage.PROCESS__ID:
				return getId();
			case ServerParkPackage.PROCESS__SIZE:
				return getSize();
			case ServerParkPackage.PROCESS__BROTHER_PROCESSES:
				return getBrotherProcesses();
			case ServerParkPackage.PROCESS__END_MACHINE:
				return getEndMachine();
			case ServerParkPackage.PROCESS__END_STATE_IP:
				if (resolve) return getEndStateIp();
				return basicGetEndStateIp();
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
			case ServerParkPackage.PROCESS__ID:
				setId((String)newValue);
				return;
			case ServerParkPackage.PROCESS__SIZE:
				setSize((Integer)newValue);
				return;
			case ServerParkPackage.PROCESS__BROTHER_PROCESSES:
				getBrotherProcesses().clear();
				getBrotherProcesses().addAll((Collection<? extends ServerPark.Process>)newValue);
				return;
			case ServerParkPackage.PROCESS__END_MACHINE:
				setEndMachine((EndMachine)newValue);
				return;
			case ServerParkPackage.PROCESS__END_STATE_IP:
				setEndStateIp((Machines)newValue);
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
			case ServerParkPackage.PROCESS__ID:
				setId(ID_EDEFAULT);
				return;
			case ServerParkPackage.PROCESS__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ServerParkPackage.PROCESS__BROTHER_PROCESSES:
				getBrotherProcesses().clear();
				return;
			case ServerParkPackage.PROCESS__END_MACHINE:
				setEndMachine((EndMachine)null);
				return;
			case ServerParkPackage.PROCESS__END_STATE_IP:
				setEndStateIp((Machines)null);
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
			case ServerParkPackage.PROCESS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ServerParkPackage.PROCESS__SIZE:
				return size != SIZE_EDEFAULT;
			case ServerParkPackage.PROCESS__BROTHER_PROCESSES:
				return brotherProcesses != null && !brotherProcesses.isEmpty();
			case ServerParkPackage.PROCESS__END_MACHINE:
				return endMachine != null;
			case ServerParkPackage.PROCESS__END_STATE_IP:
				return endStateIp != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //ProcessImpl
