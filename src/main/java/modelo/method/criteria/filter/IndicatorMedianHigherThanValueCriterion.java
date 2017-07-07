package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.indicator.Indicator;

public class IndicatorMedianHigherThanValueCriterion extends IndicatorMedianCompareCriterion
{
	public IndicatorMedianHigherThanValueCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years);
	}
	
	protected boolean compare(int result){
		return result > 0;
	}
}