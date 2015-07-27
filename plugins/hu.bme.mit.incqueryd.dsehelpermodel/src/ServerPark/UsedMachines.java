/**
 */
package ServerPark;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Used Machines</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ServerPark.UsedMachines#getRunning <em>Running</em>}</li>
 *   <li>{@link ServerPark.UsedMachines#getStopped <em>Stopped</em>}</li>
 *   <li>{@link ServerPark.UsedMachines#getProcesses <em>Processes</em>}</li>
 *   <li>{@link ServerPark.UsedMachines#getNewAttribute <em>New Attribute</em>}</li>
 *   <li>{@link ServerPark.UsedMachines#getAllMachines <em>All Machines</em>}</li>
 * </ul>
 * </p>
 *
 * @see ServerPark.ServerParkPackage#getUsedMachines()
 * @model
 * @generated
 */
public interface UsedMachines extends EObject {
	/**
	 * Returns the value of the '<em><b>Running</b></em>' reference list.
	 * The list contents are of type {@link ServerPark.Machines}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Running</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Running</em>' reference list.
	 * @see ServerPark.ServerParkPackage#getUsedMachines_Running()
	 * @model
	 * @generated
	 */
	EList<Machines> getRunning();

	/**
	 * Returns the value of the '<em><b>Stopped</b></em>' reference list.
	 * The list contents are of type {@link ServerPark.Machines}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stopped</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stopped</em>' reference list.
	 * @see ServerPark.ServerParkPackage#getUsedMachines_Stopped()
	 * @model
	 * @generated
	 */
	EList<Machines> getStopped();

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link ServerPark.Process}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see ServerPark.ServerParkPackage#getUsedMachines_Processes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServerPark.Process> getProcesses();

	/**
	 * Returns the value of the '<em><b>New Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Attribute</em>' attribute.
	 * @see #setNewAttribute(String)
	 * @see ServerPark.ServerParkPackage#getUsedMachines_NewAttribute()
	 * @model
	 * @generated
	 */
	String getNewAttribute();

	/**
	 * Sets the value of the '{@link ServerPark.UsedMachines#getNewAttribute <em>New Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Attribute</em>' attribute.
	 * @see #getNewAttribute()
	 * @generated
	 */
	void setNewAttribute(String value);

	/**
	 * Returns the value of the '<em><b>All Machines</b></em>' containment reference list.
	 * The list contents are of type {@link ServerPark.Machines}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Machines</em>' containment reference list.
	 * @see ServerPark.ServerParkPackage#getUsedMachines_AllMachines()
	 * @model containment="true"
	 * @generated
	 */
	EList<Machines> getAllMachines();

} // UsedMachines
