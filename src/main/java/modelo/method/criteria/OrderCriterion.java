package modelo.method.criteria;

import java.util.Comparator;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class OrderCriterion extends Criterion implements Comparator<Enterprise>
{	
	public abstract int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise);
}
