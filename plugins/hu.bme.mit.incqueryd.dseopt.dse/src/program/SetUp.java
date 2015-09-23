package program;

import java.util.Collection;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.Strategies;
import org.eclipse.viatra.dse.api.strategy.impl.FixedPriorityStrategy;
import org.eclipse.viatra.dse.api.strategy.impl.HillClimbingStrategy;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.DFSWithHillClimbingMiniStrategy;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.RandomHillClimbingMiniStrategy;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.SimulatedAnnealingMiniStrategy;
import org.eclipse.viatra.dse.objectives.ActivationFitnessProcessor;
import org.eclipse.viatra.dse.objectives.IObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesHardObjective;
import org.eclipse.viatra.dse.objectives.impl.WeightedQueriesSoftObjective;
import org.eclipse.viatra.dse.solutionstore.SimpleSolutionStore;
import org.eclipse.viatra.dse.strategySelectors.IStrategySelector;

import ServerPark.Machines;
import ServerPark.ServerParkFactory;
import ServerPark.UsedMachines;
import hu.bme.mit.incqueryd.dseopt.queries.ChangeProcessLocationMatch;
import hu.bme.mit.incqueryd.dseopt.queries.StartServerMatch;
import hu.bme.mit.incqueryd.dseopt.queries.util.FreeMemoryNegativQuerySpecification;
import hu.bme.mit.incqueryd.dseopt.queries.util.IsProcessAtRightPlaceQuerySpecification;
import hu.bme.mit.incqueryd.dseopt.queries.util.NotEndStateQuerySpecification;
import hu.bme.mit.incqueryd.dseopt.queries.util.NotStoppedOrUsedMachinesQuerySpecification;
import hu.bme.mit.incqueryd.dseopt.queries.util.RunningmachineQuerySpecification;
import hu.bme.mit.incqueryd.dseopt.queries.util.StoppedAndUsedMachinesQuerySpecification;
import simulators.BeeStrategySimulator;
import startproblem.StartProblem;
import transformations.ChangeProcessLocation;
import transformations.StartMachine;
import transformations.StopMachine;

public class SetUp {
	 protected DesignSpaceExplorer dse;
	 protected UsedMachines model;
	 protected ServerParkFactory factory;
	 //dseTransformationRule
	 protected DSETransformationRule<?, ?> changeProcessLocation;
	 protected DSETransformationRule<?, ?> startMachine;
	 protected DSETransformationRule<?, ?> stopMachine;
	 private IStrategySelector selector;
	 FixedPriorityStrategy fps;
	 HillClimbingStrategy hcs;
	 StrategyCombiner bs;
	 
	 private final class CostOfStartComputer implements ActivationFitnessProcessor {
	       
	        @Override
			public double process(IPatternMatch match) {
	        	 StartServerMatch m = (StartServerMatch) match;//TODO típusos match
	             int value = m.getMachine().getSerialNumber();
				return value;
			}
	    }
	 private final class CostOfChangeProcessLocation implements ActivationFitnessProcessor {

		@Override
		public double process(IPatternMatch match) {
			ChangeProcessLocationMatch m = (ChangeProcessLocationMatch) match;
			Machines m1 = m.getMachine1();
			Machines m2 = m.getMachine2();
			int place=0;
			for(int i=0; i<m.getServerpark().getAllMachines().size(); i++){
				if (m.getServerpark().getAllMachines().get(i).getIP().equals(m2.getIP())){
					return Double.parseDouble(String.valueOf(m1.getDataTransitionOverhead().get(i).getValue()));
				}
			}
			return place;
			
		}
		 
	 }
	
	 
	
