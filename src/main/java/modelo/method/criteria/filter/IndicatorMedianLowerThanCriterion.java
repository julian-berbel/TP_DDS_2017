package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.indicator.Indicator;

public class IndicatorMedianLowerThanCriterion extends IndicatorMedianCompareCriterion
{
	public IndicatorMedianLowerThanCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years, ComparisonCriterion.LowerThan);
	}
}