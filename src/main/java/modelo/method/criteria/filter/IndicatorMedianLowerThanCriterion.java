package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IML")
public class IndicatorMedianLowerThanCriterion extends IndicatorMedianCompareCriterion
{
	public IndicatorMedianLowerThanCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years, ComparisonCriterion.LowerThan);
	}
	
	protected IndicatorMedianLowerThanCriterion() 
	{
		this.comparisonCriterion = ComparisonCriterion.LowerThan;
	}
}