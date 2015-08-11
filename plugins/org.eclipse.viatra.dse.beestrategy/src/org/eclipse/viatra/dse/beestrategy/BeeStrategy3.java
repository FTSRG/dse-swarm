package org.eclipse.viatra.dse.beestrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.viatra.dse.api.DSEException;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ExplorerThread;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithDFS;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.CreateBeeWithHillClimbing;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.objectives.ObjectiveComparatorHelper;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore;
import org.eclipse.viatra.dse.solutionstore.ISolutionStore.StopExecutionType;

public class BeeStrategy3 implements IStrategy {
	public BeeStrategy3(){
		
	};

	public BeeStrategy3(ICreateBee randomBeeCreator,ICreateBee neighbourBeeCreator) {
		this.randomSearchCreator = randomBeeCreator;
		this.localSearchCreator = neighbourBeeCreator;
	}

	private ArrayList<Patch> patches;
	
	private volatile ConcurrentLinkedQueue<SearchData> searchablePatches = new ConcurrentLinkedQueue<SearchData>();
	private volatile ConcurrentLinkedQueue<SearchData> instancesToBeChecked = new ConcurrentLinkedQueue<SearchData>();
	private ThreadContext context;
	private DesignSpaceManager dsm;
	private ISolutionStore solutionStore;
	private boolean interrupted = false;
	private ArrayList<Patch> bestpatches;
	private StopExecutionType set = StopExecutionType.CONTINUE;
	private Integer sitesnum = 3;
	private int eliteSitesNum = 1;
	private Integer bestSitesNum = 3;

	public Integer getBestSitesNum() {
		return bestSitesNum;
	}

	public void setBestSitesNum(Integer bestSitesNum) {
		this.bestSitesNum = bestSitesNum;
	}

	private Integer eliteBeesNum = 1;
	private Integer otherBeesNum = 1;

	private Integer radiusOfRandomSearch = 4;
	private Integer radiusOfPatch = 4;
	private volatile int numberOfActiveBees = 0;
	private int numberOfMaxBees = 3;

	protected ICreateBee randomSearchCreator;
	protected ICreateBee localSearchCreator;
	private int iterations = 1;

	@Override
	public synchronized void initStrategy(ThreadContext context) {
		if ((numberOfMaxBees
				- (this.eliteSitesNum * (eliteBeesNum - otherBeesNum) + this.bestSitesNum * otherBeesNum)) < 1) {
			throw new DSEException(
					"Invalid value, numberOfMaxBees must be bigger than eliteSitesNum*(eliteBeesNum-otherBeesNum)+bestSitesNum*otherBeesNum");
		}
		this.patches = new ArrayList<Patch>();
		this.context = context;
		this.dsm = context.getDesignSpaceManager();
		this.solutionStore = context.getGlobalContext().getSolutionStore();
	}

