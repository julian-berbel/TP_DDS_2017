package modelo.method.criteria.order;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.OrderCriterion;

public class Unordered extends OrderCriterion {
	
	public Unordered(){
		super("Sin Orden");
	}

	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return 0;
	}

}
