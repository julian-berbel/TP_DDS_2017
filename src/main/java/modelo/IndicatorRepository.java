package modelo;
import java.util.List;

import exceptions.MissingIndicatorException;

import java.util.ArrayList;

public class IndicatorRepository 
{
	private static List<Indicator> indicators;
	private static List<Indicator> newIndicators;
	
	public IndicatorRepository()
	{
		indicators = new ArrayList<Indicator>();
		newIndicators = new ArrayList<Indicator>();
	}	
	
	public static List<Indicator> getNewIndicators() 
	{
		return newIndicators;
	}

	public static void setNewIndicators(List<Indicator> newIndicators) 
	{
		IndicatorRepository.newIndicators = newIndicators;
	}

	
	public static void addIndicator(Indicator indicator)
	{
		indicators.add(indicator);
	}
	
	public static void addNewIndicator(Indicator indicator)
	{
		newIndicators.add(indicator);
	}
	
	public static List<Indicator> getIndicatorList()
	{
		return indicators;
	}
	
	public static void setIndicatorList(List<Indicator> _indicators)
	{
		indicators = _indicators;
	}
	

	public static Indicator getIndicator(String name){
		return indicators.stream()
				.filter(indicator -> indicator.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new MissingIndicatorException(name));
	}
	
}
