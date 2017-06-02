package modelo;
import java.util.List;

import exceptions.MissingIndicatorException;

import java.util.ArrayList;

public class IndicatorRepository 
{
	private static List<Indicator> indicators;
		
	public IndicatorRepository()
	{
		indicators = new ArrayList<Indicator>();		
	}	
		
	public static void addIndicator(Indicator indicator)
	{
		indicators.add(indicator);
	}
		
	public static List<Indicator> getIndicatorList()
	{
		return indicators;
	}
	
	public static void setIndicatorList(List<Indicator> _indicators)
	{
		if(indicators.size()== 0)
		{	
			indicators = _indicators;
		}else
		{
			indicators.addAll(_indicators);
		}
	}
	

	public static Indicator getIndicator(String name){
		
		return indicators.stream()
				.filter(indicator -> indicator.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new MissingIndicatorException(name));
	}
	
	public static Boolean repeatedIndicator(String newIndicatorName)
	{
		 return indicators.stream()
			.map(indicator -> indicator.getName())
			.anyMatch(indicatorName->indicatorName.equals(newIndicatorName));
	}
	
}
