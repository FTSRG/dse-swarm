package org.eclipse.viatra.dse.mainStrategy;

import org.eclipse.viatra.dse.beestrategy.SearchData;
import org.eclipse.viatra.dse.beestrategy.SearchTrajectory;
import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;

public class OnePatchStrategy implements IMainStrategy{

	
	StrategyCombiner sc;
	@Override
	public void exploreParalell() {
		try{
		sc.createRandomBee(sc.getMiniStrategyStopCondition());
		sc.increasenumberOfActiveBees();
		while(sc.getInstancesToBeChecked().isEmpty()){
			this.wia();
		}
		sc.getBackBees();	
		while(!sc.isInterrupted()){
			if(sc.getPatches().size()==0){
				sc.createRandomBee(sc.getMiniStrategyStopCondition());
			}
			else sc.createNeighbourhoodBee(sc.getPatches().get(sc.getPatches().size()-1), sc.getMiniStrategyStopCondition());
			while(sc.getInstancesToBeChecked().isEmpty()){
				this.wia();
			}
			sc.getBackBees();
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void wia(){
		try {
			this.wait(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void exploreOneThread() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initMainStrategy(StrategyCombiner sc) {
		this.sc = sc;
		
	}

	@Override
	public void SearchDataOut(SearchData sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SearchDataBack(SearchData sc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isSolution(SearchTrajectory searchTrajectory) {
		// TODO Auto-generated method stub
		
	}

}
