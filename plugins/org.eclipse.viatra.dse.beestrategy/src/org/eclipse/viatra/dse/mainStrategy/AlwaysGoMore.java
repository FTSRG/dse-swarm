package org.eclipse.viatra.dse.mainStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ShortenTrajectory;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.StepBackMiniStrategy;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;

public class AlwaysGoMore implements IMainStrategy {

	private StrategyCombiner sc;
	HashMap<TrajectoryInfo, SearchData> hasNoValidChild = new HashMap<TrajectoryInfo, SearchData>();

	@Override
	public void exploreOneThread() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initMainStrategy(StrategyCombiner sc) {
		this.sc = sc;

	}

	@Override
	public void exploreParalell() {
		sc.createRandomBee(sc.getMiniStrategyStopCondition());
		sc.increasenumberOfActiveBees();
		while (sc.getInstancesToBeChecked().isEmpty()) {
			this.wia();
		}
		sc.getBackBees();
		while (!sc.isInterrupted()) {
			if (sc.getPatches().size() == 0) {
				sc.createRandomBee(sc.getMiniStrategyStopCondition());
			} else
				sc.createNeighbourhoodBee(sc.getPatches().get(sc.getPatches().size() - 1),
						sc.getMiniStrategyStopCondition());
			while (sc.getInstancesToBeChecked().isEmpty()) {
				this.wia();
			}
			sc.getBackBees();
			//this.reduceFoundPlaces();

		}

	}

	private void reduceFoundPlaces() {
		try {
			if (this.hasNoValidChild.size() != 0) {
				HashMap<TrajectoryInfo, SearchData> hm = (HashMap<TrajectoryInfo, SearchData>) hasNoValidChild.clone();
				hasNoValidChild = new HashMap<TrajectoryInfo, SearchData>();
				Iterator<Entry<TrajectoryInfo, SearchData>> it = hm.entrySet().iterator();
				while (it.hasNext()) {
					Entry<TrajectoryInfo, SearchData> data = it.next();
					sc.createNeighbourhoodBee(new StepBackMiniStrategy(sc), data.getValue().getTrajectories().get(0),
							sc.getMiniStrategyStopCondition());
					it.remove();

				}
				while (sc.getInstancesToBeChecked().isEmpty() && sc.isInterrupted()==false) {
					this.wia();
				}
				sc.getBackBees();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void wia() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SearchDataOut(SearchData sc) {
		if (sc.getHasParent())
			this.hasNoValidChild.put(sc.getParentTrajectory(), sc);

	}

	@Override
	public void SearchDataBack(SearchData sc) {
		if (sc.getHasParent()!=null && sc.getHasChild()!=false)
			this.hasNoValidChild.remove(sc.getParentTrajectory());

	}

	@Override
	public void isSolution(SearchTrajectory searchTrajectory) {
		// TODO Auto-generated method stub

	}

}
