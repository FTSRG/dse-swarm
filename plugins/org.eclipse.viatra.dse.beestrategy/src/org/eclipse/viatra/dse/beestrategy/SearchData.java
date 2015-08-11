package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;

public class SearchData {
	
	private Patch patch;
	private ICreateBee strategy;
	private Integer patchSize;
	private Boolean isNeighbour;
	private StupidBee sb;

	public StupidBee getStupidBee() {
		return sb;
	}

	public void setStupidBee(StupidBee sb) {
		this.sb = sb;
	}

	public ICreateBee getStrategy() {
		return strategy;
	}

	public void setStrategy(ICreateBee strategy) {
		this.strategy = strategy;
	}

	public Patch getPatch() {
		return patch;
	}

	public void setPatch(Patch patch) {
		this.patch = patch;
	}

	public Integer getPatchsize() {
		return patchSize;
	}

	public void setPatchsize(Integer patchsize) {
		this.patchSize = patchsize;
	}

	public Boolean getHasParent() {
		return isNeighbour;
	}

	public void setIsneighbour(Boolean isneighbour) {
		this.isNeighbour = isneighbour;
	}
}
