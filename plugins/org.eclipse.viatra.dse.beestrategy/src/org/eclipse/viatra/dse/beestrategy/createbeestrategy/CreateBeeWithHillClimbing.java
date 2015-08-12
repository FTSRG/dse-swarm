package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.beestrategy.Patch;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.StupidBee;
import org.eclipse.viatra.dse.beestrategy.StupidBee.BeeType;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.IState.TraversalStateType;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.ObjectiveComparatorHelper;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore;

public class CreateBeeWithHillClimbing extends WorkerBeeStrategy{
	  enum HillClimbingStrategyState {
	        TRY_AND_SAVE,
	        COMPARE_AND_STEP
	    }

	    private DesignSpaceManager dsm;

	    private double percentOfOpenedStates = 0;
	    private boolean interrupted;
	    private HillClimbingStrategyState state = HillClimbingStrategyState.TRY_AND_SAVE;

	    private int triedTransitions = 0;
	    private Fitness bestFitness = null;
	    private Random rnd = new Random();

	    private ObjectiveComparatorHelper objectiveComparatorHelper;

	    private ISolutionStore solutionStore;

	    private Logger logger = Logger.getLogger(getClass());

	    private FilterOptions filterOptions;

	    private ThreadContext context;

		private Integer patchSize;

		
		@Override
		public void setSearchData(SearchData sd){
			this.searchData = sd;
			radius = sd.getRadiusSize();
			patchSize = radius;
		}
		
		
		public CreateBeeWithHillClimbing(BeeStrategy3 bs){
			super(bs);
		}
//
//	    public CreateBeeWithHillClimbing() {
//	        this(1.001);
//	    }
//
//	    public CreateBeeWithHillClimbing(double percentOfOpenedStates) {
//	        this.percentOfOpenedStates = percentOfOpenedStates;
//	        filterOptions = new FilterOptions().nothingIfCut().untraversedOnly();
//	    }

	    public void init(ThreadContext context) {
	        this.context = context;
	        dsm = context.getDesignSpaceManager();
	        objectiveComparatorHelper = context.getObjectiveComparatorHelper();
	        solutionStore = context.getGlobalContext().getSolutionStore();
	        if (!solutionStore.isStrategyDependent()) {
	            throw new DSEException("This strategy needs a strategy dependent solution store.");
	        }
	    }

	   

	    public void newStateIsProcessed(boolean isAlreadyTraversed, Fitness fitness, boolean constraintsNotSatisfied) {

	        if (dsm.getTrajectoryInfo().getDepthFromRoot() == 0) {
	            bestFitness = fitness;
	            logger.debug("Fitness of the root state: " + fitness);
	            return;
	        }
	        
	        if (state == HillClimbingStrategyState.TRY_AND_SAVE) {
	            if (!constraintsNotSatisfied) {
	                logger.debug("Fitness of last transformation: " + fitness);
	                objectiveComparatorHelper.addTrajectoryFitness(new TrajectoryFitness(dsm.getTrajectoryInfo().getLastTransition(), fitness));
	            } else {
	                logger.debug("Global constraints are unsatisfied.");
	            }
	            dsm.undoLastTransformation();
	        }

	    }

	    public void interrupted() {
	        interrupted = true;
	        
	    }

