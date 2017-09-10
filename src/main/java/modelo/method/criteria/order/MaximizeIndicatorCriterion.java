package modelo.method.criteria.order;

import java.time.Year;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.OrderCriterion;

public class MaximizeIndicatorCriterion extends OrderCriterion {
	private Indicator indicator;
	
	public MaximizeIndicatorCriterion(Indicator indicator){
		this.indicator = indicator;
	}

	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		int currentYear = Year.now().getValue();
		return indicator.reduce(anotherEnterprise, currentYear).compareTo(indicator.reduce(oneEnterprise, currentYear));
	}

	protected String buildDescription() {
		return "Maximizar indicador " + indicator.getName();
	}

}
