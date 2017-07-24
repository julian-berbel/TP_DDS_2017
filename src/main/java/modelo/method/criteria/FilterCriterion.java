package modelo.method.criteria;

import java.util.function.Predicate;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
public class FilterCriterion extends Criterion
{	
	protected Predicate<Enterprise> criterion;
	
	public FilterCriterion(Predicate<Enterprise> criterion, String description){
		super(description);
		this.criterion = criterion;
	}
	
	public Predicate<Enterprise> getCriterion() {
		return criterion;
	}
	
	public Boolean test(Enterprise enterprise){
		return criterion.test(enterprise);
	}
}
