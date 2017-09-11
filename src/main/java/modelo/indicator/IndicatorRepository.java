package modelo.indicator;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import exceptions.MissingIndicatorException;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;

import java.util.ArrayList;

public class IndicatorRepository implements WithGlobalEntityManager
{
	private static IndicatorRepository instance;
	private List<Indicator> indicators = new ArrayList<Indicator>();
	
	private IndicatorRepository(){}
	
	public static IndicatorRepository getInstance(){
		if(instance==null) instance = new IndicatorRepository();
		return instance;
	}
	
	public void addIndicator(Indicator indicator)
	{
		indicators.add(indicator);
	}
		
	public List<Indicator> getIndicatorList()
	{
		return indicators;
	}
	
	public void setIndicatorList(List<Indicator> _indicators)
	{
		indicators = _indicators;
	}

	public Indicator getIndicator(String name)
	{
		return indicators.stream()
				.filter(indicator -> indicator.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new MissingIndicatorException(name));
	}
	
	public Boolean alreadyExists(String newIndicatorName)
	{
		 return indicators.stream()
			.map(indicator -> indicator.getName())
			.anyMatch(indicatorName->indicatorName.equals(newIndicatorName));
	}
	
	public void replace(Indicator oldIndicator, Indicator newIndicator)
	{
		indicators.replaceAll(indicator -> indicator == oldIndicator ? newIndicator:indicator);
	}
	
	public Boolean anyUses(Indicator indicator)
	{
		return indicators.stream().anyMatch(_indicator -> _indicator.uses(indicator));
	}
	
	public List<Indicator> getAvailableIndicatorForPeriodList(Enterprise enterprise,Period period)
	{
		return indicators.stream()
				.filter(indicator -> indicator.tryReduce(enterprise, period.getYear())).collect(Collectors.toList());
				
	}
}
