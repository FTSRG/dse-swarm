package org.eclipse.viatra.dse.beestrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ExplorerThread;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore.StopExecutionType;

public class BeeStrategy implements IStrategy {

	public BeeStrategy(int x) {
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Patch> patches;
	// private volatile ConcurrentHashMap<TrajectoryInfo, StupidBee> tryStart =
	// new ConcurrentHashMap<TrajectoryInfo, StupidBee>();
	private volatile ConcurrentLinkedQueue<SearchData> searchablePatches = new ConcurrentLinkedQueue<SearchData>();
	private volatile ConcurrentLinkedQueue<SearchData> instancesToBeChecked = new ConcurrentLinkedQueue<SearchData>();
	private volatile ConcurrentHashMap<IState, ReachedStateData> reachedStates = new ConcurrentHashMap<IState, ReachedStateData>();
	public BeeStratexUtil bsu = new BeeStratexUtil();
	private ThreadContext context;
	private DesignSpaceManager dsm;
	private ISolutionStore solutionStore;
	private IState startstate;
	private boolean interrupted = false;
	private ArrayList<Patch> bestpatches ;
	private StopExecutionType set = StopExecutionType.CONTINUE;
	private Integer sitesnum = 1;
	private int eliteSitesNum = 1;
	private Integer bestSitesNum = 3;
	private Integer eliteBeesNum = 2;
	private Integer otherBeesNum = 1;

	private Integer patchSize = 3;
	private volatile int numberOfActiveBees = 0;
	private int numberOfMaxBees = 5;

	protected ICreateBee randomBeeCreator;
	protected ICreateBee neighbourBeeCreator;

	@Override
	public synchronized void initStrategy(ThreadContext context) {
		this.patches = new ArrayList<Patch>();
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		this.solutionStore = context.getGlobalContext().getSolutionStore();
		this.startstate = dsm.getCurrentState();
	}

	@Override
	public void explore() {
		try {
			this.exploreown2();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * It will start as many workerThreads as many are defined in the setUp file (as MaximumPoolSize)
	 * it also sets the concurrent collections, which are used for communication between the threads. 
	 */
	protected void startWorkerThreads() {
		ExplorerThread et = context.getGlobalContext().tryStartNewThread(context, context.getModelRoot(), true,
				new BeeStrategyWorkerThread());
		while (et != null) {
			BeeStrategyWorkerThread bwt = (BeeStrategyWorkerThread) et.getThreadContext().getStrategy();
			bwt.setConcurrentCollections(this.searchablePatches, this.instancesToBeChecked);
			et = context.getGlobalContext().tryStartNewThread(context, context.getModelRoot(), true,
					new BeeStrategyWorkerThread());

		}
	}

	private void exploreown2() {
		startWorkerThreads();
		this.bestpatches = new ArrayList<Patch>();
		for (int i = 0; i < numberOfMaxBees; i++) {
			if (!this.createRandomBee(patchSize)) {
				System.out.println("exploreown2 :(");
				return;
			}
		}
		while (numberOfActiveBees >= 1) {
			getBackBees();
		}
		getBestPatches(sitesnum);
		while (interrupted != true) {
			//System.out.println(this.interrupted);
			// select best patches, a better patch has a better best bee, the
			// other bees does not count
			this.bestpatches = getBestPatches(sitesnum);

			// create neighbourhoodbees from the best patches (elitepatches have
			// more bees than others)
			for (int i = 0; i < bestSitesNum; i++) {
				Integer RecruitedBeesNum = 0;
				if (i < eliteSitesNum)
					RecruitedBeesNum = eliteBeesNum;
				else
					RecruitedBeesNum = otherBeesNum;
				for (int j = 0; j < RecruitedBeesNum; j++) {
					this.createNeighbourhoodBee(this.bestpatches.get(i), patchSize);
				}
			}
			Integer remainingBeesNum = numberOfMaxBees - numberOfActiveBees;
			for (int i = 0; i < remainingBeesNum; i++) {
				createRandomBee(patchSize);
			}
			while (numberOfActiveBees>=1){
				getBackBees();
			}
		}
		for (Patch patch : bestpatches) {
			this.selectBestBeeInPatch(patch);
		}

	}
	
	private void getBackBees() {
		SearchData sd = getFromConcurrentList();
		if (sd != null) {
			numberOfActiveBees--;
			if (sd.getIsneighbour() == true) {
				// it is a StupidBee
				StupidBee sb = sd.getStupidBee();
				isSolution(sb);
				if(this.interrupted==true) return;
				for (Patch patch : patches) {
					patch.getPatch().equals(sb.getInitialState());
				}

			} else {
				Patch p = sd.getPatch();
				this.patches.add(p);
				if (isSolution(p));
				if (interrupted == true)
					return;
			}
		}

	}

	// this is the main method, it will do everything
	private synchronized void exploreown() {
		// this.bestpatches = new ArrayList<Patch>();
		// create beesnum patches, if one of that is a solution, add to the
		// solutionstore
		// for (int i = 0; i < numberOfMaxBees; i++) {
		// Patch randomBee = this.createRandomBee(patchSize);
		// randomBee.setBestfitness(context.calculateFitness());
		// randomBee.setPatch(context.getDesignSpaceManager().getTrajectoryInfo(),
		// context);
		// this.patches.add(randomBee);
		// if (isSolution(randomBee))
		// return;
		// }
		// getBestPatches(sitesnum);

		while (interrupted != true) {

			// lokalis valtozok kisbeûvel!!!!!!!!
			if (interrupted == true) {
				break;
			}
			// select best patches, a better patch has a better best bee, the
			// other bees does not count
			this.bestpatches = getBestPatches(sitesnum);

			// create neighbourhoodbees from the best patches (elitepatches have
			// more bees than others)
			for (int i = 0; i < bestSitesNum; i++) {
				Integer RecruitedBeesNum = 0;
				if (i < eliteSitesNum)
					RecruitedBeesNum = eliteBeesNum;
				else
					RecruitedBeesNum = otherBeesNum;
				for (int j = 0; j < RecruitedBeesNum; j++) {
					this.createNeighbourhoodBee(this.bestpatches.get(i), patchSize);
				}
			}
			for (int i = 0; i < bestSitesNum; i++) {

			}
//			this.selectBestBeeInPatch(bestpatches.get(i));
//			Integer remainingBeesNum = numberOfMaxBees - numberOfActiveBees;
//			for (int i = 0; i < remainingBeesNum; i++) {
				// Patch randomBee = createRandomBee(patchSize);
				// if (isSolution(randomBee) == true) {
				// return;
				// }
				// this.patches.add(randomBee);
//			}
		}

	}

	/**
	 * Checks whether a given BEE is a solution or not, if it is a solution, it
	 * will get into the SolutionStore. The method sets the <i>interrupted</i>
	 * and <i>set</i> variables
	 * 
	 * @param bee
	 * @return boolean
	 */
	public boolean isSolution(StupidBee bee) {
		if (bee != null && bee.getFitness().isSatisifiesHardObjectives()) {
			set = solutionStore.newSolution(context);
			if (set != StopExecutionType.CONTINUE) {
				this.handleset(context);
				if (interrupted == true)
					return true;
			}
		}
		return false;
	}
	/**
	 * It will increase the numberOfActiveBees by one
	 */
	public synchronized void decreasenumberOfActiveBees() {
		this.numberOfActiveBees--;
	}
	/**
	 * It will decrease the numberOfActiveBees by one
	 */
	public synchronized void increasenumberOfActiveBees() {
		this.numberOfActiveBees++;
	}

	/**
	 * Checks whether a given PATCH is a solution or not, if it is a solution,
	 * it will get into the SolutionStore. The method sets the
	 * <i>interrupted</i> and <i>set</i> variables
	 * 
	 * @param bee
	 * @return returns true if it will end the search, returns false if the
	 *         search must continue
	 */
	public boolean isSolution(Patch randomBee) {
		if (randomBee != null && randomBee.getBestfitness().isSatisifiesHardObjectives()) {
			set = solutionStore.newSolution(context);
			if (set != StopExecutionType.CONTINUE) {
				this.handleset(context);
				if (interrupted == true)
					return true;
			}
		}
		return false;

	}

	/**
	 * If <i>set</i> is <bold>STOP_All</bold> set interrupt = true, else stops
	 * thread <i>context2</i>
	 * 
	 * @param context2
	 */
	private void handleset(ThreadContext context2) {
		if (this.set == StopExecutionType.STOP_ALL)
			this.interruptStrategy();

	}

	private ArrayList<Patch> getBestPatches(Object sitesnum2) {
		// TODO Auto-generated method stub
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
					if (bestpatches.size() >= bestSitesNum)
						break;
				}
				if (bestpatches.size() >= bestSitesNum)
					break;
			}
			if (bestpatches.size() >= bestSitesNum)
				break;
		}

		return bestpatches;
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

	/**
	 * Creates a neighbourBee in a given patch.
	 * 
	 * @param patch:
	 *            given patch
	 * @param patchSize2:
	 *            size of the trajectory of the neighbourbee
	 * @return
	 */
	private boolean createNeighbourhoodBee(Patch patch, Integer patchSize2) {
		if (neighbourBeeCreator != null) {
			CreateBeeWithDFS cbwd = new CreateBeeWithDFS();
			cbwd.setIfNeighbour(true);
			cbwd.setPatch(patch);
			cbwd.setStopCond(patchSize2);
			cbwd.setBs(this);

			SearchData sd = new SearchData();
			sd.setStrategy(cbwd);
			sd.setPatch(patch);
			sd.setPatchsize(patchSize2);
			sd.setIsneighbour(true);
			return putIntoConcurrentList(sd);
		}

		return false;
	}

	private synchronized SearchData getFromConcurrentList() {
		if (this.instancesToBeChecked.size() > 0) {
			return this.instancesToBeChecked.poll();
		}
		return null;
	}

	private synchronized boolean putIntoConcurrentList(SearchData sd) {
		if (searchablePatches == null) {
			searchablePatches = new ConcurrentLinkedQueue<SearchData>();
		}
		return this.searchablePatches.add(sd);
	}

	/**
	 * Creates a randomBee from the start
	 * 
	 * @param patchSize2:
	 *            size of the trajectory of the randombee
	 * @return
	 */
	private Boolean createRandomBee(Integer patchSize2) {
		if (this.randomBeeCreator != null) {
			ICreateBee icb = new CreateBeeWithDFS();
			Patch p = new Patch();
			p.setPatch(dsm.getTrajectoryInfo(), context);
			icb.setPatch(null);
			icb.setStopCond(patchSize2);
			icb.setIfNeighbour(false);
			icb.setMainStrategy(this);
			SearchData sd = new SearchData();
			sd.setIsneighbour(false);
			sd.setPatchsize(patchSize2);
			sd.setStrategy(icb);
			sd.setPatch(p);
			return addToSearchablePatches(sd);
		}

		return false;
	}

	private synchronized boolean addToSearchablePatches(SearchData sd) {
		boolean success = this.searchablePatches.add(sd);
		if (success == true) {
			this.numberOfActiveBees++;
		}
		return success;
	}

	@Override
	public synchronized void interruptStrategy() {
		this.interrupted = true;

	}

	// ---------------getters and setters --------------------

	public ArrayList<Patch> getPatches() {
		return patches;
	}

	public void setPatches(ArrayList<Patch> patches) {
		this.patches = patches;
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

	public ISolutionStore getSolutionStore() {
		return solutionStore;
	}

	public void setSolutionStore(ISolutionStore solutionStore) {
		this.solutionStore = solutionStore;
	}

	public IState getStartstate() {
		return startstate;
	}

	public void setStartstate(IState startstate) {
		this.startstate = startstate;
	}

	public boolean isInterrupted() {
		return interrupted;
	}

	public void setInterrupted(boolean interrupted) {
		this.interrupted = interrupted;
	}

	public ArrayList<Patch> getBestpatches() {
		return bestpatches;
	}

	public void setBestpatches(ArrayList<Patch> bestpatches) {
		this.bestpatches = bestpatches;
	}

	public Integer getSitesnum() {
		return sitesnum;
	}

	public void setSitesnum(Integer sitesnum) {
		this.sitesnum = sitesnum;
	}

	public int getEliteSitesNum() {
		return eliteSitesNum;
	}

	public void setEliteSitesNum(int eliteSitesNum) {
		this.eliteSitesNum = eliteSitesNum;
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

	public StopExecutionType getSet() {
		return set;
	}

	public void setSet(StopExecutionType set) {
		this.set = set;
	}

	public Integer getPatchSize() {
		return patchSize;
	}

	public void setPatchSize(Integer patchSize) {
		this.patchSize = patchSize;
	}

	public int getNumberOfActiveBees() {
		return numberOfActiveBees;
	}

	public void setNumberOfActiveBees(int numberOfActiveBees) {
		this.numberOfActiveBees = numberOfActiveBees;
	}

	public int getNumberOfMaxBees() {
		return numberOfMaxBees;
	}

	public void setNumberOfMaxBees(int numberOfMaxBees) {
		this.numberOfMaxBees = numberOfMaxBees;
		this.instancesToBeChecked = new ConcurrentLinkedQueue<SearchData>();
	}

	public ICreateBee getRandomBeeCreator() {
		return randomBeeCreator;
	}

	public void setRandomBeeCreator(ICreateBee randomBeeCreator) {
		this.randomBeeCreator = randomBeeCreator;
	}

	public ICreateBee getNeighbourBeeCreator() {
		return neighbourBeeCreator;
	}

	public void setNeighbourBeeCreator(ICreateBee neighbourBeeCreator) {
		this.neighbourBeeCreator = neighbourBeeCreator;
	}
	
	public synchronized Double getStateFitness(IState stateCode){
		return this.reachedStates.get(stateCode).getBestfitness();
	}
	
	public synchronized boolean setNewStateValue(IState stateCode, ReachedStateData rsd){
		ReachedStateData data = this.reachedStates.get(stateCode);
		if(data!=null && data.getBestfitness()>rsd.getBestfitness()){
			return false;
		}
		this.reachedStates.put(stateCode, rsd);
		return true;
	}
}
