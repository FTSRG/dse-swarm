/**
 */
package onlab.impl;

import java.util.Collection;

import onlab.Land;
import onlab.OnlabPackage;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passanger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link onlab.impl.PassangerImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link onlab.impl.PassangerImpl#getDangerousfor <em>Dangerousfor</em>}</li>
 *   <li>{@link onlab.impl.PassangerImpl#getLand <em>Land</em>}</li>
 *   <li>{@link onlab.impl.PassangerImpl#getTravelOn <em>Travel On</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PassangerImpl extends ObjectImpl implements Passanger {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Land target;

	/**
	 * The cached value of the '{@link #getDangerousfor() <em>Dangerousfor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDangerousfor()
	 * @generated
	 * @ordered
	 */
	protected EList<Passanger> dangerousfor;

	/**
	 * The cached value of the '{@link #getLand() <em>Land</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLand()
	 * @generated
	 * @ordered
	 */
	protected Land land;

	/**
	 * The cached value of the '{@link #getTravelOn() <em>Travel On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTravelOn()
	 * @generated
	 * @ordered
	 */
	protected Vehichle travelOn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassangerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OnlabPackage.Literals.PASSANGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Land)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OnlabPackage.PASSANGER__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Land newTarget) {
		Land oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OnlabPackage.PASSANGER__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Passanger> getDangerousfor() {
		if (dangerousfor == null) {
			dangerousfor = new EObjectResolvingEList<Passanger>(Passanger.class, this, OnlabPackage.PASSANGER__DANGEROUSFOR);
		}
		return dangerousfor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land getLand() {
		if (land != null && land.eIsProxy()) {
			InternalEObject oldLand = (InternalEObject)land;
			land = (Land)eResolveProxy(oldLand);
			if (land != oldLand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OnlabPackage.PASSANGER__LAND, oldLand, land));
			}
		}
		return land;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land basicGetLand() {
		return land;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLand(Land newLand, NotificationChain msgs) {
		Land oldLand = land;
		land = newLand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OnlabPackage.PASSANGER__LAND, oldLand, newLand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLand(Land newLand) {
		if (newLand != land) {
			NotificationChain msgs = null;
			if (land != null)
				msgs = ((InternalEObject)land).eInverseRemove(this, OnlabPackage.LAND__PASSANGERS, Land.class, msgs);
			if (newLand != null)
				msgs = ((InternalEObject)newLand).eInverseAdd(this, OnlabPackage.LAND__PASSANGERS, Land.class, msgs);
			msgs = basicSetLand(newLand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OnlabPackage.PASSANGER__LAND, newLand, newLand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehichle getTravelOn() {
		if (travelOn != null && travelOn.eIsProxy()) {
			InternalEObject oldTravelOn = (InternalEObject)travelOn;
			travelOn = (Vehichle)eResolveProxy(oldTravelOn);
			if (travelOn != oldTravelOn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OnlabPackage.PASSANGER__TRAVEL_ON, oldTravelOn, travelOn));
			}
		}
		return travelOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehichle basicGetTravelOn() {
		return travelOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTravelOn(Vehichle newTravelOn) {
		Vehichle oldTravelOn = travelOn;
		travelOn = newTravelOn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OnlabPackage.PASSANGER__TRAVEL_ON, oldTravelOn, travelOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OnlabPackage.PASSANGER__LAND:
				if (land != null)
					msgs = ((InternalEObject)land).eInverseRemove(this, OnlabPackage.LAND__PASSANGERS, Land.class, msgs);
				return basicSetLand((Land)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OnlabPackage.PASSANGER__LAND:
				return basicSetLand(null, msgs);
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
			case OnlabPackage.PASSANGER__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case OnlabPackage.PASSANGER__DANGEROUSFOR:
				return getDangerousfor();
			case OnlabPackage.PASSANGER__LAND:
				if (resolve) return getLand();
				return basicGetLand();
			case OnlabPackage.PASSANGER__TRAVEL_ON:
				if (resolve) return getTravelOn();
				return basicGetTravelOn();
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
			case OnlabPackage.PASSANGER__TARGET:
				setTarget((Land)newValue);
				return;
			case OnlabPackage.PASSANGER__DANGEROUSFOR:
				getDangerousfor().clear();
				getDangerousfor().addAll((Collection<? extends Passanger>)newValue);
				return;
			case OnlabPackage.PASSANGER__LAND:
				setLand((Land)newValue);
				return;
			case OnlabPackage.PASSANGER__TRAVEL_ON:
				setTravelOn((Vehichle)newValue);
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
			case OnlabPackage.PASSANGER__TARGET:
				setTarget((Land)null);
				return;
			case OnlabPackage.PASSANGER__DANGEROUSFOR:
				getDangerousfor().clear();
				return;
			case OnlabPackage.PASSANGER__LAND:
				setLand((Land)null);
				return;
			case OnlabPackage.PASSANGER__TRAVEL_ON:
				setTravelOn((Vehichle)null);
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
			case OnlabPackage.PASSANGER__TARGET:
				return target != null;
			case OnlabPackage.PASSANGER__DANGEROUSFOR:
				return dangerousfor != null && !dangerousfor.isEmpty();
			case OnlabPackage.PASSANGER__LAND:
				return land != null;
			case OnlabPackage.PASSANGER__TRAVEL_ON:
				return travelOn != null;
		}
		return super.eIsSet(featureID);
	}

} //PassangerImpl
