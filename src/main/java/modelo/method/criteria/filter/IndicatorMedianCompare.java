package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.FilterCriterion;

public abstract class IndicatorMedianCompare extends FilterCriterion
{

	private int lastNYears;
	private BigDecimal value;
	Indicator indicator;

	public IndicatorMedianCompare(String name,Indicator indicator, BigDecimal value, int years) 
	{
		super(name);
		this.value=value;
		this.indicator=indicator;
		this.lastNYears = years;
	}
	
	protected abstract boolean compare(int result);

	@Override	
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