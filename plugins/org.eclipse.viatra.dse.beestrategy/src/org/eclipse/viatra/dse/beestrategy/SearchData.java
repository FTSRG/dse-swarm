package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.api.strategy.interfaces.IStrategy;

public class SearchData {
	private Patch patch;
	private IStrategy strategy;
	private Integer patchsize;
	private Boolean isneighbour;

	public IStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}

	public Patch getPatch() {
		return patch;
	}

	public void setPatch(Patch patch) {
		this.patch = patch;
	}

	public Integer getPatchsize() {
		return patchsize;
	}

	public void setPatchsize(Integer patchsize) {
		this.patchsize = patchsize;
	}

	public Boolean getIsneighbour() {
		return isneighbour;
	}

	public void setIsneighbour(Boolean isneighbour) {
		this.isneighbour = isneighbour;
	}
}
