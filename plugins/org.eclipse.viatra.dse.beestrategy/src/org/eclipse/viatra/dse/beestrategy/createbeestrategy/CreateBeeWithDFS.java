package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.BeeStrategy;
import org.eclipse.viatra.dse.beestrategy.Patch;
import org.eclipse.viatra.dse.beestrategy.StupidBee;
import org.eclipse.viatra.dse.beestrategy.StupidBee.BeeType;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class CreateBeeWithDFS implements ICreateBee {

	private Integer patchSize;
	private ThreadContext context;
	private boolean neighbour;
	private BeeStrategy bs;
	private DesignSpaceManager dsm;
	FilterOptions fo = new FilterOptions().nothingIfCut().nothingIfGoal().untraversedOnly();
	private Patch patch;

	/**
	 * It will set ThreadContext and PatchSize (default == 1) if you would like
	 * to change patchsize you have to call setpatchsize
	 */
	@Override
	public void initStrategy(ThreadContext context) {
		this.context = context;
		if (patchSize == null)
			patchSize = 1;
		this.dsm = context.getDesignSpaceManager();

	}
	
	@Override 
	public void setPatch(Patch patch){
		this.patch = patch;
	}

	@Override
	public void explore() {
		if (this.neighbour == false) {
			createRandomBee();
		}

		createNeighbourBee();
	}

	@Override
	public void interruptStrategy() {
		// TODO Auto-generated method stub

	}

	// createRandomBee-be mehetne talan maskepp implementalva
	// ExplorerThread explorerThread =
	// context.getGlobalContext().tryStartNewThread(context,
	// context.getModelRoot(), true,
	// Strategies.createDFSStrategy(patchSize2));
	// ArrayList<String> reachedStates = new ArrayList<String>();

	// x1: System.out.println("decision: " + dsm.getCurrentState());

	// x2:
	/*
	 * if (!reachedStates.contains(dsm.getCurrentState().getId().toString() ) ||
	 * dsm.getCurrentState().getId() == bs.getStartstate().getId()) {
	 * patchSize--; ti.addStep(nextTran);
	 * reachedStates.add(dsm.getCurrentState().getId().toString());
	 * System.out.println("reached state: " + dsm.getCurrentState()); } else {
	 * dsm.undoLastTransformation(); patchSize--; }
	 */

	// x3:
	// bs.getPatches().add(p);
	// bs.setNumberOfActiveBees(NumberOfActiveBees++);

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
			// x1
			dsm.fireActivation(nextTran);
			patchSize--;
			// x2
		}
		Patch p = new Patch();
		if (ti.getTransitionTrajectory().size() != 0)
			p.setPatch(ti, context);
		p.setBestfitness(context.calculateFitness());
		// x3
		p.setBestfitness(context.calculateFitness());
		p.setPatch(context.getDesignSpaceManager().getTrajectoryInfo(), context);
		return p;
	}

	private ITransition selectNextTransition() {
		// if there is a state from here, which were not processed
		Integer actTranNum = dsm.getTransitionsFromCurrentState(fo).size();
		if (actTranNum > 0) {
			Collection<? extends ITransition> transitions = dsm.getTransitionsFromCurrentState(fo);
			int index = new Random().nextInt(transitions.size());
			Iterator<? extends ITransition> iterator = transitions.iterator();
			while (iterator.hasNext() && index != 0) {
				index--;
				iterator.next();
			}
			// give back the selected transition
			ITransition transition = iterator.next();
			return transition;
		}

		return null;
	}

	@Override
	public StupidBee createNeighbourBee() {
		 boolean start = true;
		Integer deepness = 0;
		TrajectoryInfo actualState = patch.getPatch().clone();
		this.setThreadContextTo(patch.getPatch());

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
			deepness++;
			actualState.addStep(nextTran);
		}
		StupidBee sb = new StupidBee();
		sb.init(actualState, BeeType.Neighbour, context.calculateFitness());
		TrajectoryFitness tf = new TrajectoryFitness(actualState, context.getLastFitness());
		sb.setTrajectoryFitness(tf);
//		patch.getBeeList().add(sb);
//		this.numberOfActiveBees++;
		return sb;
	}

	private void setThreadContextTo(TrajectoryInfo patch) {
		DesignSpaceManager dsm = context.getDesignSpaceManager();
		while (dsm.getTrajectoryFromRoot().size() != 0) {
			dsm.undoLastTransformation();
		}
		List<ITransition> transitions = patch.getFullTransitionTrajectory();
		for (ITransition iTransition : transitions) {
			dsm.fireActivation(iTransition);
		}
		
	}

	// --------------- getters and setters --------------------

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

}
