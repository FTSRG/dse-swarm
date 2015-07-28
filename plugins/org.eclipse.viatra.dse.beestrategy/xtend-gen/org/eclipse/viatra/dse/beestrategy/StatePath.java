package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.beestrategy.ExploredByBee;
import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class StatePath extends ExploredByBee {
  private final String stateCode;
  
  private final double fittness;
  
  private final int steps;
  
  public StatePath(final ICreateBee explorer, final String stateCode, final double fittness, final int steps) {
    super(explorer);
    this.stateCode = stateCode;
    this.fittness = fittness;
    this.steps = steps;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.stateCode== null) ? 0 : this.stateCode.hashCode());
    result = prime * result + (int) (Double.doubleToLongBits(this.fittness) ^ (Double.doubleToLongBits(this.fittness) >>> 32));
    result = prime * result + this.steps;
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
    StatePath other = (StatePath) obj;
    if (this.stateCode == null) {
      if (other.stateCode != null)
        return false;
    } else if (!this.stateCode.equals(other.stateCode))
      return false;
    if (Double.doubleToLongBits(other.fittness) != Double.doubleToLongBits(this.fittness))
      return false; 
    if (other.steps != this.steps)
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
  public String getStateCode() {
    return this.stateCode;
  }
  
  @Pure
  public double getFittness() {
    return this.fittness;
  }
  
  @Pure
  public int getSteps() {
    return this.steps;
  }
}
