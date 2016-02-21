package org.eclipse.viatra.dse.combineStrategies.ministrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.TrajectoryFitnessTupel;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;

public class BFSMiniStrategy implements IMiniStrategy {
	
	protected boolean isResultFound  = false;
	protected ThreadContext context;
	protected DesignSpaceManager dsm;
	protected StrategyCombiner bs;
	protected SearchData searchData;
	protected ArrayList<TrajectoryFitnessTupel> actuallyFoundStates;
	protected ArrayList<TrajectoryFitnessTupel> actuallySearchedStates;
	protected HashMap<TrajectoryInfo, TrajectoryFitnessTupel> foundStates;
	protected IStopCondition stopCondition;
	protected TrajectoryInfo startTrajectory;
	private boolean interrupted;
	private HashSet<IState> statesInTrajectory;

	@Override
	public void initStrategy(ThreadContext context) {
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		this.stopCondition = searchData.stopCond;
		this.startTrajectory = searchData.getParentTrajectory();
	}

	@Override
	public void explore() {
		
		
		getAllStatesFromHere();
			
		while(this.stopCondition.isStopConditionReached()){
			for (int i=0; i<actuallySearchedStates.size(); i++){
				this.goBackToRoot();
				this.goToTrajectory(actuallySearchedStates.get(i).getTi());
				this.getAllStatesFromHere();
				
			}
			for (int i=0; i<actuallyFoundStates.size(); i++){
				if(!this.foundStates.containsKey(actuallyFoundStates.get(i).getTi())){
					this.foundStates.put(actuallyFoundStates.get(i).getTi(), actuallyFoundStates.get(i));
				}
			}
			
		}
		
	}
	

	private boolean goBackToRoot(){
		while(dsm.getTrajectoryFromRoot().size()!=0){
			dsm.undoLastTransformation();
		}
		return true;
	}
	
	private void goToTrajectory(TrajectoryInfo trajectoryInfo){
		List<ITransition> trajectoryList = trajectoryInfo.getFullTransitionTrajectory();
		Iterator<ITransition> it = trajectoryList.iterator();
		while(it.hasNext()){
			dsm.fireActivation(it.next());
		}
	}

	private void getAllStatesFromHere(){
		this.actuallyFoundStates = new ArrayList<TrajectoryFitnessTupel>();
		Collection<? extends ITransition> newStates = context.getDesignSpaceManager().getTransitionsFromCurrentState();
		if(newStates ==null) return;
		for (ITransition iTransition : newStates) {
			dsm.fireActivation(iTransition);
			this.stopCondition.newFireTransitionHappend((dsm.getCurrentState()));
			if (this.foundStates.containsKey(dsm.getTrajectoryInfo())){
				TrajectoryFitnessTupel newTupel = new TrajectoryFitnessTupel(dsm.getTrajectoryInfo(), context.calculateFitness());
				this.actuallyFoundStates.add(newTupel);
				this.foundStates.put(dsm.getTrajectoryInfo(), newTupel);
			}
			dsm.undoLastTransformation();
			this.stopCondition.stepBackHappend(dsm.getCurrentState());
		}	
	}
	@Override
	public void interruptStrategy() {
		this.interrupted = true;

	}

	@Override
	public void setMainStrategy(IStrategy beeStrategy) {
		this.bs = (StrategyCombiner) beeStrategy;

	}

	@Override
	public void setStatesInTrajectory(HashSet<IState> states) {
		this.statesInTrajectory = states;

	}

	@Override
	public void setSearchData(SearchData sd) {
		this.searchData = sd;

	}

	@Override
	public SearchData returnResult() {
		if (isResultFound==false){
			return null;
		}
		return null;
	}

	@Override
	public IMiniStrategy createMiniStrategy(StrategyCombiner bs) {

		return new CreateBeeWithDFS(bs);
	}

	@Override
	public HashSet<IState> getStatesInTrajectory() {
			return statesInTrajectory;
	
	}
	
	//nothing found set everything null;

}
