package modelo.method.criteria.order;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.OrderCriterion;

public class EnterpriseAgeCriterion extends OrderCriterion {
	
	public EnterpriseAgeCriterion(){
		super();
	}

	public int criterion(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return oneEnterprise.age() - anotherEnterprise.age();
	}

}
