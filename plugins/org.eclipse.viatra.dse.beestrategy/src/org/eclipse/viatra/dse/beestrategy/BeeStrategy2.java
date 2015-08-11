package org.eclipse.viatra.dse.beestrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.StupidBee.BeeType;
import org.eclipse.viatra.dse.designspace.api.IGetCertainTransitions.FilterOptions;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore.StopExecutionType;

public class BeeStrategy2 implements IStrategy {

	ThreadContext context;
	DesignSpaceManager dsm;
	Boolean interrupted = false;
	ISolutionStore solutionStore;
	StupidBee bestbee = null;
	ArrayList<Patch> nextgenerations;
	

	ArrayList<Patch> bestpatches;
	StopExecutionType set = StopExecutionType.CONTINUE;

	ArrayList<Patch> patches;
	Integer numberOfActiveBees = 0;
	Patch bestPatch;
	Integer id = 0;
	Integer numberOfFoundTransitions = 0;
	FilterOptions fo = new FilterOptions().nothingIfCut().nothingIfGoal().untraversedOnly();

	// setable variables
	Integer numberOfMaxBees = 1;

	Integer beesnum = 10;
	Integer sitesnum = 6;
	Integer eliteSitesNum = 3;
	Integer patchSize = 8;
	Integer eliteBeesNum = 2;
	Integer otherBeesNum = 1;
	private IState startstate;

	@Override
	public void initStrategy(ThreadContext context) {
		this.patches = new ArrayList<Patch>();
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		this.solutionStore = context.getGlobalContext().getSolutionStore();
		this.context = context;
		this.startstate = dsm.getCurrentState();
	}

	@Override
	public void explore() {
		this.exploreown();
	}

	private void exploreown() {
		// TODO a kezdeti állapot jó megoldás-e

		// ArrayList<StupidBee> NextGeneration;
		bestpatches = new ArrayList<Patch>();

		for (int i = 0; i < beesnum; i++) {
			Patch randomBee = this.createRandomBee(patchSize);
			issolution(randomBee);
			
		}
		getBestPatches(sitesnum);

		while (interrupted != true) {

			// lokalis valtozok kisbeûvel!!!!!!!!

			// BestBee megkeresése
			bestbee = this.getBestBee(bestpatches);
			if (this.bestbee != null) {
				// System.out.println("trajectory:
				// "+this.BestBee.getPatchState().getFullTransitionIdTrajectory());
			} else
				System.out.println("hali");
			if (interrupted == true) {
				break;
			}

			bestpatches = this.getBestPatches(sitesnum);

			System.out.println("next run ------------------------");

			for (int i = 0; i < bestpatches.size(); i++) {
				Integer RecruitedBeesNum = 0;
				if (i < eliteSitesNum)
					RecruitedBeesNum = eliteBeesNum;
				else
					RecruitedBeesNum = otherBeesNum;
				for (int j = 0; j < RecruitedBeesNum; j++) {
					StupidBee sb = this.createNeighbourhoodBee(bestpatches.get(i), patchSize);
					if (sb != null && sb.getFitness().isSatisifiesHardObjectives()) {
						set = this.solutionStore.newSolution(context);
					}
					if (set != StopExecutionType.CONTINUE) {
						this.handleset(context);
						if (interrupted == true)
							return;
					}
				}
				this.selectBestBeeInPatch(bestpatches.get(i));
			}
			Integer remainingBeesNum = numberOfMaxBees - numberOfActiveBees;
			for (int i = 0; i < remainingBeesNum; i++) {
				Patch randomBee = this.createRandomBee(patchSize);
				this.patches.add(randomBee);
			}
		}
	}

	private void issolution(Patch randomBee) {
		if (randomBee.getBestfitness().isSatisifiesHardObjectives()) {
			set = solutionStore.newSolution(context);
			if (set != StopExecutionType.CONTINUE) {
				this.handleset(context);
				if (interrupted == true)
					return;
			}
		}

	}

