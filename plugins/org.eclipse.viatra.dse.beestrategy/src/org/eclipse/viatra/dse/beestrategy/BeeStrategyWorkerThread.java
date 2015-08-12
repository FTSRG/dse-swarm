package org.eclipse.viatra.dse.beestrategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;

public class BeeStrategyWorkerThread implements IStrategy {
	private Logger logger = Logger.getLogger(getClass());
	protected ThreadContext context;
	private boolean interrupted = false;
	protected volatile ConcurrentLinkedQueue<SearchData> searchablePatches;
	public volatile ConcurrentLinkedQueue<SearchData> instancesToBeChecked;
	private BeeStrategy3 bs;

	public void setConcurrentCollections(ConcurrentLinkedQueue<SearchData> searchablePatches,
			ConcurrentLinkedQueue<SearchData> instancesToBeChecked) {
		this.searchablePatches = searchablePatches;
		this.instancesToBeChecked = instancesToBeChecked;
	}

	@Override
	public void initStrategy(ThreadContext context) {
		this.context = context;

	}

	@Override
	public void explore() {
		SearchData entry = null;
		try {
			while (!interrupted) {
				while (searchablePatches == null) {
					throw new Exception("not all Collections are initialized which are needed for BeeStrategy");
				}
				if (searchablePatches.size() == 0) {
					waitfunction();
				} else {
					// collect a searchData from searchablePatches
					entry = getNewSearch();
					while (entry == null) {
						entry = getNewSearch();
					}
					// get the strategy, which will be runned
					IStrategy is = entry.getStrategy();
					// get the place of the patch, and go there (set context to
					// the right place)
					is.initStrategy(context);
					while (context.getDesignSpaceManager().getTrajectoryInfo().getDepthFromRoot() != 0) {
						context.getDesignSpaceManager().undoLastTransformation();
					}
					HashSet<IState> initialTrajectory = new HashSet<IState>();
					initialTrajectory.add(context.getDesignSpaceManager().getCurrentState());
					List<ITransition> transitions = entry.getParentTrajectory().getFullTransitionTrajectory();
					for (ITransition transition : transitions) {
						context.getDesignSpaceManager().fireActivation(transition);
						initialTrajectory.add(context.getDesignSpaceManager().getCurrentState());
					}
					logger.debug("search from: " + context.getDesignSpaceManager().getTrajectoryInfo());
					// if it is a neighbourhoodbee, than run a neighbourhoodBee
					// from the patch
					
					entry.getStrategy().setStatesInTrajectory(initialTrajectory);
					entry.getStrategy().setSearchData(entry);
					SearchData sd = entry.getStrategy().createBee();
					if (sd == null) {
						sd = new SearchData();
						sd.setParentTrajectory(null);
					}
					setNewSearchData(sd);
					logger.debug("arrived to: " + context.getDesignSpaceManager().getTrajectoryInfo());
					
				}

			}

		} catch (Exception e) {
			System.out.println(entry.getStrategy().toString());
			e.printStackTrace();
		}

	}

	private synchronized void waitfunction() throws InterruptedException {
		this.notifyAll();
		// this.wait(5000);

	}

	private synchronized SearchData getNewSearch() {
		SearchData entry = searchablePatches.poll();
		return entry;

	}

	private synchronized boolean setNewSearchData(SearchData sd) {
		int i = 10;
		while (!this.instancesToBeChecked.add(sd)) {
			try {
				this.wait(i);
				i *= 2;
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
		}
		//bs.increasenumberOfActiveBees();
		// this.notifyAll();
		return true;
	}

	@Override
	public void interruptStrategy() {
		this.interrupted = true;
		System.out.println("stopped");

	}

}
