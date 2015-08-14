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
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore.StopExecutionType;

import stopConditions.IStopCondition;
import stopConditions.NumberOfFiredTransitionCondition;
import strategySelectors.IStrategySelector;
import strategySelectors.SearchContext;

public class BeeStrategy3 implements IStrategy {
	public BeeStrategy3() {

	};

	private ArrayList<ExplorerThread> workerThreads = new ArrayList<ExplorerThread>();
	private ArrayList<SearchData> patches;

	private Boolean alwaysnew = true;

	private volatile ConcurrentLinkedQueue<SearchData> searchablePatches = new ConcurrentLinkedQueue<SearchData>();
	private volatile ConcurrentLinkedQueue<SearchData> instancesToBeChecked = new ConcurrentLinkedQueue<SearchData>();
	private ThreadContext context;
	private DesignSpaceManager dsm;
	private ISolutionStore solutionStore;
	private boolean interrupted = false;
	private ArrayList<SearchData> bestpatches;
	private StopExecutionType set = StopExecutionType.CONTINUE;
	private Integer sitesnum = 3;
	private int eliteSitesNum = 1;
	private Integer bestSitesNum = 3;
	private IStopCondition miniStrategyStopCondition;
	private IStrategySelector strategySelector;
	private SearchContext searchContext;
	
	public IStrategySelector getStrategySelector() {
		return strategySelector;
	}

	public void setStrategySelector(IStrategySelector strategySelector) {
		this.strategySelector = strategySelector;
	}

	private Logger logger = Logger.getLogger(BeeStrategy3.class);
	

	public Integer getBestSitesNum() {
		return bestSitesNum;
	}

	public void setBestSitesNum(Integer bestSitesNum) {
		this.bestSitesNum = bestSitesNum;
	}

	private Integer eliteBeesNum = 1;
	private Integer otherBeesNum = 1;

	private Integer radiusOfRandomSearch = 4;
	private volatile int numberOfActiveBees = 0;
	private int numberOfMaxBees = 3;
//	protected IMiniStrategy randomSearchCreator;
//	protected IMiniStrategy localSearchCreator;
	private int iterations = 1;

	private IState rootState;
	private TrajectoryInfo rootTrajectory;

	@Override
	public synchronized void initStrategy(ThreadContext context) {
	
		this.patches = new ArrayList<SearchData>();
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		this.solutionStore = context.getGlobalContext().getSolutionStore();
		
	}

	@Override
	public void explore() {
		if ((numberOfMaxBees
				- (this.eliteSitesNum * (eliteBeesNum - otherBeesNum) + this.bestSitesNum * otherBeesNum)) < 1) {
			throw new DSEException(
					"Invalid value, numberOfMaxBees must be bigger than eliteSitesNum*(eliteBeesNum-otherBeesNum)+bestSitesNum*otherBeesNum");
		}
		if(this.strategySelector == null){
			throw new DSEException("StrategySelector is undefind, it can be set with Strategy.setStrategySelector");
		}
		this.miniStrategyStopCondition = new  NumberOfFiredTransitionCondition();
		SearchData sd = new SearchData();
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

		// number of bestpatches is set at the creation of the strategy
		this.bestpatches = new ArrayList<SearchData>();
		// here we create random pathces in the exploration space with the help
		// of the workerthreads
		for (int i = 0; i < numberOfMaxBees; i++) {
			IStopCondition cond = this.miniStrategyStopCondition.createNew(radiusOfRandomSearch * iterations);
			if (!this.createRandomBee(cond)) {
				System.out.println("exploreown2 :(");
				return;
			}
		}
		// we wait till we get back the solution from workerthreads
		while (numberOfActiveBees >= 1 && interrupted != true) {
			getBackBees();
		}
		// collect the bests from patches (sitesnum can be set by the user at
		// the beginning of the strategy), a better patch has a better best bee,
		// the other bees does not count
		if (interrupted == true)
			return;
		getBestPatches(sitesnum);
		while (interrupted != true) {
			iterations++;
			System.out.println(interrupted);
			// select best patches, a better patch has a better best bee, the
			// other bees does not count
			this.bestpatches = getBestPatches(sitesnum);

			// create neighbourhoodbees from the best patches (elitepatches have
			// more bees than others)
			int length;
			if (bestSitesNum < this.bestpatches.size())
				length = bestSitesNum;
			else
				length = this.bestpatches.size();
			for (int i = 0; i < length; i++) {
				Integer RecruitedBeesNum = 0;
				if (i < eliteSitesNum)
					RecruitedBeesNum = eliteBeesNum;
				else
					RecruitedBeesNum = otherBeesNum;
				for (int j = 0; j < RecruitedBeesNum; j++) {
					try{
						IStopCondition cond = this.miniStrategyStopCondition.createNew(radiusOfRandomSearch);
						this.createNeighbourhoodBee(this.bestpatches.get(i), cond);
					}
					catch (Exception e){
					logger.debug(e);
					String s = bestpatches + " "+ bestpatches.size()+ " "+ radiusOfRandomSearch+ " "+length + " "+ RecruitedBeesNum+ " "+i;
					logger.debug(s);
					}
					bestpatches.get(i).setHasChild(true);
				}
			}

			// remaingingBeesNum must be bigger than 0
			Integer remainingBeesNum = numberOfMaxBees - numberOfActiveBees;
			for (int i = 0; i < remainingBeesNum; i++) {
				// the deepness of new patches should be as high as the other
				// deepness
				IStopCondition cond = this.miniStrategyStopCondition.createNew(radiusOfRandomSearch * iterations);
				createRandomBee(cond);
			}
			while (numberOfActiveBees >= 1) {
				if (this.interrupted == true)
					return;
				getBackBees();
			}

		}
	}

