package modelo.method.criteria;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import modelo.enterprise.Enterprise;

public class FilterCriterion implements Criterion
{	
	protected Function<Enterprise, Boolean> criterion;
	
	public FilterCriterion(Function<Enterprise, Boolean> criterion){
		this.criterion = criterion;
	}
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return enterprises.stream()
				.filter(enterprise -> criterion.apply(enterprise))
				.collect(Collectors.toList());
	}
}
