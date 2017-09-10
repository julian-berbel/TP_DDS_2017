package modelo.method.criteria.filter;

import modelo.indicator.Indicator;

public class DecreasingIndicatorValueCriterion extends VariatingIndicatorValueCriterion
{
	public DecreasingIndicatorValueCriterion(Indicator indicator, int years) 
	{
		super(indicator, years, ComparisonCriterion.HigherThan);
	}
}