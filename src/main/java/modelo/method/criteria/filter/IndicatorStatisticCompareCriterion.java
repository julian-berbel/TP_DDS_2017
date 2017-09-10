package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Entity;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import modelo.indicator.Indicator;

@Entity
public abstract class IndicatorStatisticCompareCriterion extends IndicatorRelatedCriterion{
	@Convert(converter = BigDecimalConverter.class)
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
