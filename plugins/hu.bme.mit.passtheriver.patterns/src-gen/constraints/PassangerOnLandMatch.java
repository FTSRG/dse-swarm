package constraints;

import constraints.util.PassangerOnLandQuerySpecification;
import java.util.Arrays;
import java.util.List;
import onlab.Land;
import onlab.Passanger;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the constraints.PassangerOnLand pattern,
 * to be used in conjunction with {@link PassangerOnLandMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PassangerOnLandMatcher
 * @see PassangerOnLandProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PassangerOnLandMatch extends BasePatternMatch {
  private Passanger fP;
  
  private Land fL;
  
  private static List<String> parameterNames = makeImmutableList("P", "L");
  
  private PassangerOnLandMatch(final Passanger pP, final Land pL) {
    this.fP = pP;
    this.fL = pL;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("P".equals(parameterName)) return this.fP;
    if ("L".equals(parameterName)) return this.fL;
    return null;
  }
  
  public Passanger getP() {
    return this.fP;
  }
  
  public Land getL() {
    return this.fL;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("P".equals(parameterName) ) {
    	this.fP = (onlab.Passanger) newValue;
    	return true;
    }
    if ("L".equals(parameterName) ) {
    	this.fL = (onlab.Land) newValue;
    	return true;
    }
    return false;
  }
  
  public void setP(final Passanger pP) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fP = pP;
  }
  
  public void setL(final Land pL) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fL = pL;
  }
  
  @Override
  public String patternName() {
    return "constraints.PassangerOnLand";
  }
  
  @Override
  public List<String> parameterNames() {
    return PassangerOnLandMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fP, fL};
  }
  
  @Override
  public PassangerOnLandMatch toImmutable() {
    return isMutable() ? newMatch(fP, fL) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"P\"=" + prettyPrintValue(fP) + ", ");
    
    result.append("\"L\"=" + prettyPrintValue(fL)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fP == null) ? 0 : fP.hashCode());
    result = prime * result + ((fL == null) ? 0 : fL.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PassangerOnLandMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PassangerOnLandMatch other = (PassangerOnLandMatch) obj;
    if (fP == null) {if (other.fP != null) return false;}
    else if (!fP.equals(other.fP)) return false;
    if (fL == null) {if (other.fL != null) return false;}
    else if (!fL.equals(other.fL)) return false;
    return true;
  }
  
  @Override
  public PassangerOnLandQuerySpecification specification() {
    try {
    	return PassangerOnLandQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static PassangerOnLandMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PassangerOnLandMatch newMutableMatch(final Passanger pP, final Land pL) {
    return new Mutable(pP, pL);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PassangerOnLandMatch newMatch(final Passanger pP, final Land pL) {
    return new Immutable(pP, pL);
  }
  
  private static final class Mutable extends PassangerOnLandMatch {
    Mutable(final Passanger pP, final Land pL) {
      super(pP, pL);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PassangerOnLandMatch {
    Immutable(final Passanger pP, final Land pL) {
      super(pP, pL);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
