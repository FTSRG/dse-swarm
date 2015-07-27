/**
 */
package onlab.impl;

import java.util.Collection;

import onlab.Land;
import onlab.OnlabPackage;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Land</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link onlab.impl.LandImpl#getNeighbours <em>Neighbours</em>}</li>
 *   <li>{@link onlab.impl.LandImpl#getVehichles <em>Vehichles</em>}</li>
 *   <li>{@link onlab.impl.LandImpl#getPassangers <em>Passangers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LandImpl extends ObjectImpl implements Land {
	/**
	 * The cached value of the '{@link #getNeighbours() <em>Neighbours</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighbours()
	 * @generated
	 * @ordered
	 */
	protected EList<Land> neighbours;

	/**
	 * The cached value of the '{@link #getVehichles() <em>Vehichles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehichles()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehichle> vehichles;

	/**
	 * The cached value of the '{@link #getPassangers() <em>Passangers</em>}' reference list.
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
	protected LandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OnlabPackage.Literals.LAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Land> getNeighbours() {
		if (neighbours == null) {
			neighbours = new EObjectResolvingEList<Land>(Land.class, this, OnlabPackage.LAND__NEIGHBOURS);
		}
		return neighbours;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehichle> getVehichles() {
		if (vehichles == null) {
			vehichles = new EObjectWithInverseResolvingEList.ManyInverse<Vehichle>(Vehichle.class, this, OnlabPackage.LAND__VEHICHLES, OnlabPackage.VEHICHLE__LANDS);
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
			passangers = new EObjectWithInverseResolvingEList<Passanger>(Passanger.class, this, OnlabPackage.LAND__PASSANGERS, OnlabPackage.PASSANGER__LAND);
		}
		return passangers;
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
			case OnlabPackage.LAND__VEHICHLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVehichles()).basicAdd(otherEnd, msgs);
			case OnlabPackage.LAND__PASSANGERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPassangers()).basicAdd(otherEnd, msgs);
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
			case OnlabPackage.LAND__VEHICHLES:
				return ((InternalEList<?>)getVehichles()).basicRemove(otherEnd, msgs);
			case OnlabPackage.LAND__PASSANGERS:
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
			case OnlabPackage.LAND__NEIGHBOURS:
				return getNeighbours();
			case OnlabPackage.LAND__VEHICHLES:
				return getVehichles();
			case OnlabPackage.LAND__PASSANGERS:
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
			case OnlabPackage.LAND__NEIGHBOURS:
				getNeighbours().clear();
				getNeighbours().addAll((Collection<? extends Land>)newValue);
				return;
			case OnlabPackage.LAND__VEHICHLES:
				getVehichles().clear();
				getVehichles().addAll((Collection<? extends Vehichle>)newValue);
				return;
			case OnlabPackage.LAND__PASSANGERS:
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
			case OnlabPackage.LAND__NEIGHBOURS:
				getNeighbours().clear();
				return;
			case OnlabPackage.LAND__VEHICHLES:
				getVehichles().clear();
				return;
			case OnlabPackage.LAND__PASSANGERS:
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
			case OnlabPackage.LAND__NEIGHBOURS:
				return neighbours != null && !neighbours.isEmpty();
			case OnlabPackage.LAND__VEHICHLES:
				return vehichles != null && !vehichles.isEmpty();
			case OnlabPackage.LAND__PASSANGERS:
				return passangers != null && !passangers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LandImpl
