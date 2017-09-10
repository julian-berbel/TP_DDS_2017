package modelo.method.criteria.filter;

import java.math.BigDecimal;

import modelo.indicator.Indicator;

public abstract class IndicatorStatisticCompareCriterion extends IndicatorRelatedCriterion{
	protected BigDecimal value;
	
	public IndicatorStatisticCompareCriterion(Indicator indicator, BigDecimal value, int years, ComparisonCriterion comparisonCriterion) 
	{
		super(indicator, years, comparisonCriterion);
		this.value = value;
	}
	
	protected IndicatorStatisticCompareCriterion(){}

	public String buildDescription(String statisticType) {
		return super.buildDescription(statisticType + " del indicador " + indicator.getName() + comparisonCriterion.getComparisonType() + value.toString());
	}
}
