/**
 */
package onlab.impl;

import java.util.Collection;

import onlab.Driver;
import onlab.OnlabPackage;
import onlab.Vehichle;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link onlab.impl.DriverImpl#getDrivingLicences <em>Driving Licences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DriverImpl extends PassangerImpl implements Driver {
	/**
	 * The cached value of the '{@link #getDrivingLicences() <em>Driving Licences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivingLicences()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehichle> drivingLicences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DriverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OnlabPackage.Literals.DRIVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehichle> getDrivingLicences() {
		if (drivingLicences == null) {
			drivingLicences = new EObjectResolvingEList<Vehichle>(Vehichle.class, this, OnlabPackage.DRIVER__DRIVING_LICENCES);
		}
		return drivingLicences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OnlabPackage.DRIVER__DRIVING_LICENCES:
				return getDrivingLicences();
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
			case OnlabPackage.DRIVER__DRIVING_LICENCES:
				getDrivingLicences().clear();
				getDrivingLicences().addAll((Collection<? extends Vehichle>)newValue);
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
			case OnlabPackage.DRIVER__DRIVING_LICENCES:
				getDrivingLicences().clear();
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
			case OnlabPackage.DRIVER__DRIVING_LICENCES:
				return drivingLicences != null && !drivingLicences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DriverImpl
