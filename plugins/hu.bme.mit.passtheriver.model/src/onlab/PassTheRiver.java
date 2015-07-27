/**
 */
package onlab;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pass The River</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link onlab.PassTheRiver#getLands <em>Lands</em>}</li>
 *   <li>{@link onlab.PassTheRiver#getDanger <em>Danger</em>}</li>
 *   <li>{@link onlab.PassTheRiver#getVehichles <em>Vehichles</em>}</li>
 *   <li>{@link onlab.PassTheRiver#getPassangers <em>Passangers</em>}</li>
 * </ul>
 *
 * @see onlab.OnlabPackage#getPassTheRiver()
 * @model
 * @generated
 */
public interface PassTheRiver extends EObject {
	/**
	 * Returns the value of the '<em><b>Lands</b></em>' containment reference list.
	 * The list contents are of type {@link onlab.Land}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lands</em>' containment reference list.
	 * @see onlab.OnlabPackage#getPassTheRiver_Lands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Land> getLands();

	/**
	 * Returns the value of the '<em><b>Danger</b></em>' containment reference list.
	 * The list contents are of type {@link onlab.Danger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Danger</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Danger</em>' containment reference list.
	 * @see onlab.OnlabPackage#getPassTheRiver_Danger()
	 * @model containment="true"
	 * @generated
	 */
	EList<Danger> getDanger();

	/**
	 * Returns the value of the '<em><b>Vehichles</b></em>' containment reference list.
	 * The list contents are of type {@link onlab.Vehichle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehichles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehichles</em>' containment reference list.
	 * @see onlab.OnlabPackage#getPassTheRiver_Vehichles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Vehichle> getVehichles();

	/**
	 * Returns the value of the '<em><b>Passangers</b></em>' containment reference list.
	 * The list contents are of type {@link onlab.Passanger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passangers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passangers</em>' containment reference list.
	 * @see onlab.OnlabPackage#getPassTheRiver_Passangers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Passanger> getPassangers();

} // PassTheRiver
