package modelo.method.criteria;

import java.util.Comparator;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
public abstract class OrderCriterion extends Criterion implements Comparator<Enterprise>
{	
	public abstract int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise);

	public OrderCriterion(String description){
		super(description);
	}
}
