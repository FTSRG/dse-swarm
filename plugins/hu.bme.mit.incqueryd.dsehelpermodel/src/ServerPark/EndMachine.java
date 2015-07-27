/**
 */
package ServerPark;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ServerPark.EndMachine#getCPUNum <em>CPU Num</em>}</li>
 *   <li>{@link ServerPark.EndMachine#getMemorySize <em>Memory Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see ServerPark.ServerParkPackage#getEndMachine()
 * @model
 * @generated
 */
public interface EndMachine extends EObject {
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
	 * @see ServerPark.ServerParkPackage#getEndMachine_CPUNum()
	 * @model required="true"
	 * @generated
	 */
	int getCPUNum();

	/**
	 * Sets the value of the '{@link ServerPark.EndMachine#getCPUNum <em>CPU Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CPU Num</em>' attribute.
	 * @see #getCPUNum()
	 * @generated
	 */
	void setCPUNum(int value);

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
	 * @see ServerPark.ServerParkPackage#getEndMachine_MemorySize()
	 * @model required="true"
	 * @generated
	 */
	int getMemorySize();

	/**
	 * Sets the value of the '{@link ServerPark.EndMachine#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(int value);

} // EndMachine
