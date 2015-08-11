package constraints;

import constraints.PassangerOnVechichleToTargetMatch;
import constraints.util.PassangerOnVechichleToTargetQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import onlab.Land;
import onlab.Passanger;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the constraints.PassangerOnVechichleToTarget pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PassangerOnVechichleToTargetMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern PassangerOnVechichleToTarget(P:Passanger, L:Land){
 * 	Passanger.travelOn(P, N);
 * 	Land.vehichles(L, N);
 * }
 * </pre></code>
 * 
 * @see PassangerOnVechichleToTargetMatch
 * @see PassangerOnVechichleToTargetProcessor
 * @see PassangerOnVechichleToTargetQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PassangerOnVechichleToTargetMatcher extends BaseMatcher<PassangerOnVechichleToTargetMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PassangerOnVechichleToTargetMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    PassangerOnVechichleToTargetMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new PassangerOnVechichleToTargetMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_P = 0;
  
  private final static int POSITION_L = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(PassangerOnVechichleToTargetMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public PassangerOnVechichleToTargetMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public PassangerOnVechichleToTargetMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return matches represented as a PassangerOnVechichleToTargetMatch object.
   * 
   */
  public Collection<PassangerOnVechichleToTargetMatch> getAllMatches(final Passanger pP, final Land pL) {
    return rawGetAllMatches(new Object[]{pP, pL});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return a match represented as a PassangerOnVechichleToTargetMatch object, or null if no match is found.
   * 
   */
  public PassangerOnVechichleToTargetMatch getOneArbitraryMatch(final Passanger pP, final Land pL) {
    return rawGetOneArbitraryMatch(new Object[]{pP, pL});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Passanger pP, final Land pL) {
    return rawHasMatch(new Object[]{pP, pL});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Passanger pP, final Land pL) {
    return rawCountMatches(new Object[]{pP, pL});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Passanger pP, final Land pL, final IMatchProcessor<? super PassangerOnVechichleToTargetMatch> processor) {
    rawForEachMatch(new Object[]{pP, pL}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Passanger pP, final Land pL, final IMatchProcessor<? super PassangerOnVechichleToTargetMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pP, pL}, processor);
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
  public PassangerOnVechichleToTargetMatch newMatch(final Passanger pP, final Land pL) {
    return PassangerOnVechichleToTargetMatch.newMatch(pP, pL);
  }
  
  /**
   * Retrieve the set of values that occur in matches for P.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Passanger> rawAccumulateAllValuesOfP(final Object[] parameters) {
    Set<Passanger> results = new HashSet<Passanger>();
    rawAccumulateAllValues(POSITION_P, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for P.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Passanger> getAllValuesOfP() {
    return rawAccumulateAllValuesOfP(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for P.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Passanger> getAllValuesOfP(final PassangerOnVechichleToTargetMatch partialMatch) {
    return rawAccumulateAllValuesOfP(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for P.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Passanger> getAllValuesOfP(final Land pL) {
    return rawAccumulateAllValuesOfP(new Object[]{
    null, 
    pL
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for L.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Land> rawAccumulateAllValuesOfL(final Object[] parameters) {
    Set<Land> results = new HashSet<Land>();
    rawAccumulateAllValues(POSITION_L, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for L.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Land> getAllValuesOfL() {
    return rawAccumulateAllValuesOfL(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for L.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Land> getAllValuesOfL(final PassangerOnVechichleToTargetMatch partialMatch) {
    return rawAccumulateAllValuesOfL(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for L.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Land> getAllValuesOfL(final Passanger pP) {
    return rawAccumulateAllValuesOfL(new Object[]{
    pP, 
    null
    });
  }
  
  @Override
  protected PassangerOnVechichleToTargetMatch tupleToMatch(final Tuple t) {
    try {
    	return PassangerOnVechichleToTargetMatch.newMatch((onlab.Passanger) t.get(POSITION_P), (onlab.Land) t.get(POSITION_L));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PassangerOnVechichleToTargetMatch arrayToMatch(final Object[] match) {
    try {
    	return PassangerOnVechichleToTargetMatch.newMatch((onlab.Passanger) match[POSITION_P], (onlab.Land) match[POSITION_L]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PassangerOnVechichleToTargetMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return PassangerOnVechichleToTargetMatch.newMutableMatch((onlab.Passanger) match[POSITION_P], (onlab.Land) match[POSITION_L]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<PassangerOnVechichleToTargetMatcher> querySpecification() throws IncQueryException {
    return PassangerOnVechichleToTargetQuerySpecification.instance();
  }
}
