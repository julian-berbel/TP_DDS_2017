
package modelo.method.criteria.filter;

import java.util.List;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.OrderCriterion;

public class CanBeOrderedCriterion extends FilterCriterion {
  private List<OrderCriterion<?>> orderCriteria;

  public CanBeOrderedCriterion(List<OrderCriterion<?>> orderCriteria) {
    this.orderCriteria = orderCriteria;
  }

  public boolean test(Enterprise enterprise) {
    orderCriteria.stream().forEach(orderCriterion -> orderCriterion.weigh(enterprise));
    return true;
  }

  protected String buildDescription() {
    return "El indicador puede ser ordenado por los criterios de orden dados";
  }

}