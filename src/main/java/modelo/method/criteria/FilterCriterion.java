package modelo.method.criteria;

import java.util.function.Function;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
public class FilterCriterion extends Criterion
{	
	protected Function<Enterprise, Boolean> criterion;
	
	public FilterCriterion(Function<Enterprise, Boolean> criterion, String description){
		super(description);
		this.criterion = criterion;
	}
	
	public Boolean isMetBy(Enterprise enterprise){
		return criterion.apply(enterprise);
	}
}
