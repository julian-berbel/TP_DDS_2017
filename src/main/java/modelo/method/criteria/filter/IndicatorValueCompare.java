package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.FilterCriterion;

public abstract class IndicatorValueCompare extends FilterCriterion
{

	private int lastNYears;
	private BigDecimal value;
	Indicator indicator;
	
	public IndicatorValueCompare(String name, Indicator indicator, BigDecimal value, int years) 
	{
		super(name);
		this.value = value;
		this.indicator = indicator;
		this.lastNYears = years;
	}
	
	protected abstract boolean compare(int result);

	@Override
	public boolean criterion(Enterprise enterprise) 
	{
		return enterprise.getPeriods().stream()
					.filter(period -> period.getYear() > (Year.now().getValue() - lastNYears))
					.allMatch(period -> compare(indicator.reduce(enterprise, period.getYear()).compareTo(value)));
	}

}