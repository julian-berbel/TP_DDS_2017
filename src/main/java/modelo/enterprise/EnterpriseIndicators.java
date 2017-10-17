package modelo.enterprise;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;

import modelo.indicator.IndicatorValue;

public class EnterpriseIndicators 
{

	private String name;
	List<IndicatorValue> indicators;
	
	
	

	public EnterpriseIndicators(String name,List<String> indicators,int year)
	{
		this.name=name;
		this.indicators=indicators.stream().map(indicator->new IndicatorValue(indicator,year,name)).collect(Collectors.toList());;
	}
	
	public String getName() 
	{
		return name;
	}
	public List<IndicatorValue> getIndicators() 
	{
		return indicators;
	}
}
