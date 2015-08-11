package constraints.util;

import com.google.common.collect.Sets;
import constraints.PassangerOnLandMatch;
import constraints.PassangerOnLandMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate PassangerOnLandMatcher in a type-safe way.
 * 
 * @see PassangerOnLandMatcher
 * @see PassangerOnLandMatch
 * 
 */
@SuppressWarnings("all")
public final class PassangerOnLandQuerySpecification extends BaseGeneratedEMFQuerySpecification<PassangerOnLandMatcher> {
  private PassangerOnLandQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PassangerOnLandQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PassangerOnLandMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PassangerOnLandMatcher.on(engine);
  }
  
  @Override
  public PassangerOnLandMatch newEmptyMatch() {
    return PassangerOnLandMatch.newEmptyMatch();
  }
  
  @Override
  public PassangerOnLandMatch newMatch(final Object... parameters) {
    return PassangerOnLandMatch.newMatch((onlab.Passanger) parameters[0], (onlab.Land) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static PassangerOnLandQuerySpecification INSTANCE = make();
    
    public static PassangerOnLandQuerySpecification make() {
      return new PassangerOnLandQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PassangerOnLandQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "constraints.PassangerOnLand";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("P","L");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("P", "onlab.Passanger"),new PParameter("L", "onlab.Land"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_P = body.getOrCreateVariableByName("P");
      	PVariable var_L = body.getOrCreateVariableByName("L");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_P, "P"),
      				
      		new ExportedParameter(body, var_L, "L")
      	));
      	new TypeConstraint(body, new FlatTuple(var_P), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Passanger")));
      	new TypeConstraint(body, new FlatTuple(var_L), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Land")));
      	new TypeConstraint(body, new FlatTuple(var_P), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Passanger")));
      	new TypeConstraint(body, new FlatTuple(var_P, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("hu.bme.mdsd.onlab", "Passanger", "target")));
      	new Equality(body, var__virtual_0_, var_L);
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
