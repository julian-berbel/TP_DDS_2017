package modelo;

import java.util.ArrayList;
import java.util.List;

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
	
	
}
