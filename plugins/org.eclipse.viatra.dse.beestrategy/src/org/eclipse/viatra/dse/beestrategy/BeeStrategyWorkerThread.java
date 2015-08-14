package org.eclipse.viatra.dse.beestrategy;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.IState;
import org.eclipse.viatra.dse.designspace.api.ITransition;

public class BeeStrategyWorkerThread implements IStrategy {
	private Logger logger = Logger.getLogger(BeeStrategyWorkerThread.class);
	protected ThreadContext context;
	private boolean interrupted = false;
	protected volatile ConcurrentLinkedQueue<SearchData> searchablePatches;
	public volatile ConcurrentLinkedQueue<SearchData> instancesToBeChecked;

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
		while (!interrupted) {
			while (searchablePatches == null) {
				try {
					throw new Exception("not all Collections are initialized which are needed for BeeStrategy");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (searchablePatches.size() == 0) {
				try {
					waitfunction();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				// collect a searchData from searchablePatches
				do {
					entry = getNewSearch();
				} while (entry == null);

				// get the strategy, which will be runned
				IStrategy is = entry.getStrategy();
				// get the place of the patch, and go there (set context to
				// the right place)
				is.initStrategy(context);
				while (context.getDesignSpaceManager().getTrajectoryInfo().getDepthFromRoot() != 0) {
					context.getDesignSpaceManager().undoLastTransformation();
				}
				HashSet<IState> reachedStatesInTrajectory = new HashSet<IState>();
				reachedStatesInTrajectory.add(context.getDesignSpaceManager().getCurrentState());
				List<ITransition> transitions = entry.getParentTrajectory().getFullTransitionTrajectory();
				for (ITransition transition : transitions) {
					context.getDesignSpaceManager().fireActivation(transition);
					reachedStatesInTrajectory.add(context.getDesignSpaceManager().getCurrentState());
				}
				logger.debug("search from: " + context.getDesignSpaceManager().getTrajectoryInfo());
				// if it is a neighbourhoodbee, than run a neighbourhoodBee
				// from the patch
				entry.getStrategy().initStrategy(context);
				entry.getStrategy().setStatesInTrajectory(reachedStatesInTrajectory);
				entry.getStrategy().setSearchData(entry);
				entry.getStrategy().explore();
				SearchData sd = entry.getStrategy().returnResult();
				if (sd == null) {
					sd = new SearchData();
					sd.setParentTrajectory(null);
				}
				while (!setNewSearchData(sd));					

			}

		}

	}

	private synchronized void waitfunction() throws InterruptedException {
		// this.notifyAll();
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
		// this.notifyAll();
		return true;
	}

	@Override
	public void interruptStrategy() {
		this.interrupted = true;

	}

}
