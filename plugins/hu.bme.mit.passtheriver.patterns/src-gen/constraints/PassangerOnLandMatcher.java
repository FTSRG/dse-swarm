package constraints;

import constraints.PassangerOnLandMatch;
import constraints.util.PassangerOnLandQuerySpecification;
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
 * Generated pattern matcher API of the constraints.PassangerOnLand pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PassangerOnLandMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern PassangerOnLand(P:Passanger, L: Land){
 * 	Passanger.target(P,L);	
 * }
 * </pre></code>
 * 
 * @see PassangerOnLandMatch
 * @see PassangerOnLandProcessor
 * @see PassangerOnLandQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PassangerOnLandMatcher extends BaseMatcher<PassangerOnLandMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PassangerOnLandMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    PassangerOnLandMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new PassangerOnLandMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_P = 0;
  
  private final static int POSITION_L = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(PassangerOnLandMatcher.class);
  
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
  public PassangerOnLandMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public PassangerOnLandMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return matches represented as a PassangerOnLandMatch object.
   * 
   */
  public Collection<PassangerOnLandMatch> getAllMatches(final Passanger pP, final Land pL) {
    return rawGetAllMatches(new Object[]{pP, pL});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pP the fixed value of pattern parameter P, or null if not bound.
   * @param pL the fixed value of pattern parameter L, or null if not bound.
   * @return a match represented as a PassangerOnLandMatch object, or null if no match is found.
   * 
   */
  public PassangerOnLandMatch getOneArbitraryMatch(final Passanger pP, final Land pL) {
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
  public void forEachMatch(final Passanger pP, final Land pL, final IMatchProcessor<? super PassangerOnLandMatch> processor) {
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
  public boolean forOneArbitraryMatch(final Passanger pP, final Land pL, final IMatchProcessor<? super PassangerOnLandMatch> processor) {
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
  public PassangerOnLandMatch newMatch(final Passanger pP, final Land pL) {
    return PassangerOnLandMatch.newMatch(pP, pL);
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
  public Set<Passanger> getAllValuesOfP(final PassangerOnLandMatch partialMatch) {
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
  public Set<Land> getAllValuesOfL(final PassangerOnLandMatch partialMatch) {
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
  protected PassangerOnLandMatch tupleToMatch(final Tuple t) {
    try {
    	return PassangerOnLandMatch.newMatch((onlab.Passanger) t.get(POSITION_P), (onlab.Land) t.get(POSITION_L));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PassangerOnLandMatch arrayToMatch(final Object[] match) {
    try {
    	return PassangerOnLandMatch.newMatch((onlab.Passanger) match[POSITION_P], (onlab.Land) match[POSITION_L]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PassangerOnLandMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return PassangerOnLandMatch.newMutableMatch((onlab.Passanger) match[POSITION_P], (onlab.Land) match[POSITION_L]);
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
  public static IQuerySpecification<PassangerOnLandMatcher> querySpecification() throws IncQueryException {
    return PassangerOnLandQuerySpecification.instance();
  }
}
