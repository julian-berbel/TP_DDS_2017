package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.util.List;

import modelo.indicator.Indicator;

public abstract class IndicatorValueCompareCriterion extends IndicatorStatisticCompareCriterion
{	
	public IndicatorValueCompareCriterion(Indicator indicator, BigDecimal value, int years, ComparisonCriterion comparisonCriterion) 
	{
		super(indicator, value, years, comparisonCriterion);
	}

	protected boolean test(List<BigDecimal> values) 
	{
		return values.stream()
					.allMatch(_value -> compare(_value.compareTo(value)));
	}

	public String buildDescription() {
		return buildDescription("Valor");
	}

}