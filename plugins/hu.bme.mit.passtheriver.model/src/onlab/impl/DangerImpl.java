/**
 */
package onlab.impl;

import java.util.Collection;

import onlab.Danger;
import onlab.OnlabPackage;
import onlab.Passanger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Danger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link onlab.impl.DangerImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link onlab.impl.DangerImpl#getDangerousToEachOther <em>Dangerous To Each Other</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DangerImpl extends MinimalEObjectImpl.Container implements Danger {
	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected EList<Passanger> guard;

	/**
	 * The cached value of the '{@link #getDangerousToEachOther() <em>Dangerous To Each Other</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDangerousToEachOther()
	 * @generated
	 * @ordered
	 */
	protected EList<Passanger> dangerousToEachOther;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DangerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OnlabPackage.Literals.DANGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Passanger> getGuard() {
		if (guard == null) {
			guard = new EObjectResolvingEList<Passanger>(Passanger.class, this, OnlabPackage.DANGER__GUARD);
		}
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Passanger> getDangerousToEachOther() {
		if (dangerousToEachOther == null) {
			dangerousToEachOther = new EObjectResolvingEList<Passanger>(Passanger.class, this, OnlabPackage.DANGER__DANGEROUS_TO_EACH_OTHER);
		}
		return dangerousToEachOther;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OnlabPackage.DANGER__GUARD:
				return getGuard();
			case OnlabPackage.DANGER__DANGEROUS_TO_EACH_OTHER:
				return getDangerousToEachOther();
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
			case OnlabPackage.DANGER__GUARD:
				getGuard().clear();
				getGuard().addAll((Collection<? extends Passanger>)newValue);
				return;
			case OnlabPackage.DANGER__DANGEROUS_TO_EACH_OTHER:
				getDangerousToEachOther().clear();
				getDangerousToEachOther().addAll((Collection<? extends Passanger>)newValue);
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
			case OnlabPackage.DANGER__GUARD:
				getGuard().clear();
				return;
			case OnlabPackage.DANGER__DANGEROUS_TO_EACH_OTHER:
				getDangerousToEachOther().clear();
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
			case OnlabPackage.DANGER__GUARD:
				return guard != null && !guard.isEmpty();
			case OnlabPackage.DANGER__DANGEROUS_TO_EACH_OTHER:
				return dangerousToEachOther != null && !dangerousToEachOther.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DangerImpl
