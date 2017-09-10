package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.indicator.Indicator;

public class IndicatorMedianHigherThanCriterion extends IndicatorMedianCompareCriterion
{
	public IndicatorMedianHigherThanCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years, ComparisonCriterion.HigherThan);
	}
}