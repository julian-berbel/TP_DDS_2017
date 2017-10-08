package modelo.method.criteria;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import modelo.enterprise.Enterprise;

@Entity
@Table(name = "FilterCriteria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class FilterCriterion extends Criterion
{
	public abstract boolean test(Enterprise enterprise);
}
