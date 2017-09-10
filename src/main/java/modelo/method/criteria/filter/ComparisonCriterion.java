package modelo.method.criteria.filter;

import java.util.function.Predicate;

public class ComparisonCriterion
{
	private String comparisonType;
	private String variationType;
	private Predicate<Integer> comparisonCriterion;
	
	private ComparisonCriterion(String comparisonType, String variationType, Predicate<Integer> comparisonCriterion){
		this.comparisonType = comparisonType;
		this.variationType = variationType;
		this.comparisonCriterion = comparisonCriterion;
	}
	
	public static final ComparisonCriterion HigherThan = new ComparisonCriterion(" mayor a ", " decreciente", result -> result > 0);
	public static final ComparisonCriterion LowerThan = new ComparisonCriterion(" menor a ", " creciente", result -> result < 0);
	
	public String getComparisonType(){
		return comparisonType;
	}
	
	public String getVariationType(){
		return variationType;
	}
	
	public boolean test(Integer result){
		return comparisonCriterion.test(result);
	}
}