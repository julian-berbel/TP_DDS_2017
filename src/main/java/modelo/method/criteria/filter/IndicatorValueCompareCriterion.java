package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;

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
		return enterprise.getPeriods().stream()
					.filter(period -> period.getYear() > (Year.now().getValue() - lastNYears))
					.allMatch(period -> compare(indicator.reduce(enterprise, period.getYear()).compareTo(value)));
	}

}