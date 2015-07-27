/**
 */
package onlab.impl;

import java.util.Collection;

import onlab.Danger;
import onlab.Land;
import onlab.OnlabPackage;
import onlab.PassTheRiver;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pass The River</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link onlab.impl.PassTheRiverImpl#getLands <em>Lands</em>}</li>
 *   <li>{@link onlab.impl.PassTheRiverImpl#getDanger <em>Danger</em>}</li>
 *   <li>{@link onlab.impl.PassTheRiverImpl#getVehichles <em>Vehichles</em>}</li>
 *   <li>{@link onlab.impl.PassTheRiverImpl#getPassangers <em>Passangers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PassTheRiverImpl extends MinimalEObjectImpl.Container implements PassTheRiver {
	/**
	 * The cached value of the '{@link #getLands() <em>Lands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLands()
	 * @generated
	 * @ordered
	 */
	protected EList<Land> lands;

	/**
	 * The cached value of the '{@link #getDanger() <em>Danger</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDanger()
	 * @generated
	 * @ordered
	 */
	protected EList<Danger> danger;

	/**
	 * The cached value of the '{@link #getVehichles() <em>Vehichles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehichles()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehichle> vehichles;

	/**
	 * The cached value of the '{@link #getPassangers() <em>Passangers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassangers()
	 * @generated
	 * @ordered
	 */
	protected EList<Passanger> passangers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassTheRiverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OnlabPackage.Literals.PASS_THE_RIVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Land> getLands() {
		if (lands == null) {
			lands = new EObjectContainmentEList<Land>(Land.class, this, OnlabPackage.PASS_THE_RIVER__LANDS);
		}
		return lands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Danger> getDanger() {
		if (danger == null) {
			danger = new EObjectContainmentEList<Danger>(Danger.class, this, OnlabPackage.PASS_THE_RIVER__DANGER);
		}
		return danger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehichle> getVehichles() {
		if (vehichles == null) {
			vehichles = new EObjectContainmentEList<Vehichle>(Vehichle.class, this, OnlabPackage.PASS_THE_RIVER__VEHICHLES);
		}
		return vehichles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Passanger> getPassangers() {
		if (passangers == null) {
			passangers = new EObjectContainmentEList<Passanger>(Passanger.class, this, OnlabPackage.PASS_THE_RIVER__PASSANGERS);
		}
		return passangers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OnlabPackage.PASS_THE_RIVER__LANDS:
				return ((InternalEList<?>)getLands()).basicRemove(otherEnd, msgs);
			case OnlabPackage.PASS_THE_RIVER__DANGER:
				return ((InternalEList<?>)getDanger()).basicRemove(otherEnd, msgs);
			case OnlabPackage.PASS_THE_RIVER__VEHICHLES:
				return ((InternalEList<?>)getVehichles()).basicRemove(otherEnd, msgs);
			case OnlabPackage.PASS_THE_RIVER__PASSANGERS:
				return ((InternalEList<?>)getPassangers()).basicRemove(otherEnd, msgs);
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
			case OnlabPackage.PASS_THE_RIVER__LANDS:
				return getLands();
			case OnlabPackage.PASS_THE_RIVER__DANGER:
				return getDanger();
			case OnlabPackage.PASS_THE_RIVER__VEHICHLES:
				return getVehichles();
			case OnlabPackage.PASS_THE_RIVER__PASSANGERS:
				return getPassangers();
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
			case OnlabPackage.PASS_THE_RIVER__LANDS:
				getLands().clear();
				getLands().addAll((Collection<? extends Land>)newValue);
				return;
			case OnlabPackage.PASS_THE_RIVER__DANGER:
				getDanger().clear();
				getDanger().addAll((Collection<? extends Danger>)newValue);
				return;
			case OnlabPackage.PASS_THE_RIVER__VEHICHLES:
				getVehichles().clear();
				getVehichles().addAll((Collection<? extends Vehichle>)newValue);
				return;
			case OnlabPackage.PASS_THE_RIVER__PASSANGERS:
				getPassangers().clear();
				getPassangers().addAll((Collection<? extends Passanger>)newValue);
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
			case OnlabPackage.PASS_THE_RIVER__LANDS:
				getLands().clear();
				return;
			case OnlabPackage.PASS_THE_RIVER__DANGER:
				getDanger().clear();
				return;
			case OnlabPackage.PASS_THE_RIVER__VEHICHLES:
				getVehichles().clear();
				return;
			case OnlabPackage.PASS_THE_RIVER__PASSANGERS:
				getPassangers().clear();
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
			case OnlabPackage.PASS_THE_RIVER__LANDS:
				return lands != null && !lands.isEmpty();
			case OnlabPackage.PASS_THE_RIVER__DANGER:
				return danger != null && !danger.isEmpty();
			case OnlabPackage.PASS_THE_RIVER__VEHICHLES:
				return vehichles != null && !vehichles.isEmpty();
			case OnlabPackage.PASS_THE_RIVER__PASSANGERS:
				return passangers != null && !passangers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PassTheRiverImpl
