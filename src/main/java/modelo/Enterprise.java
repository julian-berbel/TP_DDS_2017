package modelo;
import java.util.ArrayList;
import java.util.List;

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
	public List<String>  getPeriodsNames()
	{
		List<String> enterprisePeriodsNameList= new ArrayList<String>();
		for(int index=0;index<(periods.size());index++)
		{
			enterprisePeriodsNameList.add(periods.get(index).getPeriodName());
		}
		return enterprisePeriodsNameList;
	}
	
	public List<Calculation>  getPeriodCalculations(String periodName)
	{
		
		int index=0;
		while(periods.get(index).getPeriodName()!=periodName)
		{
			index++;			
		}
		return periods.get(index).getCalculations();
		 
	}
	
}
