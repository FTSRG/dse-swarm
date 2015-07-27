/**
 */
package onlab.util;

import onlab.Danger;
import onlab.Driver;
import onlab.Land;
import onlab.OnlabPackage;
import onlab.PassTheRiver;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see onlab.OnlabPackage
 * @generated
 */
public class OnlabSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OnlabPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnlabSwitch() {
		if (modelPackage == null) {
			modelPackage = OnlabPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OnlabPackage.OBJECT: {
				onlab.Object object = (onlab.Object)theEObject;
				T result = caseObject(object);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OnlabPackage.PASS_THE_RIVER: {
				PassTheRiver passTheRiver = (PassTheRiver)theEObject;
				T result = casePassTheRiver(passTheRiver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OnlabPackage.VEHICHLE: {
				Vehichle vehichle = (Vehichle)theEObject;
				T result = caseVehichle(vehichle);
				if (result == null) result = caseObject(vehichle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OnlabPackage.PASSANGER: {
				Passanger passanger = (Passanger)theEObject;
				T result = casePassanger(passanger);
				if (result == null) result = caseObject(passanger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OnlabPackage.LAND: {
				Land land = (Land)theEObject;
				T result = caseLand(land);
				if (result == null) result = caseObject(land);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OnlabPackage.DRIVER: {
				Driver driver = (Driver)theEObject;
				T result = caseDriver(driver);
				if (result == null) result = casePassanger(driver);
				if (result == null) result = caseObject(driver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OnlabPackage.DANGER: {
				Danger danger = (Danger)theEObject;
				T result = caseDanger(danger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObject(onlab.Object object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pass The River</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pass The River</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassTheRiver(PassTheRiver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vehichle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehichle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVehichle(Vehichle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Passanger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Passanger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassanger(Passanger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Land</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Land</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLand(Land object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDriver(Driver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Danger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Danger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDanger(Danger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OnlabSwitch
