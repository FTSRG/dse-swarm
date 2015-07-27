/**
 */
package ServerPark;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ServerPark.Process#getId <em>Id</em>}</li>
 *   <li>{@link ServerPark.Process#getSize <em>Size</em>}</li>
 *   <li>{@link ServerPark.Process#getBrotherProcesses <em>Brother Processes</em>}</li>
 *   <li>{@link ServerPark.Process#getEndMachine <em>End Machine</em>}</li>
 *   <li>{@link ServerPark.Process#getEndStateIp <em>End State Ip</em>}</li>
 * </ul>
 * </p>
 *
 * @see ServerPark.ServerParkPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see ServerPark.ServerParkPackage#getProcess_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ServerPark.Process#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see ServerPark.ServerParkPackage#getProcess_Size()
	 * @model required="true"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link ServerPark.Process#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Brother Processes</b></em>' containment reference list.
	 * The list contents are of type {@link ServerPark.Process}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Brother Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brother Processes</em>' containment reference list.
	 * @see ServerPark.ServerParkPackage#getProcess_BrotherProcesses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Process> getBrotherProcesses();

	/**
	 * Returns the value of the '<em><b>End Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Machine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Machine</em>' containment reference.
	 * @see #setEndMachine(EndMachine)
	 * @see ServerPark.ServerParkPackage#getProcess_EndMachine()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EndMachine getEndMachine();

	/**
	 * Sets the value of the '{@link ServerPark.Process#getEndMachine <em>End Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Machine</em>' containment reference.
	 * @see #getEndMachine()
	 * @generated
	 */
	void setEndMachine(EndMachine value);

	/**
	 * Returns the value of the '<em><b>End State Ip</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End State Ip</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End State Ip</em>' reference.
	 * @see #setEndStateIp(Machines)
	 * @see ServerPark.ServerParkPackage#getProcess_EndStateIp()
	 * @model required="true"
	 * @generated
	 */
	Machines getEndStateIp();

	/**
	 * Sets the value of the '{@link ServerPark.Process#getEndStateIp <em>End State Ip</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End State Ip</em>' reference.
	 * @see #getEndStateIp()
	 * @generated
	 */
	void setEndStateIp(Machines value);

} // Process
