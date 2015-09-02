package org.eclipse.viatra.dse.beestrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ExplorerThread;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.IMiniStrategy;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.mainStrategy.IMainStrategy;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore.StopExecutionType;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;
import org.eclipse.viatra.dse.stopConditions.NumberOfFiredTransitionCondition;
import org.eclipse.viatra.dse.strategySelectors.IStrategySelector;
import org.eclipse.viatra.dse.strategySelectors.SearchContext;

public class StrategyCombiner implements IStrategy {
	public StrategyCombiner() {

	};

	private ArrayList<ExplorerThread> workerThreads = new ArrayList<ExplorerThread>();
	

	private ArrayList<SearchTrajectory> patches;

	private Boolean alwaysnew = true;

	private volatile ConcurrentLinkedQueue<SearchData> searchablePatches = new ConcurrentLinkedQueue<SearchData>();
	private volatile ConcurrentLinkedQueue<SearchData> instancesToBeChecked = new ConcurrentLinkedQueue<SearchData>();
	private ThreadContext context;
	private DesignSpaceManager dsm;
	private ISolutionStore solutionStore;
	private boolean interrupted = false;
	private ArrayList<SearchTrajectory> bestpatches;
	private StopExecutionType set = StopExecutionType.CONTINUE;
	private Integer sitesnum = 3;
	private int eliteSitesNum = 1;
	private Integer bestSitesNum = 3;
	private IStopCondition miniStrategyStopCondition;
	private IStrategySelector strategySelector;
	private SearchContext searchContext;
	private Integer eliteBeesNum = 1;
	private IMainStrategy mainStrategy;
	

	public IMainStrategy getMainStrategy() {
		return mainStrategy;
	}

	private Logger logger = Logger.getLogger(StrategyCombiner.class);



	private Integer otherBeesNum = 1;

	private Integer radiusOfRandomSearch = 4;
	private volatile int numberOfActiveBees = 0;
	private int numberOfMaxBees = 3;
	// protected IMiniStrategy randomSearchCreator;
	// protected IMiniStrategy localSearchCreator;
	private int iterations = 1;

	private IState rootState;
	private TrajectoryInfo rootTrajectory;

	
	@Override
	public synchronized void initStrategy(ThreadContext context) {

		this.patches = new ArrayList<SearchTrajectory>();
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		this.solutionStore = context.getGlobalContext().getSolutionStore();

	}

	@Override
	public void explore() {
//		if ((numberOfMaxBees
//				- (this.eliteSitesNum * (eliteBeesNum - otherBeesNum) + this.bestSitesNum * otherBeesNum)) < 1) {
//			throw new DSEException(
//					"Invalid value, numberOfMaxBees must be bigger than eliteSitesNum*(eliteBeesNum-otherBeesNum)+bestSitesNum*otherBeesNum");
//		}
		if (this.strategySelector == null) {
			throw new DSEException("StrategySelector is undefind, it can be set with Strategy.setStrategySelector");
		}
		SearchTrajectory sd = new SearchTrajectory();
		sd.setHasParent(false);
		sd.setHasChild(false);
		sd.setParentTrajectory(context.getDesignSpaceManager().getTrajectoryInfo());
		sd.setActualState(dsm.getTrajectoryInfo().clone());
		sd.setOwnfitness(context.calculateFitness());
		sd.setOwntrajectoryFitness(new TrajectoryFitness(sd.getActualState(), context.getLastFitness()));
		isSolution(sd);
		if (interrupted == true)
			return;
		else
			patches.add(sd);
		if (context.getGlobalContext().getThreadPool().getMaximumPoolSize() > 1)
			this.exploreParalell();
		else
			this.exploreOneThread();
		
		System.out.println("explored");
	}

	private void exploreOneThread() {
		// TODO Auto-generated method stub

	}

