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
	
	public List<String> getPeriodsNames()
	{
		return periods.stream().map(Period::getPeriodName).collect(Collectors.toList());
	}
	
	public List<Calculation> getPeriodCalculations(String periodName)
	{
		Period searchedPeriod = periods.stream().filter(period -> period.getPeriodName().equals(periodName) ).findFirst().get();
		return searchedPeriod.getCalculations();		 
	}
	
	public List<String> getPeriodsCalculationsName()
	{
		return this.getPeriods().stream().map(period->period.getCalculationsName())
		        .flatMap(List::stream)
		        .collect(Collectors.toList());
			
				
	}
	
}
