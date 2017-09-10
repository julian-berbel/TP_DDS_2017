package modelo.method.criteria.filter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IIV")
public class IncreasingIndicatorValueCriterion extends VariatingIndicatorValueCriterion
{
	public IncreasingIndicatorValueCriterion(Indicator indicator, int years) 
	{
		super(indicator, years, ComparisonCriterion.LowerThan);
	}
	
	protected IncreasingIndicatorValueCriterion() 
	{
		this.comparisonCriterion = ComparisonCriterion.LowerThan;
	}
}