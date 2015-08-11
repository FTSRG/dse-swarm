package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.HashSet;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;
import org.eclipse.viatra.dse.beestrategy.Patch;
import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.StupidBee;
import org.eclipse.viatra.dse.beestrategy.StupidBee.BeeType;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public abstract class WorkerBeeStrategy implements ICreateBee {

	
	protected BeeStrategy3 bs;
	protected SearchData searchData;
	protected HashSet<IState> statesInTrajectory = new HashSet<IState>();
	
	protected ThreadContext context;
	protected DesignSpaceManager dsm;
	
	protected WorkerBeeStrategy(BeeStrategy3 bs, SearchData sd, HashSet<IState> states){
		this.bs = bs;
		this.searchData = sd;
		this.statesInTrajectory = states;
	}

	
	@Override
	public void setStatesInTrajectory(HashSet<IState> states){
		this.statesInTrajectory = states;
	}

	@Override
	public void initStrategy(ThreadContext context) {
		this.context = context;
		this.dsm = context.getDesignSpaceManager();

	}

	@Override
	public void explore() {
		if(this.searchData == null || this.searchData.getActualState() == null || this.searchData.getRadiusSize() == null || this.searchData.getRadiusSize()<=0){
			this.bs.decreasenumberOfActiveBees();
			return;
		}
		SearchData sd = createBee();
		if(sd==null){
			this.bs.decreasenumberOfActiveBees();
			return;
		};
		
	}

	private SearchData createBee() {
		boolean start = true;
		Integer deepness = 0;
		TrajectoryInfo actualState = searchData.getActualState().clone();
		Integer radius = searchData.getRadiusSize();
		// step patchsize many steps
		for (int i = 0; i <radius; i++) {
			ITransition nextTran = this.selectNextTransition();
			while (nextTran == null && deepness >= 0) {
				dsm.undoLastTransformation();
				//ha valahogy nem jól mûködik, akkor ezt és az addstep-et kell eltávolítani
				actualState.stepBack();
				deepness--;
				nextTran = this.selectNextTransition();
			}
			if (deepness == 0 && start == false) {
				return null;
			}
			start = false;
			context.getDesignSpaceManager().fireActivation(nextTran);
			deepness++;
			actualState.addStep(nextTran);
		}
		return generateStupidBee(actualState);
		
	}


	@Override
	public void interruptStrategy() {
		this.interrupted = true;

	}

	@Override
	public Patch createRandomBee() {
		while (dsm.getTrajectoryFromRoot().size() != 0) {
			dsm.undoLastTransformation();
		}
		TrajectoryInfo ti = dsm.getTrajectoryInfo().clone();
		while (patchSize > 0) {
			ITransition nextTran = selectNextTransition();
			while (nextTran == null && dsm.getTrajectoryFromRoot().size() >= 0) {
				dsm.undoLastTransformation();
				nextTran = selectNextTransition();
				ti.stepBack();
			}
			if (nextTran == null && dsm.getTrajectoryFromRoot().size() == 0)
				return null;
			dsm.fireActivation(nextTran);
			if (this.isAlreadyFoundInThisTrajectory(dsm.getCurrentState()))
				dsm.undoLastTransformation();
			patchSize--;
		}
		Patch p = new Patch();
		if (ti.getTransitionTrajectory().size() != 0)
			p.initPatch(ti, context);
		p.setBestfitness(context.calculateFitness());
		p.initPatch(context.getDesignSpaceManager().getTrajectoryInfo(), context);
		this.patch = p;
		return p;
	}

	private boolean isAlreadyFoundInThisTrajectory(IState currentState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StupidBee createNeighbourBee() {
		boolean start = true;
		Integer deepness = 0;
		TrajectoryInfo actualState = patch.getPatch().clone();
		// this.setThreadContextTo(patch.getPatch());

		// step patchsize many steps
		for (int i = 0; i < patchSize; i++) {
			ITransition nextTran = this.selectNextTransition();
			while (nextTran == null && deepness >= 0) {
				dsm.undoLastTransformation();
				actualState.stepBack();
				deepness--;
				nextTran = this.selectNextTransition();
			}
			if (deepness == 0 && start == false) {
				return null;
			}
			start = false;
			context.getDesignSpaceManager().fireActivation(nextTran);
			patchSize--;
			deepness++;
			actualState.addStep(nextTran);
		}
		return generateStupidBee(actualState);
	}

	abstract ITransition selectNextTransition();

	private StupidBee generateStupidBee(TrajectoryInfo actualState) {
		StupidBee sb = new StupidBee();
		sb.init(actualState, BeeType.Neighbour, context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(actualState, context.getLastFitness());
		sb.setTrajectoryFitness(tf);
		this.patch.getBeeList().add(sb);
		this.bs.increasenumberOfActiveBees();
		this.sb = sb;
		this.interruptStrategy();
		return sb;
	}

	public ThreadContext getContext() {
		return context;
	}

	public void setContext(ThreadContext context) {
		this.context = context;
	}

	@Override
	public void setStopCond(Object stopcond) {
		this.patchSize = (Integer) stopcond;

	}

	@Override
	public void setIfNeighbour(Boolean neighbour) {
		this.neighbour = neighbour;

	}

	@Override
	public String getID() {
		return this.id;
	}

	public void setBs(BeeStrategy3 beeStrategy) {
		this.bs = beeStrategy;

	}

	public Patch getPatch() {
		return patch;
	}

	public StupidBee getSb() {
		return sb;
	}

	public void setSb(StupidBee sb) {
		this.sb = sb;
	}

	@Override
	public void setMainStrategy(IStrategy beeStrategy) {
		this.bs = (BeeStrategy3) beeStrategy;

	}

}
