package modelo.method.criteria.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.OrderCriterion;

@Entity
@DiscriminatorValue("EA")
public class EnterpriseAgeCriterion extends OrderCriterion {
	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return oneEnterprise.age() - anotherEnterprise.age();
	}

	protected String buildDescription() {
		return "mientras mas antigua sea mejor";
	}

}
