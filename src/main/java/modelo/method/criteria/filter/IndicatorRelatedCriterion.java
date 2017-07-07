
package modelo.method.criteria.filter;

import modelo.indicator.Indicator;
import modelo.method.criteria.FilterCriterion;

public abstract class IndicatorRelatedCriterion extends FilterCriterion
{
	protected int lastNYears;
	Indicator indicator;

	public IndicatorRelatedCriterion(Indicator indicator, int years) 
	{
		super();
		this.indicator = indicator;
		this.lastNYears = years;
	}
	
	protected abstract boolean compare(int result);
}