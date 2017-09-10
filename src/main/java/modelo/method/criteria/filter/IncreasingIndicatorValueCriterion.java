package modelo.method.criteria.filter;

import modelo.indicator.Indicator;

public class IncreasingIndicatorValueCriterion extends VariatingIndicatorValueCriterion
{
	public IncreasingIndicatorValueCriterion(Indicator indicator, int years) 
	{
		super(indicator, years, ComparisonCriterion.LowerThan);
	}
	
	protected IncreasingIndicatorValueCriterion() 
	{
		this.comparisonCriterion = ComparisonCriterion.LowerThan;
	}
}