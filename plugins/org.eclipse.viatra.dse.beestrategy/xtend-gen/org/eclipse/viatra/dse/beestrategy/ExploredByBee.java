package org.eclipse.viatra.dse.beestrategy;

import org.eclipse.viatra.dse.beestrategy.createbeestrategy.ICreateBee;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public abstract class ExploredByBee {
  private final ICreateBee explorer;
  
  public ExploredByBee(final ICreateBee explorer) {
    super();
    this.explorer = explorer;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.explorer== null) ? 0 : this.explorer.hashCode());
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
    ExploredByBee other = (ExploredByBee) obj;
    if (this.explorer == null) {
      if (other.explorer != null)
        return false;
    } else if (!this.explorer.equals(other.explorer))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("explorer", this.explorer);
    return b.toString();
  }
  
  @Pure
  public ICreateBee getExplorer() {
    return this.explorer;
  }
}
