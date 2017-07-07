package modelo.method.criteria.order;

import java.time.Year;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.OrderCriterion;

public class MaximizeIndicatorCriterion extends OrderCriterion {
	private Indicator indicator;
	
	public MaximizeIndicatorCriterion(Indicator indicator){
		super();
		this.indicator = indicator;
	}

	public int criterion(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		int currentYear = Year.now().getValue();
		return indicator.reduce(oneEnterprise, currentYear).compareTo(indicator.reduce(anotherEnterprise, currentYear));
	}

}
