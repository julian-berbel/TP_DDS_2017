package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public abstract class IndicatorStatisticCompareCriterion extends IndicatorRelatedCriterion{
	protected BigDecimal value;
	
	public IndicatorStatisticCompareCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, years);
		this.value = value;
	}
	
	protected abstract boolean criterion(Enterprise enterprise);
}
