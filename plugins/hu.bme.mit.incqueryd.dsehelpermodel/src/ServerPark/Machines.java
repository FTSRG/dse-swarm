/**
 */
package ServerPark;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machines</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ServerPark.Machines#getIP <em>IP</em>}</li>
 *   <li>{@link ServerPark.Machines#getUsedMemory <em>Used Memory</em>}</li>
 *   <li>{@link ServerPark.Machines#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link ServerPark.Machines#getDataTransitionOverhead <em>Data Transition Overhead</em>}</li>
 *   <li>{@link ServerPark.Machines#getCPUNum <em>CPU Num</em>}</li>
 *   <li>{@link ServerPark.Machines#getSerialNumber <em>Serial Number</em>}</li>
 *   <li>{@link ServerPark.Machines#getMachineProcesses <em>Machine Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @see ServerPark.ServerParkPackage#getMachines()
 * @model
 * @generated
 */
public interface Machines extends EObject {
	/**
	 * Returns the value of the '<em><b>IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IP</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IP</em>' attribute.
	 * @see #setIP(String)
	 * @see ServerPark.ServerParkPackage#getMachines_IP()
	 * @model required="true"
	 * @generated
	 */
	String getIP();

	/**
	 * Sets the value of the '{@link ServerPark.Machines#getIP <em>IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IP</em>' attribute.
	 * @see #getIP()
	 * @generated
	 */
	void setIP(String value);

	/**
	 * Returns the value of the '<em><b>Used Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Memory</em>' attribute.
	 * @see #setUsedMemory(int)
	 * @see ServerPark.ServerParkPackage#getMachines_UsedMemory()
	 * @model required="true"
	 * @generated
	 */
	int getUsedMemory();

	/**
	 * Sets the value of the '{@link ServerPark.Machines#getUsedMemory <em>Used Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Memory</em>' attribute.
	 * @see #getUsedMemory()
	 * @generated
	 */
	void setUsedMemory(int value);

	/**
	 * Returns the value of the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Size</em>' attribute.
	 * @see #setMemorySize(int)
	 * @see ServerPark.ServerParkPackage#getMachines_MemorySize()
	 * @model required="true"
	 * @generated
	 */
	int getMemorySize();

	/**
	 * Sets the value of the '{@link ServerPark.Machines#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(int value);

	/**
	 * Returns the value of the '<em><b>Data Transition Overhead</b></em>' containment reference list.
	 * The list contents are of type {@link ServerPark.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Transition Overhead</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Transition Overhead</em>' containment reference list.
	 * @see ServerPark.ServerParkPackage#getMachines_DataTransitionOverhead()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServerPark.Integer> getDataTransitionOverhead();

	/**
	 * Returns the value of the '<em><b>CPU Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CPU Num</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CPU Num</em>' attribute.
	 * @see #setCPUNum(int)
	 * @see ServerPark.ServerParkPackage#getMachines_CPUNum()
	 * @model required="true"
	 * @generated
	 */
	int getCPUNum();

	/**
	 * Sets the value of the '{@link ServerPark.Machines#getCPUNum <em>CPU Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CPU Num</em>' attribute.
	 * @see #getCPUNum()
	 * @generated
	 */
	void setCPUNum(int value);

	/**
	 * Returns the value of the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serial Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serial Number</em>' attribute.
	 * @see #setSerialNumber(int)
	 * @see ServerPark.ServerParkPackage#getMachines_SerialNumber()
	 * @model required="true"
	 * @generated
	 */
	int getSerialNumber();

	/**
	 * Sets the value of the '{@link ServerPark.Machines#getSerialNumber <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serial Number</em>' attribute.
	 * @see #getSerialNumber()
	 * @generated
	 */
	void setSerialNumber(int value);

	/**
	 * Returns the value of the '<em><b>Machine Processes</b></em>' reference list.
	 * The list contents are of type {@link ServerPark.Process}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Processes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Processes</em>' reference list.
	 * @see ServerPark.ServerParkPackage#getMachines_MachineProcesses()
	 * @model
	 * @generated
	 */
	EList<ServerPark.Process> getMachineProcesses();

} // Machines
