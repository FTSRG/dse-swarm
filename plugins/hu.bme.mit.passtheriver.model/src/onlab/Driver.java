/**
 */
package onlab;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link onlab.Driver#getDrivingLicences <em>Driving Licences</em>}</li>
 * </ul>
 *
 * @see onlab.OnlabPackage#getDriver()
 * @model
 * @generated
 */
public interface Driver extends Passanger {
	/**
	 * Returns the value of the '<em><b>Driving Licences</b></em>' reference list.
	 * The list contents are of type {@link onlab.Vehichle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driving Licences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driving Licences</em>' reference list.
	 * @see onlab.OnlabPackage#getDriver_DrivingLicences()
	 * @model required="true"
	 * @generated
	 */
	EList<Vehichle> getDrivingLicences();

} // Driver
