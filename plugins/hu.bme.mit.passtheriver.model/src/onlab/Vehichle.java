/**
 */
package onlab;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehichle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link onlab.Vehichle#getSeats <em>Seats</em>}</li>
 *   <li>{@link onlab.Vehichle#getFreeseats <em>Freeseats</em>}</li>
 *   <li>{@link onlab.Vehichle#getLands <em>Lands</em>}</li>
 *   <li>{@link onlab.Vehichle#getActualLand <em>Actual Land</em>}</li>
 * </ul>
 *
 * @see onlab.OnlabPackage#getVehichle()
 * @model
 * @generated
 */
public interface Vehichle extends onlab.Object {
	/**
	 * Returns the value of the '<em><b>Seats</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seats</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seats</em>' attribute.
	 * @see #setSeats(int)
	 * @see onlab.OnlabPackage#getVehichle_Seats()
	 * @model default="0" required="true" transient="true"
	 * @generated
	 */
	int getSeats();

	/**
	 * Sets the value of the '{@link onlab.Vehichle#getSeats <em>Seats</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seats</em>' attribute.
	 * @see #getSeats()
	 * @generated
	 */
	void setSeats(int value);

	/**
	 * Returns the value of the '<em><b>Freeseats</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Freeseats</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Freeseats</em>' attribute list.
	 * @see onlab.OnlabPackage#getVehichle_Freeseats()
	 * @model upper="2" transient="true" derived="true"
	 * @generated
	 */
	EList<Integer> getFreeseats();

	/**
	 * Returns the value of the '<em><b>Lands</b></em>' reference list.
	 * The list contents are of type {@link onlab.Land}.
	 * It is bidirectional and its opposite is '{@link onlab.Land#getVehichles <em>Vehichles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lands</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lands</em>' reference list.
	 * @see onlab.OnlabPackage#getVehichle_Lands()
	 * @see onlab.Land#getVehichles
	 * @model opposite="vehichles" lower="2" upper="2"
	 * @generated
	 */
	EList<Land> getLands();

	/**
	 * Returns the value of the '<em><b>Actual Land</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Land</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Land</em>' reference.
	 * @see #setActualLand(Land)
	 * @see onlab.OnlabPackage#getVehichle_ActualLand()
	 * @model required="true"
	 * @generated
	 */
	Land getActualLand();

	/**
	 * Sets the value of the '{@link onlab.Vehichle#getActualLand <em>Actual Land</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Land</em>' reference.
	 * @see #getActualLand()
	 * @generated
	 */
	void setActualLand(Land value);

} // Vehichle
