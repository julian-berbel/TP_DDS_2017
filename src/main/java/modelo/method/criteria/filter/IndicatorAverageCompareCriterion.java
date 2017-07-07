package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;

public abstract class IndicatorAverageCompareCriterion extends IndicatorStatisticCompareCriterion
{
	public IndicatorAverageCompareCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years);
	}
	
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