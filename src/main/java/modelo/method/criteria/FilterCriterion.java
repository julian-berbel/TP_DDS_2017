package modelo.method.criteria;

import java.util.List;
import java.util.stream.Collectors;

import modelo.enterprise.Enterprise;

public abstract class FilterCriterion implements Criterion
{	
	protected abstract boolean criterion(Enterprise enterprise);
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return enterprises.stream()
				.filter(enterprise -> criterion(enterprise))
				.collect(Collectors.toList());
	}
}
