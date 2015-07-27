/**
 */
package onlab.impl;

import java.util.Collection;

import onlab.Land;
import onlab.OnlabPackage;
import onlab.Vehichle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehichle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link onlab.impl.VehichleImpl#getSeats <em>Seats</em>}</li>
 *   <li>{@link onlab.impl.VehichleImpl#getFreeseats <em>Freeseats</em>}</li>
 *   <li>{@link onlab.impl.VehichleImpl#getLands <em>Lands</em>}</li>
 *   <li>{@link onlab.impl.VehichleImpl#getActualLand <em>Actual Land</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VehichleImpl extends ObjectImpl implements Vehichle {
	/**
	 * The default value of the '{@link #getSeats() <em>Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeats()
	 * @generated
	 * @ordered
	 */
	protected static final int SEATS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeats() <em>Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeats()
	 * @generated
	 * @ordered
	 */
	protected int seats = SEATS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFreeseats() <em>Freeseats</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeseats()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> freeseats;

	/**
	 * The cached value of the '{@link #getLands() <em>Lands</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLands()
	 * @generated
	 * @ordered
	 */
	protected EList<Land> lands;

	/**
	 * The cached value of the '{@link #getActualLand() <em>Actual Land</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualLand()
	 * @generated
	 * @ordered
	 */
	protected Land actualLand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VehichleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OnlabPackage.Literals.VEHICHLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeats(int newSeats) {
		int oldSeats = seats;
		seats = newSeats;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OnlabPackage.VEHICHLE__SEATS, oldSeats, seats));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getFreeseats() {
		if (freeseats == null) {
			freeseats = new EDataTypeUniqueEList<Integer>(Integer.class, this, OnlabPackage.VEHICHLE__FREESEATS);
		}
		return freeseats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Land> getLands() {
		if (lands == null) {
			lands = new EObjectWithInverseResolvingEList.ManyInverse<Land>(Land.class, this, OnlabPackage.VEHICHLE__LANDS, OnlabPackage.LAND__VEHICHLES);
		}
		return lands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land getActualLand() {
		if (actualLand != null && actualLand.eIsProxy()) {
			InternalEObject oldActualLand = (InternalEObject)actualLand;
			actualLand = (Land)eResolveProxy(oldActualLand);
			if (actualLand != oldActualLand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OnlabPackage.VEHICHLE__ACTUAL_LAND, oldActualLand, actualLand));
			}
		}
		return actualLand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land basicGetActualLand() {
		return actualLand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualLand(Land newActualLand) {
		Land oldActualLand = actualLand;
		actualLand = newActualLand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OnlabPackage.VEHICHLE__ACTUAL_LAND, oldActualLand, actualLand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OnlabPackage.VEHICHLE__LANDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLands()).basicAdd(otherEnd, msgs);
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
			case OnlabPackage.VEHICHLE__LANDS:
				return ((InternalEList<?>)getLands()).basicRemove(otherEnd, msgs);
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
			case OnlabPackage.VEHICHLE__SEATS:
				return getSeats();
			case OnlabPackage.VEHICHLE__FREESEATS:
				return getFreeseats();
			case OnlabPackage.VEHICHLE__LANDS:
				return getLands();
			case OnlabPackage.VEHICHLE__ACTUAL_LAND:
				if (resolve) return getActualLand();
				return basicGetActualLand();
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
			case OnlabPackage.VEHICHLE__SEATS:
				setSeats((Integer)newValue);
				return;
			case OnlabPackage.VEHICHLE__FREESEATS:
				getFreeseats().clear();
				getFreeseats().addAll((Collection<? extends Integer>)newValue);
				return;
			case OnlabPackage.VEHICHLE__LANDS:
				getLands().clear();
				getLands().addAll((Collection<? extends Land>)newValue);
				return;
			case OnlabPackage.VEHICHLE__ACTUAL_LAND:
				setActualLand((Land)newValue);
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
			case OnlabPackage.VEHICHLE__SEATS:
				setSeats(SEATS_EDEFAULT);
				return;
			case OnlabPackage.VEHICHLE__FREESEATS:
				getFreeseats().clear();
				return;
			case OnlabPackage.VEHICHLE__LANDS:
				getLands().clear();
				return;
			case OnlabPackage.VEHICHLE__ACTUAL_LAND:
				setActualLand((Land)null);
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
			case OnlabPackage.VEHICHLE__SEATS:
				return seats != SEATS_EDEFAULT;
			case OnlabPackage.VEHICHLE__FREESEATS:
				return freeseats != null && !freeseats.isEmpty();
			case OnlabPackage.VEHICHLE__LANDS:
				return lands != null && !lands.isEmpty();
			case OnlabPackage.VEHICHLE__ACTUAL_LAND:
				return actualLand != null;
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
		result.append(" (seats: ");
		result.append(seats);
		result.append(", freeseats: ");
		result.append(freeseats);
		result.append(')');
		return result.toString();
	}

} //VehichleImpl
