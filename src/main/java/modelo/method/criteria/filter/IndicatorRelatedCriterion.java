
package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.util.List;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.FilterCriterion;

public abstract class IndicatorRelatedCriterion extends FilterCriterion
{
	protected int lastNYears;
	Indicator indicator;
	protected ComparisonCriterion comparisonCriterion;

	public IndicatorRelatedCriterion(Indicator indicator, int years, ComparisonCriterion comparisonCriterion) 
	{
		this.indicator = indicator;
		this.lastNYears = years;
		this.comparisonCriterion = comparisonCriterion;
	}
	
	protected IndicatorRelatedCriterion(){}
	
	public boolean test(Enterprise enterprise){
		return test(enterprise.getIndicatorValueFromLastNYears(indicator, lastNYears));
	}
	
	protected abstract boolean test(List<BigDecimal> values);
	
	protected boolean compare(int result){
		return comparisonCriterion.test(result);
	}

	protected String buildDescription(String prefix) {
		return prefix + " durante los ultimos " + String.valueOf(lastNYears) + " anios";
	}
}