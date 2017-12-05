package modelo.method.criteria;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MixedCriteria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class MixedCriterion extends Criterion {
  @ManyToOne
  protected OrderCriterion<?> orderCriterion;

  @ManyToOne
  protected FilterCriterion filterCriterion;

  public MixedCriterion(OrderCriterion<?> orderCriterion, FilterCriterion filterCriterion) {
    this.orderCriterion = orderCriterion;
    this.filterCriterion = filterCriterion;
  }

  protected MixedCriterion() {
  }

  public OrderCriterion<?> getOrderCriterion() {
    return orderCriterion;
  }

  public FilterCriterion getFilterCriterion() {
    return filterCriterion;
  }

  public Boolean uses(Criterion criterion) {
    return orderCriterion == criterion || filterCriterion == criterion;
  }

  public String buildDescription() {
    return filterCriterion.getDescription() + " y " + orderCriterion.getDescription();
  }
}