	/**
	 * It will start as many workerThreads as many are defined in the setUp file
	 * (as MaximumPoolSize) it also sets the concurrent collections, which are
	 * used for communication between the threads.
	 */
	protected void startWorkerThreads() {
		while (true) {

			ExplorerThread et = context.getGlobalContext().tryStartNewThread(context, context.getModelRoot(), true,
					new BeeStrategyWorkerThread());
			if (et == null)
				break;
			BeeStrategyWorkerThread bwt = (BeeStrategyWorkerThread) et.getThreadContext().getStrategy();
			bwt.setConcurrentCollections(this.searchablePatches, this.instancesToBeChecked);
			this.workerThreads.add(et);
		}
	}

	private void exploreParalell() {
		this.rootState = dsm.getCurrentState();
		this.rootTrajectory = dsm.getTrajectoryInfo();
		// we have one main thread, and the user can give us the number of the
		// workerthreads ( DesignSpaceExplorer.setMaxNumberOfThreads(x))
		startWorkerThreads();
		this.mainStrategy.initMainStrategy(this);
		this.mainStrategy.exploreParalell();
		
		
	}

	/**
	 * it will give back one element of the bees from the
	 * <bold>instancesToBeChecked </bold> list if this element is a patch, than
	 * it will be put into the patch list, if it is a stupidBee than it will be
	 * put into the patch where it belongs
	 */
	public synchronized void getBackBees() {
		SearchData sd = getFromConcurrentList();
		//TODO kiszedni
//		try {
//			this.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (sd != null) {
			System.out.println("found sd");
			this.decreasenumberOfActiveBees();
			if (sd.getTrajectories() != null) {
				for (int j = 0; j < sd.getTrajectories().size(); j++) {
					if (sd.getTrajectories().get(j).getParentTrajectory() == null)
						return;
					if (sd.getTrajectories().get(j).getOwnfitness() == null)
						return;
					sd.getTrajectories().get(j).setHasChild(false);
					isSolution(sd.getTrajectories().get(j));
					if (this.interrupted == true)
						return;
					Boolean contained = false;
					for (int i = 0; i < this.patches.size(); i++) {
						if (patches.get(i).getActualState().equals(sd.getTrajectories().get(j).getActualState())) {
							contained = true;
						}
					}
					if (contained == false)
						patches.add(sd.getTrajectories().get(j));
				}

			} else {
				wakeThreads();
			}

		}

	}

	private synchronized void wakeThreads() {
		this.notifyAll();
	}

	/**
	 * Checks whether a given BEE is a solution or not, if it is a solution, it
	 * will get into the SolutionStore. The method sets the <i>interrupted</i>
	 * and <i>set</i> variables
	 * 
	 * @param searchTrajectory
	 * @return boolean
	 */
	public boolean isSolution(SearchTrajectory searchTrajectory) {
		System.out.println("solution");
		if (searchTrajectory != null && searchTrajectory.getOwnfitness().isSatisifiesHardObjectives()) {
			while (dsm.getTrajectoryFromRoot().size() != 0) {
				dsm.undoLastTransformation();
			}
			TrajectoryInfo ti = searchTrajectory.getActualState();
			for (ITransition tran : ti.getFullTransitionTrajectory()) {
				logger.debug(tran);
			}
			for (ITransition tran : ti.getFullTransitionTrajectory()) {
				dsm.fireActivation(tran);
			}
			logger.debug("solution found");
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
		logger.debug("number of running threads decreased");
		this.numberOfActiveBees--;
	}

	/**
	 * It will decrease the numberOfActiveBees by one
	 */
	public synchronized void increasenumberOfActiveBees() {
		this.numberOfActiveBees++;
		this.notifyAll();
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

	public ArrayList<SearchTrajectory> getBestPatches(Integer sitesnum2) {

		Collections.sort(this.patches, new Comparator<SearchTrajectory>() {

			@Override
			public int compare(SearchTrajectory o1, SearchTrajectory o2) {
				return context.getObjectiveComparatorHelper().compare(o1.getOwnfitness(), o2.getOwnfitness());
			}

		

		});

		this.bestpatches = new ArrayList<SearchTrajectory>();
		int length = this.bestSitesNum;

		if (bestSitesNum > patches.size())
			length = patches.size();

		if (this.alwaysnew == false) {
			for (int i = 0; i < length; i++) {
				bestpatches.add(patches.get(i));
				System.out.println("fitness: "+patches.get(i).getOwnfitness());

			}
		} else {
			Iterator<SearchTrajectory> it = patches.iterator();
			while (length > 0 && it.hasNext()) {
				SearchTrajectory sd = it.next();
				if (sd.getHasChild() == false) {
					bestpatches.add(sd);
					length--;
				}
			}
		}

		return bestpatches;
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
	public boolean createNeighbourhoodBee(SearchTrajectory oldSearchData, IStopCondition stopCond) {
		if (oldSearchData != null) {

			SearchData sd = new SearchData();
			oldSearchData.setHasChild(true);
			sd.setHasChild(false);
			sd.setActualState(oldSearchData.getActualState());
			sd.setParentTrajectory(oldSearchData.getActualState());
			sd.setHasParent(true);
			sd.setParentfitness(oldSearchData.getOwnfitness());

			sd.stopCond = stopCond.createNew(stopCond);
			IMiniStrategy strategy = (IMiniStrategy) this.strategySelector.selectStrategy(sd, this.searchContext);
			sd.setStrategy(strategy.createMiniStrategy(this));
			strategy.setMainStrategy(this);

			return addToSearchablePatches(sd);
		}

		return false;
	}

	/**
	 * get an element from the list instancesToBeChecked if it has, it it hasn't
	 * than gives back null
	 */
	private synchronized SearchData getFromConcurrentList() {
		if (!this.instancesToBeChecked.isEmpty()) {
			return this.instancesToBeChecked.poll();
		}
//		try {
//			this.wait(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}
	/**
	 * put an element into the list searchablePatches, it the list doesn't exist
	 * it creates the list
	 */
	// private synchronized boolean putIntoConcurrentList(SearchData sd) {
	// if (searchablePatches == null) {
	// searchablePatches = new ConcurrentLinkedQueue<SearchData>();
	// }
	// return this.searchablePatches.add(sd);
	// }

	/**
	 * Creates a randomBee from the start
	 * 
	 * @param patchSize2:
	 *            size of the trajectory of the randombee
	 * @return
	 */
	public Boolean createRandomBee(IStopCondition stopCondition) {
		SearchData sd = new SearchData();
		sd.setActualState(new TrajectoryInfo(this.rootState, this.rootTrajectory));
		sd.setHasChild(false);
		sd.setParentTrajectory(new TrajectoryInfo(this.rootState, this.rootTrajectory));
		sd.setHasParent(false);
		sd.setParentfitness(null);
		sd.stopCond = stopCondition;
		IMiniStrategy strategy = (IMiniStrategy) this.strategySelector.selectStrategy(sd, this.searchContext);
		sd.setStrategy(strategy.createMiniStrategy(this));
		strategy.setMainStrategy(this);
		sd.setStrategy(strategy);
		return addToSearchablePatches(sd);

	}

	// add an element to the seach
	private synchronized boolean addToSearchablePatches(SearchData sd) {
		boolean success = this.searchablePatches.add(sd);
		if (success == true) {
			this.increasenumberOfActiveBees();
		}
		this.notifyAll();
		return success;
	}

	@Override
	public synchronized void interruptStrategy() {

		this.interrupted = true;
		Iterator<ExplorerThread> it = this.workerThreads.iterator();
		while (it.hasNext()) {
			ExplorerThread et = (ExplorerThread) it.next();
			et.getThreadContext().getStrategy().interruptStrategy();
		}
		// ExplorerThread me = null;
		// while (context.getGlobalContext().getThreadPool().getPoolSize() > 1)
		// {
		// try {
		// ExplorerThread et = null;
		// context.getGlobalContext().stopAllThreads();
		// // while ( et==null){
		// //
		// // //System.out.println(a.isEmpty());
		// // et = (ExplorerThread)
		// // context.getGlobalContext().getThreadPool().getQueue().peek();
		// // System.out.println(et);
		// // }
		// // if (context.getExplorerThread() != et) {
		// //
		// System.out.println(context.getGlobalContext().getThreadPool().getPoolSize());
		// // System.out.println(et);
		// // et.stopRunning();
		// // } else {
		// // me = (ExplorerThread)
		// // context.getGlobalContext().getThreadPool().getQueue().poll();
		// // }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// if (me != null)
		// context.getGlobalContext().getThreadPool().getQueue().add(me);

	}

	// ---------------getters and setters --------------------

	public ArrayList<SearchTrajectory> getPatches() {
		return patches;
	}

	public void setPatches(ArrayList<SearchTrajectory> patches) {
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

	public boolean isInterrupted() {
		return interrupted;
	}

	public void setInterrupted(boolean interrupted) {
		this.interrupted = interrupted;
	}

	public ArrayList<SearchTrajectory> getBestpatches() {
		return bestpatches;
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
		return radiusOfRandomSearch;
	}

	public void setPatchSize(Integer patchSize) {
		this.radiusOfRandomSearch = patchSize;
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

	public void setNumberOfMaxBees(int numberOfMaxBees) throws Exception {
//		if ((numberOfMaxBees
//				- (this.eliteSitesNum * (eliteBeesNum - otherBeesNum) + this.bestSitesNum * otherBeesNum)) < 1) {
//			throw new Exception(
//					"Invalid value, numberOfMaxBees must be bigger than eliteSitesNum*(eliteBeesNum-otherBeesNum)+bestSitesNum*otherBeesNum");
//		}
		this.numberOfMaxBees = numberOfMaxBees;
	}
	
	public ArrayList<ExplorerThread> getWorkerThreads() {
		return workerThreads;
	}

	public void setWorkerThreads(ArrayList<ExplorerThread> workerThreads) {
		this.workerThreads = workerThreads;
	}

	public Boolean getAlwaysnew() {
		return alwaysnew;
	}

	public void setAlwaysnew(Boolean alwaysnew) {
		this.alwaysnew = alwaysnew;
	}

	public ConcurrentLinkedQueue<SearchData> getSearchablePatches() {
		return searchablePatches;
	}

	public void setSearchablePatches(ConcurrentLinkedQueue<SearchData> searchablePatches) {
		this.searchablePatches = searchablePatches;
	}

	public ConcurrentLinkedQueue<SearchData> getInstancesToBeChecked() {
		return instancesToBeChecked;
	}

	public void setInstancesToBeChecked(ConcurrentLinkedQueue<SearchData> instancesToBeChecked) {
		this.instancesToBeChecked = instancesToBeChecked;
	}

	public SearchContext getSearchContext() {
		return searchContext;
	}

	public void setSearchContext(SearchContext searchContext) {
		this.searchContext = searchContext;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Integer getRadiusOfRandomSearch() {
		return radiusOfRandomSearch;
	}

	public void setRadiusOfRandomSearch(Integer radiusOfRandomSearch) {
		this.radiusOfRandomSearch = radiusOfRandomSearch;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public void setBestpatches(ArrayList<SearchTrajectory> bestpatches) {
		this.bestpatches = bestpatches;
	}
	
	public IStrategySelector getStrategySelector() {
		return strategySelector;
	}

	public void setStrategySelector(IStrategySelector strategySelector) {
		this.strategySelector = strategySelector;
	}
	
	public Integer getBestSitesNum() {
		return bestSitesNum;
	}

	public void setBestSitesNum(Integer bestSitesNum) {
		this.bestSitesNum = bestSitesNum;
	}

	

	public IStopCondition getMiniStrategyStopCondition() {
		return miniStrategyStopCondition;
	}

	public void setMiniStrategyStopCondition(IStopCondition miniStrategyStopCondition) {
		this.miniStrategyStopCondition = miniStrategyStopCondition;
	}
	
	public IState getRootState() {
		return rootState;
	}

	public void setRootState(IState rootState) {
		this.rootState = rootState;
	}

	

	public TrajectoryInfo getRootTrajectory() {
		return rootTrajectory;
	}

	public void setRootTrajectory(TrajectoryInfo rootTrajectory) {
		this.rootTrajectory = rootTrajectory;
	}

	public void setMainStrategy(IMainStrategy ms) {
		this.mainStrategy = ms;
		
	}


}
