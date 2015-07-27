/**
 */
package onlab.impl;

import onlab.Danger;
import onlab.Driver;
import onlab.Land;
import onlab.OnlabFactory;
import onlab.OnlabPackage;
import onlab.PassTheRiver;
import onlab.Passanger;
import onlab.Vehichle;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OnlabFactoryImpl extends EFactoryImpl implements OnlabFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OnlabFactory init() {
		try {
			OnlabFactory theOnlabFactory = (OnlabFactory)EPackage.Registry.INSTANCE.getEFactory(OnlabPackage.eNS_URI);
			if (theOnlabFactory != null) {
				return theOnlabFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OnlabFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnlabFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OnlabPackage.OBJECT: return createObject();
			case OnlabPackage.PASS_THE_RIVER: return createPassTheRiver();
			case OnlabPackage.VEHICHLE: return createVehichle();
			case OnlabPackage.PASSANGER: return createPassanger();
			case OnlabPackage.LAND: return createLand();
			case OnlabPackage.DRIVER: return createDriver();
			case OnlabPackage.DANGER: return createDanger();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public onlab.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassTheRiver createPassTheRiver() {
		PassTheRiverImpl passTheRiver = new PassTheRiverImpl();
		return passTheRiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehichle createVehichle() {
		VehichleImpl vehichle = new VehichleImpl();
		return vehichle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Passanger createPassanger() {
		PassangerImpl passanger = new PassangerImpl();
		return passanger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Land createLand() {
		LandImpl land = new LandImpl();
		return land;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver createDriver() {
		DriverImpl driver = new DriverImpl();
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Danger createDanger() {
		DangerImpl danger = new DangerImpl();
		return danger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnlabPackage getOnlabPackage() {
		return (OnlabPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OnlabPackage getPackage() {
		return OnlabPackage.eINSTANCE;
	}

} //OnlabFactoryImpl
