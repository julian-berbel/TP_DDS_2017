package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.util.List;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public abstract class IndicatorAverageCompareCriterion extends IndicatorStatisticCompareCriterion
{
	public IndicatorAverageCompareCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years);
	}
	
	public boolean criterion(Enterprise enterprise) 
	{
		List<BigDecimal> values = enterprise.getIndicatorValueFromLastNYears(indicator, lastNYears);
		
		BigDecimal average = values.stream()
								.reduce(BigDecimal.ZERO, BigDecimal::add)
								.divide(new BigDecimal(values.size()));
		
		return compare(average.compareTo(value));
	}
}