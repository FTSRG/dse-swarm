/**
 */
package ServerPark;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ServerPark.Integer#getValue <em>Value</em>}</li>
 *   <li>{@link ServerPark.Integer#getCommunication <em>Communication</em>}</li>
 * </ul>
 * </p>
 *
 * @see ServerPark.ServerParkPackage#getInteger()
 * @model
 * @generated
 */
public interface Integer extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see ServerPark.ServerParkPackage#getInteger_Value()
	 * @model required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link ServerPark.Integer#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Communication</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication</em>' reference.
	 * @see #setCommunication(Machines)
	 * @see ServerPark.ServerParkPackage#getInteger_Communication()
	 * @model required="true"
	 * @generated
	 */
	Machines getCommunication();

	/**
	 * Sets the value of the '{@link ServerPark.Integer#getCommunication <em>Communication</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication</em>' reference.
	 * @see #getCommunication()
	 * @generated
	 */
	void setCommunication(Machines value);

} // Integer
