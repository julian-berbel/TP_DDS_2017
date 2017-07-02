package modelo;
import java.util.List;
import java.util.stream.Collectors;

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
		indicators = _indicators;
	}

	public static Indicator getIndicator(String name)
	{
		return indicators.stream()
				.filter(indicator -> indicator.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new MissingIndicatorException(name));
	}
	
	public static Boolean alreadyExists(String newIndicatorName)
	{
		 return indicators.stream()
			.map(indicator -> indicator.getName())
			.anyMatch(indicatorName->indicatorName.equals(newIndicatorName));
	}
	
	public static void replace(Indicator oldIndicator, Indicator newIndicator)
	{
		indicators.replaceAll(indicator -> indicator == oldIndicator ? newIndicator:indicator);
	}
	
	public static Boolean anyUses(Indicator indicator)
	{
		return indicators.stream().anyMatch(_indicator -> _indicator.uses(indicator));
	}
	
	public static List<Indicator> getAvailableIndicatorForPeriodList(Enterprise enterprise,Period period)
	{
		return indicators.stream()
				.filter(indicator -> indicator.tryReduce(enterprise, period.getYear())).collect(Collectors.toList());
				
	}
}
