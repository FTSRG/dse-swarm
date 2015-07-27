/**
 */
package onlab;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Danger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link onlab.Danger#getGuard <em>Guard</em>}</li>
 *   <li>{@link onlab.Danger#getDangerousToEachOther <em>Dangerous To Each Other</em>}</li>
 * </ul>
 *
 * @see onlab.OnlabPackage#getDanger()
 * @model
 * @generated
 */
public interface Danger extends EObject {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' reference list.
	 * The list contents are of type {@link onlab.Passanger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' reference list.
	 * @see onlab.OnlabPackage#getDanger_Guard()
	 * @model required="true"
	 * @generated
	 */
	EList<Passanger> getGuard();

	/**
	 * Returns the value of the '<em><b>Dangerous To Each Other</b></em>' reference list.
	 * The list contents are of type {@link onlab.Passanger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dangerous To Each Other</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dangerous To Each Other</em>' reference list.
	 * @see onlab.OnlabPackage#getDanger_DangerousToEachOther()
	 * @model lower="2" upper="2"
	 * @generated
	 */
	EList<Passanger> getDangerousToEachOther();

} // Danger
