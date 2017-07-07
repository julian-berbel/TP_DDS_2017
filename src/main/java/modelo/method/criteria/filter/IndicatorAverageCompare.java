package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.stream.Stream;

import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.method.criteria.FilterCriterion;

public abstract class IndicatorAverageCompare extends FilterCriterion
{

	private int lastNYears;
	private BigDecimal value;
	Indicator indicator;
	
	public IndicatorAverageCompare(String name, Indicator indicator, BigDecimal value, int years) 
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
		Stream<Period> periods = enterprise.getPeriods().stream();
		BigDecimal average = periods.filter(period -> period.getYear() > (Year.now().getValue() - lastNYears))
								.map(period -> indicator.reduce(enterprise, period.getYear()))
								.reduce(BigDecimal.ZERO, BigDecimal::add)
								.divide(new BigDecimal(periods.count()));
		return compare(average.compareTo(value));
	}

}