	/**
	 * it will give back one element of the bees from the
	 * <bold>instancesToBeChecked </bold> list if this element is a patch, than
	 * it will be put into the patch list, if it is a stupidBee than it will be
	 * put into the patch where it belongs
	 */
	private void getBackBees() {
		SearchData sd = getFromConcurrentList();
		if (sd != null) {

			this.decreasenumberOfActiveBees();
			if (sd.getParentTrajectory() == null)
				return;
			if (sd.getOwnfitness() == null)
				return;
			sd.setHasChild(false);
			isSolution(sd);
			if (this.interrupted == true)
				return;
			Boolean contained = false;
			for (int i = 0; i < this.patches.size(); i++) {
				if (patches.get(i).getActualState().equals(sd.getActualState())) {
					contained = true;
				}
			}
			if (contained == false)
				patches.add(sd);

		} else {
			wakeThreads();
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
	 * @param sd
	 * @return boolean
	 */
	public boolean isSolution(SearchData sd) {
		if (sd != null && sd.getOwnfitness().isSatisifiesHardObjectives()) {
			while (dsm.getTrajectoryFromRoot().size() != 0) {
				dsm.undoLastTransformation();
			}
			TrajectoryInfo ti = sd.getActualState();
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

	private ArrayList<SearchData> getBestPatches(Integer sitesnum2) {
		

		Collections.sort(this.patches, new Comparator<SearchData>() {

			@Override
			public int compare(SearchData o1, SearchData o2) {
				return context.getObjectiveComparatorHelper().compare(o1.getOwnfitness(), o2.getOwnfitness());

			}

		});

		this.bestpatches = new ArrayList<SearchData>();
		int length = this.bestSitesNum;

		if (bestSitesNum > patches.size())
			length = patches.size();
	
		if (this.alwaysnew == false) {
			for (int i = 0; i < length; i++) {
				bestpatches.add(patches.get(i));
		
			}
		} else {
			Iterator<SearchData> it = patches.iterator();
			while (length > 0 && it.hasNext()) {
				SearchData sd = it.next();
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
	private boolean createNeighbourhoodBee(SearchData oldSearchData, IStopCondition stopCond) {
		if (oldSearchData != null) {
			
			SearchData sd = new SearchData();
			oldSearchData.setHasChild(true);
			sd.setHasChild(false);
			sd.setActualState(oldSearchData.getActualState());
			sd.setParentTrajectory(oldSearchData.getActualState());
			sd.setHasParent(true);
			sd.setParentfitness(oldSearchData.getOwnfitness());
			sd.stopCond =  stopCond;
			
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
		if (this.instancesToBeChecked.size() > 0) {
			return this.instancesToBeChecked.poll();
		}
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
	private Boolean createRandomBee(IStopCondition stopCondition) {		
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

	public ArrayList<SearchData> getPatches() {
		return patches;
	}

	public void setPatches(ArrayList<SearchData> patches) {
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

	public ArrayList<SearchData> getBestpatches() {
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
		if ((numberOfMaxBees
				- (this.eliteSitesNum * (eliteBeesNum - otherBeesNum) + this.bestSitesNum * otherBeesNum)) < 1) {
			throw new Exception(
					"Invalid value, numberOfMaxBees must be bigger than eliteSitesNum*(eliteBeesNum-otherBeesNum)+bestSitesNum*otherBeesNum");
		}
		this.numberOfMaxBees = numberOfMaxBees;
	}

	

	

}
