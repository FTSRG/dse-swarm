package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.incquery.runtime.rete.traceability.TraceInfo;
import org.eclipse.viatra.dse.beestrategy.ExploredByBee;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class PathStep extends ExploredByBee {
  private final TraceInfo from;
  
  private final TraceInfo to;
  
  public PathStep(final ICreateBee explorer, final TraceInfo from, final TraceInfo to) {
    super(explorer);
    this.from = from;
    this.to = to;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.from== null) ? 0 : this.from.hashCode());
    result = prime * result + ((this.to== null) ? 0 : this.to.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    PathStep other = (PathStep) obj;
    if (this.from == null) {
      if (other.from != null)
        return false;
    } else if (!this.from.equals(other.from))
      return false;
    if (this.to == null) {
      if (other.to != null)
        return false;
    } else if (!this.to.equals(other.to))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
  
  @Pure
  public TraceInfo getFrom() {
    return this.from;
  }
  
  @Pure
  public TraceInfo getTo() {
    return this.to;
  }
}
