package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public abstract class IndicatorMedianCompareCriterion extends IndicatorStatisticCompareCriterion
{
	public IndicatorMedianCompareCriterion(Indicator indicator, BigDecimal value, int years) 
	{
		super(indicator, value, years);
	}

	public boolean criterion(Enterprise enterprise) 
	{
		List<BigDecimal> values = enterprise.getPeriods().stream()
										.filter(period -> period.getYear() > (Year.now().getValue() - lastNYears))
										.map(period -> indicator.reduce(enterprise, period.getYear()))
										.sorted()
										.collect(Collectors.toList());
		
		int middle = values.size() / 2;
		BigDecimal median = values.get(middle);
		
		if(values.size() % 2 == 0)
			median = median.add(values.get(middle-1)).divide(new BigDecimal(2));
		
		return compare(median.compareTo(value));
	}
}