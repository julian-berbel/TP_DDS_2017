package modelo.method.criteria;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
public abstract class FilterCriterion extends Criterion
{
	public abstract boolean test(Enterprise enterprise);
}
