package modelo.method.criteria.order;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.OrderCriterion;

public class Unordered extends OrderCriterion<Void> {

  public Void weigh(Enterprise enterprise) {
    return null;
  }

  public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
    return 0;
  }

  protected String buildDescription() {
    return "Sin Orden";
  }

}
