package modelo.enterprise;

import java.math.BigDecimal;
import java.time.Year;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import modelo.indicator.Indicator;

@Observable
public class Enterprise 
{
	private String name;
	private List<Period> periods;
	
	public Enterprise(String name, List<Period> periods)
	{
		this.name = name;
		this.periods = periods;
	}
	
	public List<Period> getPeriods()
	{
		return periods;
	}
	
	public List<BigDecimal> getIndicatorValueFromLastNYears(Indicator indicator, int n){
		return periods.stream()
				.filter(period -> period.getYear() > (Year.now().getValue() - n))
				.map(period -> indicator.reduce(this, period.getYear()))
				.collect(Collectors.toList());
	}
	
	public String getName()
	{
		return name;
	}
	
	public Calculation getCalculationOnYear(String name, int year){
		return periods.stream()
				.filter(period -> period.getYear() == year)
				.findFirst()
				.get()
				.getCalculation(name);
	}
	
	public int age(){
		return Year.now().getValue() - this.getPeriods().stream()
											.mapToInt(period -> period.getYear())
											.min()
											.getAsInt();
	}
	
	@Override
	public String toString(){
		return name;
	}
}
