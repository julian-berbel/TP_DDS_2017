package modelo.method.criteria;

import java.util.Comparator;

import javax.persistence.Entity;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
@Entity
public abstract class OrderCriterion extends Criterion implements Comparator<Enterprise>
{	
	public abstract int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise);
}
