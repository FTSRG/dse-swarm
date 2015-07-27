/**
 */
package onlab;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see onlab.OnlabFactory
 * @model kind="package"
 * @generated
 */
public interface OnlabPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "onlab";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "hu.bme.mdsd.onlab";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hu.bme.mdsd.onlab";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OnlabPackage eINSTANCE = onlab.impl.OnlabPackageImpl.init();

	/**
	 * The meta object id for the '{@link onlab.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.ObjectImpl
	 * @see onlab.impl.OnlabPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link onlab.impl.PassTheRiverImpl <em>Pass The River</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.PassTheRiverImpl
	 * @see onlab.impl.OnlabPackageImpl#getPassTheRiver()
	 * @generated
	 */
	int PASS_THE_RIVER = 1;

	/**
	 * The feature id for the '<em><b>Lands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASS_THE_RIVER__LANDS = 0;

	/**
	 * The feature id for the '<em><b>Danger</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASS_THE_RIVER__DANGER = 1;

	/**
	 * The feature id for the '<em><b>Vehichles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASS_THE_RIVER__VEHICHLES = 2;

	/**
	 * The feature id for the '<em><b>Passangers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASS_THE_RIVER__PASSANGERS = 3;

	/**
	 * The number of structural features of the '<em>Pass The River</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASS_THE_RIVER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Pass The River</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASS_THE_RIVER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link onlab.impl.VehichleImpl <em>Vehichle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.VehichleImpl
	 * @see onlab.impl.OnlabPackageImpl#getVehichle()
	 * @generated
	 */
	int VEHICHLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Seats</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE__SEATS = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Freeseats</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE__FREESEATS = OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lands</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE__LANDS = OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actual Land</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE__ACTUAL_LAND = OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Vehichle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Vehichle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICHLE_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link onlab.impl.PassangerImpl <em>Passanger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.PassangerImpl
	 * @see onlab.impl.OnlabPackageImpl#getPassanger()
	 * @generated
	 */
	int PASSANGER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER__TARGET = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dangerousfor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER__DANGEROUSFOR = OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Land</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER__LAND = OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Travel On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER__TRAVEL_ON = OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Passanger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Passanger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSANGER_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link onlab.impl.LandImpl <em>Land</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.LandImpl
	 * @see onlab.impl.OnlabPackageImpl#getLand()
	 * @generated
	 */
	int LAND = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Neighbours</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND__NEIGHBOURS = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vehichles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND__VEHICHLES = OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Passangers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND__PASSANGERS = OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Land</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Land</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link onlab.impl.DriverImpl <em>Driver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.DriverImpl
	 * @see onlab.impl.OnlabPackageImpl#getDriver()
	 * @generated
	 */
	int DRIVER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__NAME = PASSANGER__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__TARGET = PASSANGER__TARGET;

	/**
	 * The feature id for the '<em><b>Dangerousfor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__DANGEROUSFOR = PASSANGER__DANGEROUSFOR;

	/**
	 * The feature id for the '<em><b>Land</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__LAND = PASSANGER__LAND;

	/**
	 * The feature id for the '<em><b>Travel On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__TRAVEL_ON = PASSANGER__TRAVEL_ON;

	/**
	 * The feature id for the '<em><b>Driving Licences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__DRIVING_LICENCES = PASSANGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_FEATURE_COUNT = PASSANGER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_OPERATION_COUNT = PASSANGER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link onlab.impl.DangerImpl <em>Danger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see onlab.impl.DangerImpl
	 * @see onlab.impl.OnlabPackageImpl#getDanger()
	 * @generated
	 */
	int DANGER = 6;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__GUARD = 0;

	/**
	 * The feature id for the '<em><b>Dangerous To Each Other</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER__DANGEROUS_TO_EACH_OTHER = 1;

	/**
	 * The number of structural features of the '<em>Danger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Danger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DANGER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link onlab.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see onlab.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the attribute '{@link onlab.Object#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see onlab.Object#getName()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_Name();

	/**
	 * Returns the meta object for class '{@link onlab.PassTheRiver <em>Pass The River</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pass The River</em>'.
	 * @see onlab.PassTheRiver
	 * @generated
	 */
	EClass getPassTheRiver();

	/**
	 * Returns the meta object for the containment reference list '{@link onlab.PassTheRiver#getLands <em>Lands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lands</em>'.
	 * @see onlab.PassTheRiver#getLands()
	 * @see #getPassTheRiver()
	 * @generated
	 */
	EReference getPassTheRiver_Lands();

	/**
	 * Returns the meta object for the containment reference list '{@link onlab.PassTheRiver#getDanger <em>Danger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Danger</em>'.
	 * @see onlab.PassTheRiver#getDanger()
	 * @see #getPassTheRiver()
	 * @generated
	 */
	EReference getPassTheRiver_Danger();

	/**
	 * Returns the meta object for the containment reference list '{@link onlab.PassTheRiver#getVehichles <em>Vehichles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehichles</em>'.
	 * @see onlab.PassTheRiver#getVehichles()
	 * @see #getPassTheRiver()
	 * @generated
	 */
	EReference getPassTheRiver_Vehichles();

	/**
	 * Returns the meta object for the containment reference list '{@link onlab.PassTheRiver#getPassangers <em>Passangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Passangers</em>'.
	 * @see onlab.PassTheRiver#getPassangers()
	 * @see #getPassTheRiver()
	 * @generated
	 */
	EReference getPassTheRiver_Passangers();

	/**
	 * Returns the meta object for class '{@link onlab.Vehichle <em>Vehichle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehichle</em>'.
	 * @see onlab.Vehichle
	 * @generated
	 */
	EClass getVehichle();

	/**
	 * Returns the meta object for the attribute '{@link onlab.Vehichle#getSeats <em>Seats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seats</em>'.
	 * @see onlab.Vehichle#getSeats()
	 * @see #getVehichle()
	 * @generated
	 */
	EAttribute getVehichle_Seats();

	/**
	 * Returns the meta object for the attribute list '{@link onlab.Vehichle#getFreeseats <em>Freeseats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Freeseats</em>'.
	 * @see onlab.Vehichle#getFreeseats()
	 * @see #getVehichle()
	 * @generated
	 */
	EAttribute getVehichle_Freeseats();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Vehichle#getLands <em>Lands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lands</em>'.
	 * @see onlab.Vehichle#getLands()
	 * @see #getVehichle()
	 * @generated
	 */
	EReference getVehichle_Lands();

	/**
	 * Returns the meta object for the reference '{@link onlab.Vehichle#getActualLand <em>Actual Land</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual Land</em>'.
	 * @see onlab.Vehichle#getActualLand()
	 * @see #getVehichle()
	 * @generated
	 */
	EReference getVehichle_ActualLand();

	/**
	 * Returns the meta object for class '{@link onlab.Passanger <em>Passanger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passanger</em>'.
	 * @see onlab.Passanger
	 * @generated
	 */
	EClass getPassanger();

	/**
	 * Returns the meta object for the reference '{@link onlab.Passanger#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see onlab.Passanger#getTarget()
	 * @see #getPassanger()
	 * @generated
	 */
	EReference getPassanger_Target();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Passanger#getDangerousfor <em>Dangerousfor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dangerousfor</em>'.
	 * @see onlab.Passanger#getDangerousfor()
	 * @see #getPassanger()
	 * @generated
	 */
	EReference getPassanger_Dangerousfor();

	/**
	 * Returns the meta object for the reference '{@link onlab.Passanger#getLand <em>Land</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Land</em>'.
	 * @see onlab.Passanger#getLand()
	 * @see #getPassanger()
	 * @generated
	 */
	EReference getPassanger_Land();

	/**
	 * Returns the meta object for the reference '{@link onlab.Passanger#getTravelOn <em>Travel On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Travel On</em>'.
	 * @see onlab.Passanger#getTravelOn()
	 * @see #getPassanger()
	 * @generated
	 */
	EReference getPassanger_TravelOn();

	/**
	 * Returns the meta object for class '{@link onlab.Land <em>Land</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Land</em>'.
	 * @see onlab.Land
	 * @generated
	 */
	EClass getLand();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Land#getNeighbours <em>Neighbours</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Neighbours</em>'.
	 * @see onlab.Land#getNeighbours()
	 * @see #getLand()
	 * @generated
	 */
	EReference getLand_Neighbours();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Land#getVehichles <em>Vehichles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Vehichles</em>'.
	 * @see onlab.Land#getVehichles()
	 * @see #getLand()
	 * @generated
	 */
	EReference getLand_Vehichles();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Land#getPassangers <em>Passangers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Passangers</em>'.
	 * @see onlab.Land#getPassangers()
	 * @see #getLand()
	 * @generated
	 */
	EReference getLand_Passangers();

	/**
	 * Returns the meta object for class '{@link onlab.Driver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driver</em>'.
	 * @see onlab.Driver
	 * @generated
	 */
	EClass getDriver();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Driver#getDrivingLicences <em>Driving Licences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Driving Licences</em>'.
	 * @see onlab.Driver#getDrivingLicences()
	 * @see #getDriver()
	 * @generated
	 */
	EReference getDriver_DrivingLicences();

	/**
	 * Returns the meta object for class '{@link onlab.Danger <em>Danger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Danger</em>'.
	 * @see onlab.Danger
	 * @generated
	 */
	EClass getDanger();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Danger#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Guard</em>'.
	 * @see onlab.Danger#getGuard()
	 * @see #getDanger()
	 * @generated
	 */
	EReference getDanger_Guard();

	/**
	 * Returns the meta object for the reference list '{@link onlab.Danger#getDangerousToEachOther <em>Dangerous To Each Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dangerous To Each Other</em>'.
	 * @see onlab.Danger#getDangerousToEachOther()
	 * @see #getDanger()
	 * @generated
	 */
	EReference getDanger_DangerousToEachOther();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OnlabFactory getOnlabFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link onlab.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.ObjectImpl
		 * @see onlab.impl.OnlabPackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__NAME = eINSTANCE.getObject_Name();

		/**
		 * The meta object literal for the '{@link onlab.impl.PassTheRiverImpl <em>Pass The River</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.PassTheRiverImpl
		 * @see onlab.impl.OnlabPackageImpl#getPassTheRiver()
		 * @generated
		 */
		EClass PASS_THE_RIVER = eINSTANCE.getPassTheRiver();

		/**
		 * The meta object literal for the '<em><b>Lands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASS_THE_RIVER__LANDS = eINSTANCE.getPassTheRiver_Lands();

		/**
		 * The meta object literal for the '<em><b>Danger</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASS_THE_RIVER__DANGER = eINSTANCE.getPassTheRiver_Danger();

		/**
		 * The meta object literal for the '<em><b>Vehichles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASS_THE_RIVER__VEHICHLES = eINSTANCE.getPassTheRiver_Vehichles();

		/**
		 * The meta object literal for the '<em><b>Passangers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASS_THE_RIVER__PASSANGERS = eINSTANCE.getPassTheRiver_Passangers();

		/**
		 * The meta object literal for the '{@link onlab.impl.VehichleImpl <em>Vehichle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.VehichleImpl
		 * @see onlab.impl.OnlabPackageImpl#getVehichle()
		 * @generated
		 */
		EClass VEHICHLE = eINSTANCE.getVehichle();

		/**
		 * The meta object literal for the '<em><b>Seats</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICHLE__SEATS = eINSTANCE.getVehichle_Seats();

		/**
		 * The meta object literal for the '<em><b>Freeseats</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICHLE__FREESEATS = eINSTANCE.getVehichle_Freeseats();

		/**
		 * The meta object literal for the '<em><b>Lands</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICHLE__LANDS = eINSTANCE.getVehichle_Lands();

		/**
		 * The meta object literal for the '<em><b>Actual Land</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VEHICHLE__ACTUAL_LAND = eINSTANCE.getVehichle_ActualLand();

		/**
		 * The meta object literal for the '{@link onlab.impl.PassangerImpl <em>Passanger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.PassangerImpl
		 * @see onlab.impl.OnlabPackageImpl#getPassanger()
		 * @generated
		 */
		EClass PASSANGER = eINSTANCE.getPassanger();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSANGER__TARGET = eINSTANCE.getPassanger_Target();

		/**
		 * The meta object literal for the '<em><b>Dangerousfor</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSANGER__DANGEROUSFOR = eINSTANCE.getPassanger_Dangerousfor();

		/**
		 * The meta object literal for the '<em><b>Land</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSANGER__LAND = eINSTANCE.getPassanger_Land();

		/**
		 * The meta object literal for the '<em><b>Travel On</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSANGER__TRAVEL_ON = eINSTANCE.getPassanger_TravelOn();

		/**
		 * The meta object literal for the '{@link onlab.impl.LandImpl <em>Land</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.LandImpl
		 * @see onlab.impl.OnlabPackageImpl#getLand()
		 * @generated
		 */
		EClass LAND = eINSTANCE.getLand();

		/**
		 * The meta object literal for the '<em><b>Neighbours</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAND__NEIGHBOURS = eINSTANCE.getLand_Neighbours();

		/**
		 * The meta object literal for the '<em><b>Vehichles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAND__VEHICHLES = eINSTANCE.getLand_Vehichles();

		/**
		 * The meta object literal for the '<em><b>Passangers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAND__PASSANGERS = eINSTANCE.getLand_Passangers();

		/**
		 * The meta object literal for the '{@link onlab.impl.DriverImpl <em>Driver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.DriverImpl
		 * @see onlab.impl.OnlabPackageImpl#getDriver()
		 * @generated
		 */
		EClass DRIVER = eINSTANCE.getDriver();

		/**
		 * The meta object literal for the '<em><b>Driving Licences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRIVER__DRIVING_LICENCES = eINSTANCE.getDriver_DrivingLicences();

		/**
		 * The meta object literal for the '{@link onlab.impl.DangerImpl <em>Danger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see onlab.impl.DangerImpl
		 * @see onlab.impl.OnlabPackageImpl#getDanger()
		 * @generated
		 */
		EClass DANGER = eINSTANCE.getDanger();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DANGER__GUARD = eINSTANCE.getDanger_Guard();

		/**
		 * The meta object literal for the '<em><b>Dangerous To Each Other</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DANGER__DANGEROUS_TO_EACH_OTHER = eINSTANCE.getDanger_DangerousToEachOther();

	}

} //OnlabPackage
