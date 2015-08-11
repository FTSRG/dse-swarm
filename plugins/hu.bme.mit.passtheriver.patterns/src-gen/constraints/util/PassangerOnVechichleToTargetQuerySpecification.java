package constraints.util;

import com.google.common.collect.Sets;
import constraints.PassangerOnVechichleToTargetMatch;
import constraints.PassangerOnVechichleToTargetMatcher;
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
 * A pattern-specific query specification that can instantiate PassangerOnVechichleToTargetMatcher in a type-safe way.
 * 
 * @see PassangerOnVechichleToTargetMatcher
 * @see PassangerOnVechichleToTargetMatch
 * 
 */
@SuppressWarnings("all")
public final class PassangerOnVechichleToTargetQuerySpecification extends BaseGeneratedEMFQuerySpecification<PassangerOnVechichleToTargetMatcher> {
  private PassangerOnVechichleToTargetQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PassangerOnVechichleToTargetQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PassangerOnVechichleToTargetMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PassangerOnVechichleToTargetMatcher.on(engine);
  }
  
  @Override
  public PassangerOnVechichleToTargetMatch newEmptyMatch() {
    return PassangerOnVechichleToTargetMatch.newEmptyMatch();
  }
  
  @Override
  public PassangerOnVechichleToTargetMatch newMatch(final Object... parameters) {
    return PassangerOnVechichleToTargetMatch.newMatch((onlab.Passanger) parameters[0], (onlab.Land) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static PassangerOnVechichleToTargetQuerySpecification INSTANCE = make();
    
    public static PassangerOnVechichleToTargetQuerySpecification make() {
      return new PassangerOnVechichleToTargetQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PassangerOnVechichleToTargetQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "constraints.PassangerOnVechichleToTarget";
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
      	PVariable var_N = body.getOrCreateVariableByName("N");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_P, "P"),
      				
      		new ExportedParameter(body, var_L, "L")
      	));
      	new TypeConstraint(body, new FlatTuple(var_P), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Passanger")));
      	new TypeConstraint(body, new FlatTuple(var_L), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Land")));
      	new TypeConstraint(body, new FlatTuple(var_P), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Passanger")));
      	new TypeConstraint(body, new FlatTuple(var_P, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("hu.bme.mdsd.onlab", "Passanger", "travelOn")));
      	new Equality(body, var__virtual_0_, var_N);
      	new TypeConstraint(body, new FlatTuple(var_L), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("hu.bme.mdsd.onlab", "Land")));
      	new TypeConstraint(body, new FlatTuple(var_L, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("hu.bme.mdsd.onlab", "Land", "vehichles")));
      	new Equality(body, var__virtual_1_, var_N);
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
