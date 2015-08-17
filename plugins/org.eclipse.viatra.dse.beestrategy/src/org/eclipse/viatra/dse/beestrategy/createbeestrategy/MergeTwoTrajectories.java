package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import org.eclipse.viatra.dse.beestrategy.BeeStrategy3;

public class MergeTwoTrajectories extends AbstractMiniStrategy{
	

	public MergeTwoTrajectories(BeeStrategy3 bs) {
		super(bs);
	}

	@Override
	public IMiniStrategy createMiniStrategy(BeeStrategy3 bs) {
		return new MergeTwoTrajectories(bs);
		
	}

	@Override
	public void explore() {
		
	}
		
}
