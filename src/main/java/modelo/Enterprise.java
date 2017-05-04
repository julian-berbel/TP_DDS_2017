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
		
		for(int index=0; index<(periods.size()); index++)
		{
			enterprisePeriodsNameList.add(periods.get(index).getPeriodName());
		}
		return enterprisePeriodsNameList;
	}
	
	public List<Calculation> getPeriodCalculations(String periodName)
	{
		int i=0;
		
		for(; i < (periods.size() - 1); i++) //con ese '-1' ****magico**** no tira errores, pero algunas cuentas no las toma como deberia
		{
			if(periods.get(i).getPeriodName() == periodName)
				break;
		}
		
		return periods.get(i).getCalculations();		 
	}
	
}
