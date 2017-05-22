package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IndicatorsRepository 
{
	private static List<Indicator> indicators;
	
	public IndicatorsRepository()
	{
		indicators = new ArrayList<Indicator>();
	}
	
	public static List<Indicator> getIndicators()
	{
		return indicators;
	}



	public static void setIndicators(List<Indicator> indicators)
	{
		IndicatorsRepository.indicators = indicators;
	}



	public static void addIndicator(Indicator indicator)
	{
		
		indicators.add(indicator);
	}
	
	public static List<String> getIndicatorsNameList()
	{
		 return indicators.stream().map(indicator -> indicator.getName()).collect(Collectors.toList());
	}
	
	
}
