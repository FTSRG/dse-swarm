package org.eclipse.viatra.dse.beestrategy;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.ITransition;

public class BeeStrategyWorkerThread implements IStrategy {
	protected ThreadContext context;
	private boolean interrupted = false;
	protected ConcurrentLinkedQueue<SearchData> searchablePatches;

	public void setGlobalHashmap(ConcurrentLinkedQueue<SearchData> searchablePatches) {
		this.searchablePatches = searchablePatches;
	}

	@Override
	public void initStrategy(ThreadContext context) {
		this.context = context;

	}

	@Override
	public void explore() {
		while (!interrupted) {
			if (searchablePatches.size() == 0) {
			} else {
				SearchData entry = getNewSearch();
				entry.getStrategy().initStrategy(context);
				while (context.getDesignSpaceManager().getTrajectoryInfo().getDepthFromRoot() != 0) {
					context.getDesignSpaceManager().undoLastTransformation();
				}
				List<ITransition> transitions = entry.getPatch().getPatch().getFullTransitionTrajectory();
				for (ITransition transition : transitions) {
					context.getDesignSpaceManager().fireActivation(transition);
				}
				entry.getStrategy().explore();
			}
		}

	}

	private synchronized SearchData getNewSearch() {
		SearchData entry = searchablePatches.poll();

		return entry;

	}

	@Override
	public void interruptStrategy() {
		this.interrupted = true;

	}

}
