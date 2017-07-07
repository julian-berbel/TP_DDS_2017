package modelo.method.criteria;

import java.util.List;
import java.util.stream.Collectors;

import modelo.enterprise.Enterprise;

public abstract class FilterCriterion implements Criterion
{
	private String filterName;
	
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
