package modelo.method.criteria;

import java.util.Comparator;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import modelo.enterprise.Enterprise;

@Entity
@Table(name = "OrderCriteria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class OrderCriterion<Type> extends Criterion implements Comparator<Enterprise> {
  public abstract int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise);

  public abstract Type weigh(Enterprise enterprise);
}
