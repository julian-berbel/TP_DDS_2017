package modelo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class FilterCriterion 
{
	String filterName;
	
	public FilterCriterion(String name)
	{
		filterName = name;
	}
	
	public String getName()
	{
		return filterName;
	}
	
	public abstract boolean criterion(Enterprise enterprise);
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return enterprises.stream()
				.filter(enterprise -> criterion(enterprise))
				.collect(Collectors.toList());
	}
}
