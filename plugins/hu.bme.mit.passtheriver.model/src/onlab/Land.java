/**
 */
package onlab;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Land</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link onlab.Land#getNeighbours <em>Neighbours</em>}</li>
 *   <li>{@link onlab.Land#getVehichles <em>Vehichles</em>}</li>
 *   <li>{@link onlab.Land#getPassangers <em>Passangers</em>}</li>
 * </ul>
 *
 * @see onlab.OnlabPackage#getLand()
 * @model
 * @generated
 */
public interface Land extends onlab.Object {
	/**
	 * Returns the value of the '<em><b>Neighbours</b></em>' reference list.
	 * The list contents are of type {@link onlab.Land}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighbours</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighbours</em>' reference list.
	 * @see onlab.OnlabPackage#getLand_Neighbours()
	 * @model required="true" derived="true"
	 * @generated
	 */
	EList<Land> getNeighbours();

	/**
	 * Returns the value of the '<em><b>Vehichles</b></em>' reference list.
	 * The list contents are of type {@link onlab.Vehichle}.
	 * It is bidirectional and its opposite is '{@link onlab.Vehichle#getLands <em>Lands</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehichles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehichles</em>' reference list.
	 * @see onlab.OnlabPackage#getLand_Vehichles()
	 * @see onlab.Vehichle#getLands
	 * @model opposite="lands" required="true"
	 * @generated
	 */
	EList<Vehichle> getVehichles();

	/**
	 * Returns the value of the '<em><b>Passangers</b></em>' reference list.
	 * The list contents are of type {@link onlab.Passanger}.
	 * It is bidirectional and its opposite is '{@link onlab.Passanger#getLand <em>Land</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passangers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passangers</em>' reference list.
	 * @see onlab.OnlabPackage#getLand_Passangers()
	 * @see onlab.Passanger#getLand
	 * @model opposite="land"
	 * @generated
	 */
	EList<Passanger> getPassangers();

} // Land
