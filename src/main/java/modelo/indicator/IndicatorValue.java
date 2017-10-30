package modelo.indicator;

import modelo.enterprise.EnterpriseRepository;

public class IndicatorValue {

	private String name;	
	private String value;
	
	public IndicatorValue(String name,int year,String enterpriseName) 
	{		
		this.name = name;		
		try
		{
			value = IndicatorRepository.getInstance().getByName(name).reduce(EnterpriseRepository.getInstance().getByName(enterpriseName), year).toString();
		}
		catch(Exception e)
		{
			value = "Indicador no disponible";
		}
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getValue() 
	{
		return value;
	}
	
}
