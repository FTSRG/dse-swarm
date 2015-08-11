package constraints.util;

import constraints.PassangerOnVechichleToTargetMatch;
import onlab.Land;
import onlab.Passanger;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the constraints.PassangerOnVechichleToTarget pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PassangerOnVechichleToTargetProcessor implements IMatchProcessor<PassangerOnVechichleToTargetMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pP the value of pattern parameter P in the currently processed match
   * @param pL the value of pattern parameter L in the currently processed match
   * 
   */
  public abstract void process(final Passanger pP, final Land pL);
  
  @Override
  public void process(final PassangerOnVechichleToTargetMatch match) {
    process(match.getP(), match.getL());
  }
}
