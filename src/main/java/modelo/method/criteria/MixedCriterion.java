package modelo.method.criteria;

import java.util.List;

import modelo.enterprise.Enterprise;

public abstract class MixedCriterion implements Criterion
{
	protected OrderCriterion orderCriterion;
	protected FilterCriterion filterCriterion;
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return orderCriterion.apply(filterCriterion.apply(enterprises));
	}
}
