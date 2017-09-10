package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.util.List;

import modelo.indicator.Indicator;

public abstract class IndicatorAverageCompareCriterion extends IndicatorStatisticCompareCriterion
{
	public IndicatorAverageCompareCriterion(Indicator indicator, BigDecimal value, int years, ComparisonCriterion comparisonCriterion) 
	{
		super(indicator, value, years, comparisonCriterion);
	}
	
	protected IndicatorAverageCompareCriterion() {}
	
	protected boolean test(List<BigDecimal> values) 
	{		
		BigDecimal average = values.stream()
								.reduce(BigDecimal.ZERO, BigDecimal::add)
								.divide(new BigDecimal(values.size()));
		
		return compare(average.compareTo(value));
	}
	
	protected String buildDescription() {
		return buildDescription("Promedio");
	}
}