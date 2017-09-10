package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IVH")
public class IndicatorValueHigherThanCriterion extends IndicatorValueCompareCriterion
{
	public IndicatorValueHigherThanCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years, ComparisonCriterion.HigherThan);
	}
	
	protected IndicatorValueHigherThanCriterion() 
	{
		this.comparisonCriterion = ComparisonCriterion.HigherThan;
	}
}