package org.eclipse.viatra.dse.beestrategy.createbeestrategy;

import java.util.HashSet;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;
import org.eclipse.viatra.dse.beestrategy.Patch;
import org.eclipse.viatra.dse.beestrategy.StupidBee;
import org.eclipse.viatra.dse.designspace.api.IState;

public interface ICreateBee extends IStrategy{

	public String getID();
	public Patch createRandomBee();

	public StupidBee createNeighbourBee();

	public void setPatch(Patch patch);
	public void setStopCond(Object stopcond);
	public void setIfNeighbour(Boolean neighbour);
	public void setMainStrategy(IStrategy beeStrategy);
	public void setStatesInTrajectory(HashSet<IState> states);
}
