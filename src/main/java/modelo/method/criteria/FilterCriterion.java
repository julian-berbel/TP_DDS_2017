package modelo.method.criteria;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
@Entity
@Table(name = "FilterCriteria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class FilterCriterion extends Criterion
{
	public abstract boolean test(Enterprise enterprise);
}