	@Override
	public void explore() {
		if(context.getGlobalContext().getThreadPool().getMaximumPoolSize()>1)
		this.exploreParalell();
		else this.exploreOneThread();
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
		}
	}

	private void exploreParalell() {
		// we have one main thread, and the user can give us the number of the
		// workerthreads ( DesignSpaceExplorer.setMaxNumberOfThreads(x))
		startWorkerThreads();

		// number of bestpatches is set at the creation of the strategy
		this.bestpatches = new ArrayList<Patch>();
		// here we create random pathces in the exploration space with the help
		// of the workerthreads
		for (int i = 0; i < numberOfMaxBees; i++) {
			if (!this.createRandomBee(radiusOfRandomSearch * iterations)) {
				System.out.println("exploreown2 :(");
				return;
			}
		}
		// we wait till we get back the solution from workerthreads
		while (numberOfActiveBees >= 1) {
			getBackBees();
		}
		// collect the bests from patches (sitesnum can be set by the user at
		// the beginning of the strategy), a better patch has a better best bee,
		// the other bees does not count
		getBestPatches(sitesnum);
		while (interrupted != true) {
			iterations++;
			// select best patches, a better patch has a better best bee, the
			// other bees does not count
			this.bestpatches = getBestPatches(sitesnum);

			// create neighbourhoodbees from the best patches (elitepatches have
			// more bees than others)
			int length = this.patches.size();
			if (bestSitesNum < this.patches.size())
				length = bestSitesNum;
			for (int i = 0; i < length; i++) {
				Integer RecruitedBeesNum = 0;
				if (i < eliteSitesNum)
					RecruitedBeesNum = eliteBeesNum;
				else
					RecruitedBeesNum = otherBeesNum;
				for (int j = 0; j < RecruitedBeesNum; j++) {
					this.createNeighbourhoodBee(this.bestpatches.get(i), radiusOfRandomSearch);
				}
			}

			// remaingingBeesNum must be bigger than 0
			Integer remainingBeesNum = numberOfMaxBees - numberOfActiveBees;
			for (int i = 0; i < remainingBeesNum; i++) {
				// the deepness of new patches should be as high as the other
				// deepness
				createRandomBee(radiusOfRandomSearch * iterations);
			}
			while (numberOfActiveBees >= 1) {
				if (this.interrupted == true)
					return;
				getBackBees();
			}
			// select the best bee in each patch
			this.selectBestBeeInPatch();

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
			if (sd.getHasParent() == true) {
				// it is a StupidBee
				StupidBee sb = sd.getStupidBee();
				if (sb.getFitness() == null)
					return;
				isSolution(sb);
				if (this.interrupted == true)
					return;
				for (Patch patch : patches) {
					if (patch.getPatch().equals(sb.getInitialState())) {
						patch.getBeeList().add(sb);
						break;
					}
				}

			} else {
				Patch p = sd.getPatch();
				if (p.getBestfitness() == null)
					return;
				this.patches.add(p);
				if (isSolution(p))
					;
				if (interrupted == true)
					return;
			}
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
	 * @param bee
	 * @return boolean
	 */
	public boolean isSolution(StupidBee bee) {
		if (bee != null && bee.getFitness().isSatisifiesHardObjectives()) {
			while (dsm.getTrajectoryFromRoot().size() != 0) {
				dsm.undoLastTransformation();
			}
			TrajectoryInfo ti = bee.getActualState();
			for (ITransition tran : ti.getFullTransitionTrajectory()) {
				dsm.fireActivation(tran);
			}
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
		this.notifyAll();
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
		if (randomBee != null && randomBee.getBestfitness() != null
				&& randomBee.getBestfitness().isSatisifiesHardObjectives()) {
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
		context.getObjectiveComparatorHelper().clearTrajectoryFitnesses();
		this.bestpatches = new ArrayList<Patch>();
		for (Patch patch : patches) {
			TrajectoryFitness tf = new TrajectoryFitness(patch.getBestBee().getActualState(),
					patch.getBestBee().getFitness());
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
					if (bestpatches.size() >= bestSitesNum)
						break;
				}
				if (bestpatches.size() >= bestSitesNum)
					break;
			}
			if (bestpatches.size() >= bestSitesNum)
				break;
		}
		patches = bestpatches;
		return bestpatches;
	}

	private void selectBestBeeInPatch() {
		ObjectiveComparatorHelper och = context.getObjectiveComparatorHelper();
		if (patches.size() == 0)
			interruptStrategy();
		for (Patch patch : patches) {
			och.clearTrajectoryFitnesses();
			if (patch.getBeeList().size() != 0) {

				for (StupidBee beechan : patch.getBeeList()) {
					och.addTrajectoryFitness(beechan.getTrajectoryFitness());
				}
				TrajectoryFitness tf = och.getRandomBest();
				for (StupidBee beechan : patch.getBeeList()) {
					if (beechan.getTrajectoryFitness().equals(tf)) {
						patch.bestBee = beechan;
						patch.setBeeList(new ArrayList<StupidBee>());
						patch.patch = beechan.getActualState();
						break;
					}
				}
			}

		}

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
		if (localSearchCreator != null) {
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
			return addToSearchablePatches(sd);
		}

		return false;
	}
	private boolean createNeighbourhoddBee(SearchData sd, Integer patchSize2){
		if(localSearchCreator!=null){
			if(localSearchCreator!=null){
			}
		}
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
	private Boolean createRandomBee(Integer patchSize2) {
		if (this.randomSearchCreator != null) {
			ICreateBee icb = null;
			if (randomSearchCreator instanceof CreateBeeWithDFS) {
				icb = new CreateBeeWithDFS();
			}
			if (randomSearchCreator instanceof CreateBeeWithHillClimbing) {
				icb = new CreateBeeWithHillClimbing();
			}
			Patch p = new Patch();
			p.initPatch(dsm.getTrajectoryInfo(), context);
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
		ExplorerThread me = null;
		while(context.getGlobalContext().getThreadPool().getPoolSize()>1){
			try {
				ExplorerThread et = null; 
				context.getGlobalContext().stopAllThreads();
//				while ( et==null){
//				
//				//System.out.println(a.isEmpty());
//				et = (ExplorerThread) context.getGlobalContext().getThreadPool().getQueue().peek();
//				System.out.println(et);
//				}
//				if (context.getExplorerThread() != et) {
//					System.out.println(context.getGlobalContext().getThreadPool().getPoolSize());
//					System.out.println(et);
//					et.stopRunning();
//				} else {
//					me = (ExplorerThread) context.getGlobalContext().getThreadPool().getQueue().poll();
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (me!=null) context.getGlobalContext().getThreadPool().getQueue().add(me);

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

	public boolean isInterrupted() {
		return interrupted;
	}

	public void setInterrupted(boolean interrupted) {
		this.interrupted = interrupted;
	}

	public ArrayList<Patch> getBestpatches() {
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

	public ICreateBee getRandomBeeCreator() {
		return randomSearchCreator;
	}

	public void setRandomBeeCreator(ICreateBee randomBeeCreator) {
		this.randomSearchCreator = randomBeeCreator;
	}

	public ICreateBee getNeighbourBeeCreator() {
		return localSearchCreator;
	}

	public void setNeighbourBeeCreator(ICreateBee neighbourBeeCreator) {
		this.localSearchCreator = neighbourBeeCreator;
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
					this.createNeighbourhoodBee(this.bestpatches.get(i), radiusOfPatch);
				}
			}
			for (int i = 0; i < bestSitesNum; i++) {

			}
			// this.selectBestBeeInPatch(bestpatches.get(i));
			// Integer remainingBeesNum = numberOfMaxBees - numberOfActiveBees;
			// for (int i = 0; i < remainingBeesNum; i++) {
			// Patch randomBee = createRandomBee(patchSize);
			// if (isSolution(randomBee) == true) {
			// return;
			// }
			// this.patches.add(randomBee);
			// }
		}

	}

}
