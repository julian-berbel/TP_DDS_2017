package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.indicator.Indicator;

public class IndicatorValueLowerThanCriterion extends IndicatorValueCompareCriterion
{
	public IndicatorValueLowerThanCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years, ComparisonCriterion.LowerThan);
	}
}