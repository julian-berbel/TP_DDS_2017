package modelo;
import java.util.List;
import java.util.ArrayList;

public class IndicatorRepository 
{
	private static List<Indicator> indicators;
	
	public IndicatorRepository()
	{
		indicators = new ArrayList<Indicator>();
	}
	
	public static void addIndicator(Indicator ent)
	{
		indicators.add(ent);
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
				.filter(indicator -> indicator.getName() == name)
				.findFirst()
				.get();
	}
	
}