	public SetUp() {
		// TODO Auto-generated constructor stub
	}
	public void setUpProject(String source) throws IncQueryException{
		 factory = ServerParkFactory.eINSTANCE;
		// model = factory.createUsedMachines();
		 dse = new DesignSpaceExplorer();
		
		 model = new StartProblem(source).getModel();
		System.out.println( model.getAllMachines().get(0).getIP());
		 dse.setInitialModel(model);
		

		 this.changeProcessLocation = new ChangeProcessLocation().begin();
		 this.startMachine = new StartMachine().begin();
		 this.stopMachine = new StopMachine().begin();
		
		
		 //set constraints
		 dse.addObjective(new ModelQueriesHardObjective("MyHardObjective")
		 .withConstraint(NotEndStateQuerySpecification.instance()));
		 
		 IObjective standingAtTarget = new WeightedQueriesSoftObjective()
				 .withConstraint(RunningmachineQuerySpecification.instance(), 1)
				 .withConstraint(IsProcessAtRightPlaceQuerySpecification.instance(), 3);
		 dse.addObjective(standingAtTarget);
		 //		 
//		 CostOfChangeProcessLocation costOfChangeProcessLocation = new CostOfChangeProcessLocation();
//		 CostOfStartComputer costOfStartComputer = new CostOfStartComputer();
		 
//		 dse.addObjective(new TrajectoryCostSoftObjective()
//		 .withActivationCost(changeProcessLocation,  costOfChangeProcessLocation)
//		 .withActivationCost(startMachine, costOfStartComputer)
//      //   .withRuleCost(startMachine, 4)
//         .withRuleCost(stopMachine, 3)
//     //    .withRuleCost(changeProcessLocation, 1)
//         .withComparator(Comparators.LOWER_IS_BETTER)
//         .withLevel(1)
//		 );
		 /*	.withComparator(new Comparator(){

				@Override
				public int compare(Object arg0, Object arg1) {
					UsedMachines now = (UsedMachines) arg0;
					UsedMachines end = (UsedMachines) arg1;
					Serializer ser = new Serializer(now);
					String nowser = (String)ser.serializeContainmentTree();
					ser= new Serializer(end);
					String endser =(String) ser.serializeContainmentTree();
					return endser.compareTo(nowser);
				}
		 		
		 	}));*/

		 dse.setStateCoderFactory(new SerializerFactory());
		 dse.addTransformationRule(this.startMachine);
		 dse.addTransformationRule(this.stopMachine);
		 dse.addTransformationRule(this.changeProcessLocation);
		 
		 dse.addGlobalConstraint(new ModelQueriesGlobalConstraint()
		   .withConstraint(FreeMemoryNegativQuerySpecification.instance())
		    .withConstraint(NotStoppedOrUsedMachinesQuerySpecification.instance())
		    .withConstraint(StoppedAndUsedMachinesQuerySpecification.instance())
		    );
		
	
		 dse.setMaxNumberOfThreads(2);
		 dse.setSolutionStore(new SimpleSolutionStore(1));
		 
		// hcs = new HillClimbingStrategy();
				
		
		 fps = new FixedPriorityStrategy()
         .withRulePriority(this.changeProcessLocation, 4)
         .withRulePriority(this.startMachine, 4)
         .withRulePriority(this.stopMachine, 4).withDepthLimit(5);
		 
		bs = new StrategyCombiner();
		BeeStrategySimulator bss = new BeeStrategySimulator(bs);
	//	SimulatedAnnealingMiniStrategy ministrategy2 = new SimulatedAnnealingMiniStrategy(bs);
		bss.init(new CreateBeeWithHillClimbing(bs), new  CreateBeeWithDFS(bs));
		 
	}
	public void startProject(){
		//dse.startExploration(Strategies.createDFSStrategy(300));
		dse.startExploration(bs);
		//dse.startExploration(fps);
//		 dse.setSolutionStore(new StrategyDependentSolutionStore())
//         dse.startExploration(new HillClimbingStrategy());
//	
	}
	
	public void writeOutProject() throws IncQueryException{
		 Collection<Solution> solutions = dse.getSolutions();
		 System.out.println(solutions.size());
	}
	
}

