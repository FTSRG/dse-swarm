package org.eclipse.viatra.dse.beestrategy;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.ITransition;

public class BeeStrategyWorkerThread implements IStrategy {
	private Logger logger = Logger.getLogger(getClass());
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
		try{
		while (!interrupted) {
			while (searchablePatches == null) {
			}
			if (searchablePatches.size() == 0) {
				//wait();
			} else {
				entry = getNewSearch();
				while(entry==null){
					entry = getNewSearch();
				}
				IStrategy is = entry.getStrategy();
				is.initStrategy(context);
				while (context.getDesignSpaceManager().getTrajectoryInfo().getDepthFromRoot() != 0) {
					context.getDesignSpaceManager().undoLastTransformation();
				}
				List<ITransition> transitions = entry.getPatch().getPatch().getFullTransitionTrajectory();
				for (ITransition transition : transitions) {
					context.getDesignSpaceManager().fireActivation(transition);
				}
				logger.debug("search from: "+context.getDesignSpaceManager().getTrajectoryInfo());

				if (entry.getIsneighbour() == true) {
					StupidBee sb = entry.getStrategy().createNeighbourBee();
					sb.setInitialState(entry.getPatch().getPatch());
					entry.setStupidBee(sb);
					setNewSearchData(entry);
					logger.debug("arrived to: "+context.getDesignSpaceManager().getTrajectoryInfo());
				} else {
					entry.getStrategy().setStopCond(entry.getPatchsize());
					Patch p = entry.getStrategy().createRandomBee();
					if (p == null){
						p = new Patch();
						p.setPatch(null, context);
					}
					while (p.getBestBee().getInitialState().getCurrentState().toString().equals(entry.getPatch().getPatch().getCurrentState().toString())){
						entry.getStrategy().setStopCond(entry.getPatchsize());
						p = entry.getStrategy().createRandomBee();
						if (p == null){
							p = new Patch();
							p.setPatch(null, context);
							break;
						}
					}
					entry.setPatch(p);
					setNewSearchData(entry);
					logger.debug("start patch at: "+context.getDesignSpaceManager().getTrajectoryInfo());
				}

			}
		}
		}catch(Exception e){
			System.out.println(entry.getStrategy().toString());
			e.printStackTrace();
		}

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
		return true;
	}

	@Override
	public void interruptStrategy() {
		this.interrupted = true;

	}

}
