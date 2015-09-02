package org.eclipse.viatra.dse.mainStrategy;

import org.eclipse.viatra.dse.beestrategy.StrategyCombiner;

public class OnePatchStrategy implements IMainStrategy{

	
	StrategyCombiner sc;
	@Override
	public void exploreParalell() {
		sc.createRandomBee(sc.getMiniStrategyStopCondition());
		sc.increasenumberOfActiveBees();
		while(sc.getInstancesToBeChecked().isEmpty()){
			this.wia();
		}
		sc.getBackBees();	
		while(!sc.isInterrupted()){
			if(sc.getPatches().size()==0){
				sc.createRandomBee(sc.getMiniStrategyStopCondition());
				System.out.println("createRandomBee");
			}
			else sc.createNeighbourhoodBee(sc.getPatches().get(sc.getPatchSize()), sc.getMiniStrategyStopCondition());
			sc.getBackBees();
		}		
	}
	
	public synchronized void wia(){
//		try {
			//this.wait(5);
			//System.out.println("hali");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void exploreOneThread() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initMainStrategy(StrategyCombiner sc) {
		this.sc = sc;
		
	}

}
