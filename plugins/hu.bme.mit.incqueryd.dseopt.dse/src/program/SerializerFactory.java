package program;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.dse.statecode.IStateSerializer;
import org.eclipse.viatra.dse.statecode.IStateSerializerFactory;

import ServerPark.UsedMachines;


	public class SerializerFactory implements IStateSerializerFactory{

	    

		@Override
		public IStateSerializer createStateSerializer(Notifier modelRoot)
				throws UnsupportedMetaModel {
			return new Serializer((UsedMachines)modelRoot);
		}

	}

