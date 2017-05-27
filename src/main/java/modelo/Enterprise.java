package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Enterprise 
{
	private String enterpriseName;
	private List<Period> periods;
	
	public Enterprise()
	{
		periods = new ArrayList<Period>();
	}
	
	public void addPeriod(Period p)
	{
		this.periods.add(p);
	}
	
	public List<Period> getPeriods()
	{
		return periods;
	}
	
	public void setEnterpriseName(String name)
	{
		this.enterpriseName = name;
	}
	
	public String getEnterpriseName()
	{
		return enterpriseName;
	}
	
	public List<Integer> getPeriodsYears()
	{
		return periods.stream().map(period -> period.getYear()).collect(Collectors.toList());
	}
	
	public List<Calculation> getPeriodCalculations(int year)
	{
		Period searchedPeriod = periods.stream().filter(period -> period.getYear() == year).findFirst().get();
		return searchedPeriod.getCalculations();		 
	}
	
	public List<String> getPeriodsCalculationsName()
	{
		return this.getPeriods().stream().map(period->period.getCalculationsNames())
		        .flatMap(List::stream)
		        .collect(Collectors.toList());	
	}
	
	public Calculation getCalculationOnYear(String name, int year){
		return periods.stream()
				.filter(period -> period.getYear() == year)
				.findFirst()
				.get()
				.getCalculation(name);
	}
	
	@Override
	public String toString(){
		return enterpriseName;
	}
}
