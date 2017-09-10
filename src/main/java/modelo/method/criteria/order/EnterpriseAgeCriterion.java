package modelo.method.criteria.order;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.OrderCriterion;

public class EnterpriseAgeCriterion extends OrderCriterion {
	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return oneEnterprise.age() - anotherEnterprise.age();
	}

	protected String buildDescription() {
		return "Antiguedad de la empresa";
	}

}
