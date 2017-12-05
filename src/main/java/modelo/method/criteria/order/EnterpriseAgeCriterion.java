package modelo.method.criteria.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.OrderCriterion;

@Entity
@DiscriminatorValue("EA")
public class EnterpriseAgeCriterion extends OrderCriterion<Integer> {
  public Integer weigh(Enterprise enterprise) {
    return enterprise.age();
  }

  public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
    return weigh(oneEnterprise) - weigh(anotherEnterprise);
  }

  protected String buildDescription() {
    return "mientras mas antigua sea mejor";
  }

}
