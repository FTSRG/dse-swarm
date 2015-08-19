package org.eclipse.viatra.dse.mainStrategy;

import java.util.ArrayList;

import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;
import org.eclipse.viatra.dse.stopConditions.IStopCondition;

public class BeeStrategy implements MainStrategy{
	StrategyCombiner sc;
	
	public void initMainStrategy(StrategyCombiner sc){
		this.sc = sc;
	}
	
	
	public void exploreParalell(){
		// number of bestpatches is set at the creation of the strategy
				sc.setBestpatches(new ArrayList<SearchTrajectory>());
				// here we create random pathces in the exploration space with the help
				// of the workerthreads
				for (int i = 0; i < sc.getNumberOfMaxBees(); i++) {
					IStopCondition cond = sc.getMiniStrategyStopCondition().createNew(sc.getRadiusOfRandomSearch() * sc.getIterations());
					if (!sc.createRandomBee(cond)) {
						System.out.println("exploreown2 :(");
						return;
					}
				}
				// we wait till we get back the solution from workerthreads
				while (sc.getNumberOfActiveBees() >= 1 && sc.isInterrupted() != true) {
					sc.getBackBees();
				}
				// collect the bests from patches (sc.getsitesnum can be set by the user at
				// the beginning of the strategy), a better patch has a better best bee,
				// the other bees does not count
				if (sc.isInterrupted() == true)
					return;
				sc.getBestPatches(sc.getSitesnum());
				while (sc.isInterrupted() != true) {
					sc.setIterations(sc.getIterations()+1);
					System.out.println(sc.isInterrupted());
					// select best patches, a better patch has a better best bee, the
					// other bees does not count
					sc.setBestpatches(sc.getBestPatches(sc.getSitesnum()));

					// create neighbourhoodbees from the best patches (elitepatches have
					// more bees than others)
					int length;
					if (sc.getBestSitesNum() < sc.getBestpatches().size())
						length = sc.getBestSitesNum();
					else
						length = sc.getBestpatches().size();
					for (int i = 0; i < length; i++) {
						Integer RecruitedBeesNum = 0;
						if (i < sc.getEliteSitesNum())
							RecruitedBeesNum = sc.getEliteBeesNum();
						else
							RecruitedBeesNum = sc.getOtherBeesNum();
						for (int j = 0; j < RecruitedBeesNum; j++) {
							try {
								IStopCondition cond = sc.getMiniStrategyStopCondition().createNew(sc.getRadiusOfRandomSearch());
								sc.createNeighbourhoodBee(sc.getBestpatches().get(i), cond);
							} catch (Exception e) {
								sc.getLogger().debug(e);
								String s = sc.getBestpatches() + " " + sc.getBestpatches().size() + " " + sc.getRadiusOfRandomSearch() + " " + length
										+ " " + RecruitedBeesNum + " " + i;
								sc.getLogger().debug(s);
							}
							sc.getBestpatches().get(i).setHasChild(true);
						}
					}

					// remaingingBeesNum must be bigger than 0
					Integer remainingBeesNum = sc.getNumberOfMaxBees() - sc.getNumberOfActiveBees();
					for (int i = 0; i < remainingBeesNum; i++) {
						// the deepness of new patches should be as high as the other
						// deepness
						IStopCondition cond = sc.getMiniStrategyStopCondition().createNew(sc.getRadiusOfRandomSearch() * sc.getIterations());
						sc.createRandomBee(cond);
					}
					while (sc.getNumberOfActiveBees() >= 1) {
						if (sc.isInterrupted() == true)
							return;
						sc.getBackBees();
					}

				}
	}


	@Override
	public void exploreOneThread() {
		// TODO Auto-generated method stub
		
	}

}
