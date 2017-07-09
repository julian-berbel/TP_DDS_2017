package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public abstract class IndicatorValueCompareCriterion extends IndicatorStatisticCompareCriterion
{	
	public IndicatorValueCompareCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years);
	}

	public boolean criterion(Enterprise enterprise) 
	{
		return enterprise.getIndicatorValueFromLastNYears(indicator, lastNYears).stream()
					.allMatch(_value -> compare(_value.compareTo(value)));
	}

}