	private void handleset(ThreadContext context2) {
		if (this.set == StopExecutionType.STOP_ALL)
			this.interruptStrategy();
		try {
			context2.notify();
			context2.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private Patch createRandomBee(Integer patchSize) {
		ArrayList<String> reachedStates = new ArrayList<String>();
		DesignSpaceManager dsm = context.getDesignSpaceManager();

		while (dsm.getTrajectoryFromRoot().size() != 0) {
			dsm.undoLastTransformation();
		}
		TrajectoryInfo ti = dsm.getTrajectoryInfo().clone();
		while (patchSize > 0) {
			ITransition nextTran = this.selectNextTransition();
			while (nextTran == null && dsm.getTrajectoryFromRoot().size() >= 0) {
				this.stepBack();
				nextTran = this.selectNextTransition();
				ti.stepBack();
			}
			System.out.println("decision: " + dsm.getCurrentState());
			context.getDesignSpaceManager().fireActivation(nextTran);
			if (!reachedStates.contains(dsm.getCurrentState().getId().toString())
					|| dsm.getCurrentState().getId() == this.startstate.getId()) {
				patchSize--;
				ti.addStep(nextTran);
				reachedStates.add(dsm.getCurrentState().getId().toString());
				System.out.println("reached state: " + dsm.getCurrentState());
			} else {
				dsm.undoLastTransformation();
				patchSize--;
			}
		}
		Patch p = new Patch();
		if (ti.getTransitionTrajectory().size() != 0)
			p.initPatch(ti, context);
		p.setBestfitness(context.calculateFitness());
		this.patches.add(p);
		this.numberOfActiveBees++;
		p.setBestfitness(context.calculateFitness());
		p.initPatch(context.getDesignSpaceManager().getTrajectoryInfo(), context);
		return p;
	}

	private void selectBestBeeInPatch(Patch patch) {
		for (int i = 0; i < patch.getBeeList().size(); i++) {
			double dBest = 0.0;
			double dNext = 0.0;
			Fitness f = patch.getBestBee().getTrajectoryFitness().fitness;
			for (Entry<String, Double> fit : f.entrySet()) {
				if (fit.getKey().equals("MyTrajectoryCost")) {
					dBest = fit.getValue();

				}
			}
			f = patch.getBeeList().get(i).getTrajectoryFitness().fitness;
			for (Entry<String, Double> fit : f.entrySet()) {
				if (fit.getKey().equals("MyTrajectoryCost")) {
					dNext = fit.getValue();

				}
			}
			if (dBest < dNext) {
				patch.bestBee = patch.getBeeList().get(i);

			}
		}
		patch.patch = patch.bestBee.actualState;
		this.numberOfActiveBees -= patch.getBeeList().size();
		patch.setBeeList(new ArrayList<StupidBee>());

	}

	private StupidBee createNeighbourhoodBee(Patch patch, Integer patchSize) {
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
		patch.getBeeList().add(sb);
		this.numberOfActiveBees++;
		return sb;
	}

	private Boolean stepBack() {
		boolean didUndo = dsm.undoLastTransformation();
		// TODO visszalep=> torli az elt
		if (!didUndo) {
			return false;
		}
		return true;
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

	private ArrayList<Patch> getBestPatches(Integer bestsize) {
		context.getObjectiveComparatorHelper().clearTrajectoryFitnesses();
		this.bestpatches = new ArrayList<Patch>();
		for (Patch patch : patches) {
			TrajectoryFitness tf = new TrajectoryFitness(patch.getBestBee().getActualState(),
					patch.getBestBee().getFitness());

			// System.out.println(tf);
			patch.getBestBee().setTrajectoryFitness(tf);
			context.getObjectiveComparatorHelper().addTrajectoryFitness(tf);
		}

		List<ArrayList<TrajectoryFitness>> fitnessFronts = context.getObjectiveComparatorHelper().getFronts();

		// go throw all trajectories, and get the front, and till the size of
		// the front is smaller than the given number we add a new patch to them
		for (ArrayList<TrajectoryFitness> arrayList : fitnessFronts) {
			for (TrajectoryFitness trajectoryFitness : arrayList) {
				for (Patch p : patches) {
					if (p.getBestBee().trajectoryFitness.equals(trajectoryFitness)) {
						this.bestpatches.add(p);
					}
					// System.out.println(p.getBestBee().getTrajectoryFitness());
					if (bestpatches.size() >= bestsize)
						break;
				}
				if (bestpatches.size() >= bestsize)
					break;
			}
			if (bestpatches.size() >= bestsize)
				break;
		}

		return bestpatches;
	}

	@Override
	public void interruptStrategy() {
		interrupted = true;

	}

	// helper methods

	public StupidBee getBestBee(ArrayList<Patch> bestPatches) {
		if (bestPatches == null || bestPatches.size() == 0) {
			return null;
		}

		if (this.patches == null || this.patches.size() == 0)
			return null;
		return bestPatches.get(0).getBestBee();
	}

	// Generated getters and setters to setable variables

	public Integer getNumberOfMaxBees() {
		return numberOfMaxBees;
	}

	public void setNumberOfMaxBees(Integer numberOfMaxBees) {
		this.numberOfMaxBees = numberOfMaxBees;
	}

	public Integer getBeesnum() {
		return beesnum;
	}

	public void setBeesnum(Integer beesnum) {
		this.beesnum = beesnum;
	}

	public Integer getSitesNum() {
		return sitesnum;
	}

	public void setSitesNum(Integer sitesNum) {
		this.sitesnum = sitesNum;
	}

	public Integer getEliteSitesNum() {
		return eliteSitesNum;
	}

	public void setEliteSitesNum(Integer eliteSitesNum) {
		this.eliteSitesNum = eliteSitesNum;
	}

	public Integer getPatchSize() {
		return patchSize;
	}

	public void setPatchSize(Integer patchSize) {
		this.patchSize = patchSize;
	}

	public Integer getEliteBeesNum() {
		return eliteBeesNum;
	}

	public void setEliteBeesNum(Integer eliteBeesNum) {
		this.eliteBeesNum = eliteBeesNum;
	}

	public Integer getOtherBeesNum() {
		return otherBeesNum;
	}

	public void setOtherBeesNum(Integer otherBeesNum) {
		this.otherBeesNum = otherBeesNum;
	}
	
	public ThreadContext getContext() {
		return context;
	}

	public void setContext(ThreadContext context) {
		this.context = context;
	}

	public DesignSpaceManager getDsm() {
		return dsm;
	}

	public void setDsm(DesignSpaceManager dsm) {
		this.dsm = dsm;
	}

	public Boolean getInterrupted() {
		return interrupted;
	}

	public void setInterrupted(Boolean interrupted) {
		this.interrupted = interrupted;
	}

	public ISolutionStore getSolutionStore() {
		return solutionStore;
	}

	public void setSolutionStore(ISolutionStore solutionStore) {
		this.solutionStore = solutionStore;
	}

	public StupidBee getBestbee() {
		return bestbee;
	}

	public void setBestbee(StupidBee bestbee) {
		this.bestbee = bestbee;
	}

	public ArrayList<Patch> getNextgenerations() {
		return nextgenerations;
	}

	public void setNextgenerations(ArrayList<Patch> nextgenerations) {
		this.nextgenerations = nextgenerations;
	}

	public ArrayList<Patch> getBestpatches() {
		return bestpatches;
	}

	public void setBestpatches(ArrayList<Patch> bestpatches) {
		this.bestpatches = bestpatches;
	}

	public StopExecutionType getSet() {
		return set;
	}

	public void setSet(StopExecutionType set) {
		this.set = set;
	}

	public ArrayList<Patch> getPatches() {
		return patches;
	}

	public void setPatches(ArrayList<Patch> patches) {
		this.patches = patches;
	}

	public Integer getNumberOfActiveBees() {
		return numberOfActiveBees;
	}

	public void setNumberOfActiveBees(Integer numberOfActiveBees) {
		this.numberOfActiveBees = numberOfActiveBees;
	}

	public Patch getBestPatch() {
		return bestPatch;
	}

	public void setBestPatch(Patch bestPatch) {
		this.bestPatch = bestPatch;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberOfFoundTransitions() {
		return numberOfFoundTransitions;
	}

	public void setNumberOfFoundTransitions(Integer numberOfFoundTransitions) {
		this.numberOfFoundTransitions = numberOfFoundTransitions;
	}

	public FilterOptions getFo() {
		return fo;
	}

	public void setFo(FilterOptions fo) {
		this.fo = fo;
	}

	public Integer getSitesnum() {
		return sitesnum;
	}

	public void setSitesnum(Integer sitesnum) {
		this.sitesnum = sitesnum;
	}

	public IState getStartstate() {
		return startstate;
	}

	public void setStartstate(IState startstate) {
		this.startstate = startstate;
	}
}
