package modelo.method.criteria;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class FilterCriterion extends Criterion
{
	public abstract boolean test(Enterprise enterprise);
}
