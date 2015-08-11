package program;

import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.dse.statecode.IStateCoderFactory;


	public class SerializerFactory implements IStateCoderFactory{

	    

		@Override
		public IStateCoder createStateCoder() {
			// TODO Auto-generated method stub
			return new Serializer();
		}

	}

