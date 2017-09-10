package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IVL")
public class IndicatorValueLowerThanCriterion extends IndicatorValueCompareCriterion
{
	public IndicatorValueLowerThanCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years, ComparisonCriterion.LowerThan);
	}
	
	protected IndicatorValueLowerThanCriterion() 
	{
		this.comparisonCriterion = ComparisonCriterion.LowerThan;
	}
}