		@Override
		public void initStrategy(ThreadContext context) {
			 this.context = context;
			if (patchSize == null)
				patchSize = 1;
			this.dsm = context.getDesignSpaceManager();
			logger.debug("Initied");

			
		}

		

		
		

		
//		@Override
//		public Patch createRandomBee() {
//			while (dsm.getTrajectoryFromRoot().size() != 0) {
//				dsm.undoLastTransformation();
//			}
//			TrajectoryInfo ti = dsm.getTrajectoryInfo().clone();
//			while (patchSize > 0) {
//				ITransition nextTran = selectNextTransition(true);
//				while (nextTran == null && dsm.getTrajectoryFromRoot().size() >= 0) {
//					dsm.undoLastTransformation();
//					nextTran = selectNextTransition(true);
//					ti.stepBack();
//				}
//				if (nextTran == null && dsm.getTrajectoryFromRoot().size() == 0) return null;
//				
//				dsm.fireActivation(nextTran);
//				if (this.isAlreadyFoundInThisStrategy(dsm.getCurrentState()))
//					dsm.undoLastTransformation();
//				
//				patchSize--;
//			}
//			Patch p = new Patch();
//			if (ti.getTransitionTrajectory().size() != 0)
//				p.initPatch(ti, context);
//			p.setBestfitness(context.calculateFitness());
//			p.initPatch(context.getDesignSpaceManager().getTrajectoryInfo(), context);
//			this.patch = p;
//			return p;
//		}
		
//		public boolean isAlreadyFoundInThisStrategy(IState iState){
//			if(this.alreadyFoundStates==null){
//				alreadyFoundStates = new HashSet<IState>();
//				alreadyFoundStates.add(iState);
//				return false;
//			}
//			 return alreadyFoundStates.add(iState);
//			
//		}
		
//		@Override
//		public StupidBee createNeighbourBee() {
//			boolean start = true;
//			Integer deepness = 0;
//			TrajectoryInfo actualState = patch.getPatch().clone();
//			// this.setThreadContextTo(patch.getPatch());
//
//			// step patchsize many steps
//			for (int i = 0; i < patchSize; i++) {
//				ITransition nextTran = this.selectNextTransition(true);
//				while (nextTran == null && deepness >= 0) {
//					dsm.undoLastTransformation();
//					actualState.stepBack();
//					deepness--;
//					nextTran = this.selectNextTransition(false);
//				}
//				if (deepness == 0 && start == false) {
//					return null;
//				}
//				start = false;
//				context.getDesignSpaceManager().fireActivation(nextTran);
//				patchSize--;
//				deepness++;
//				actualState.addStep(nextTran);
//			}
//			return generateStupidBee(actualState);
//		}
		
//		private synchronized StupidBee generateStupidBee(TrajectoryInfo actualState) {
//			StupidBee sb = new StupidBee();
//			sb.init(actualState, BeeType.Neighbour, context.calculateFitness());
//			TrajectoryFitness tf = new TrajectoryFitness(actualState, context.getLastFitness());
//			sb.setTrajectoryFitness(tf);
//			// patch.getBeeList().add(sb);
//			// this.numberOfActiveBees++;
//			// TODO szinkronizálni!!!!!!!!!!
//			this.patch.getBeeList().add(sb);
//			this.bs.increasenumberOfActiveBees();
//			this.sb = sb;
//			// System.out.println("hali");
//			//TODO
//			//System.out.println(sb.getActualState().getCurrentState().getId());
//			this.interruptStrategy();
//			return sb;
//
//		}



		@Override
		public void setStopCond(Object stopcond) {
			this.patchSize = (Integer) stopcond;
			
		}


	


		@Override
		ITransition selectNextTransition() {
			 while (!interrupted && patchSize>0) {
		            if (dsm.getTransitionsFromCurrentState().size() <= 0) {
		                if (dsm.getCurrentState().getTraversalState() == TraversalStateType.GOAL) {
		                    solutionStore.newSolution(context);
		                }
		                logger.debug("Reached end of design space.");
		                return null;
		            }

		            Collection<? extends ITransition> transitions = dsm.getTransitionsFromCurrentState(filterOptions);

		            if (transitions.size() <= 0) {
		                logger.debug("No more transitions to try.");
		                state = HillClimbingStrategyState.COMPARE_AND_STEP;
		            }

		            if (state == HillClimbingStrategyState.TRY_AND_SAVE) {
		                ITransition transition;
		                if (percentOfOpenedStates >= 1) {
		                    transition = transitions.iterator().next();
		                } else {
		                    if (percentOfOpenedStates <= triedTransitions / dsm.getTransitionsFromCurrentState().size()) {
		                        state = HillClimbingStrategyState.COMPARE_AND_STEP;
		                        continue;
		                    } else {
		                        int index = rnd.nextInt(transitions.size());
		                        Iterator<? extends ITransition> iterator = transitions.iterator();
		                        while (iterator.hasNext() && index != 0) {
		                            index--;
		                            iterator.next();
		                        }
		                        transition = iterator.next();
		                    }
		                    triedTransitions++;
		                }
		                logger.debug("Trying " + transition.getId());
		                return transition;
		            } else {
		                logger.debug("Comparing fitnesses.");

		                TrajectoryFitness bestTrajectoryFitness = objectiveComparatorHelper.getRandomBest();
		                objectiveComparatorHelper.clearTrajectoryFitnesses();
		                
		                int compare = objectiveComparatorHelper.compare(bestFitness, bestTrajectoryFitness.fitness);
		                
		                if (compare >= 0) {
		                    context.calculateFitness();
		                    solutionStore.newSolution(context);
		                    logger.debug(dsm.getTrajectoryInfo().toString());
		                    return null;
		                }
		                else {
		                    bestFitness = bestTrajectoryFitness.fitness;
		                }

		                triedTransitions = 0;
		                state = HillClimbingStrategyState.TRY_AND_SAVE;

		                ITransition bestTransition = bestTrajectoryFitness.trajectory[0];
		                logger.debug("Best transition: " + bestTransition.getId() + " with fitness " + bestFitness);
		                dsm.fireActivation(bestTransition);
		                patchSize--;
		            }

		        }

		        return null;
		}

		@Override
		public void setInitialState(SearchData sd) {
			// TODO Auto-generated method stub
			
		}

}
