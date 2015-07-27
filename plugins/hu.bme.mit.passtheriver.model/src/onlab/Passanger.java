/**
 */
package onlab;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Passanger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link onlab.Passanger#getTarget <em>Target</em>}</li>
 *   <li>{@link onlab.Passanger#getDangerousfor <em>Dangerousfor</em>}</li>
 *   <li>{@link onlab.Passanger#getLand <em>Land</em>}</li>
 *   <li>{@link onlab.Passanger#getTravelOn <em>Travel On</em>}</li>
 * </ul>
 *
 * @see onlab.OnlabPackage#getPassanger()
 * @model
 * @generated
 */
public interface Passanger extends onlab.Object {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Land)
	 * @see onlab.OnlabPackage#getPassanger_Target()
	 * @model required="true"
	 * @generated
	 */
	Land getTarget();

	/**
	 * Sets the value of the '{@link onlab.Passanger#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Land value);

	/**
	 * Returns the value of the '<em><b>Dangerousfor</b></em>' reference list.
	 * The list contents are of type {@link onlab.Passanger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dangerousfor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dangerousfor</em>' reference list.
	 * @see onlab.OnlabPackage#getPassanger_Dangerousfor()
	 * @model
	 * @generated
	 */
	EList<Passanger> getDangerousfor();

	/**
	 * Returns the value of the '<em><b>Land</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link onlab.Land#getPassangers <em>Passangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Land</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Land</em>' reference.
	 * @see #setLand(Land)
	 * @see onlab.OnlabPackage#getPassanger_Land()
	 * @see onlab.Land#getPassangers
	 * @model opposite="passangers"
	 * @generated
	 */
	Land getLand();

	/**
	 * Sets the value of the '{@link onlab.Passanger#getLand <em>Land</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Land</em>' reference.
	 * @see #getLand()
	 * @generated
	 */
	void setLand(Land value);

	/**
	 * Returns the value of the '<em><b>Travel On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Travel On</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Travel On</em>' reference.
	 * @see #setTravelOn(Vehichle)
	 * @see onlab.OnlabPackage#getPassanger_TravelOn()
	 * @model
	 * @generated
	 */
	Vehichle getTravelOn();

	/**
	 * Sets the value of the '{@link onlab.Passanger#getTravelOn <em>Travel On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Travel On</em>' reference.
	 * @see #getTravelOn()
	 * @generated
	 */
	void setTravelOn(Vehichle value);

} // Passanger
