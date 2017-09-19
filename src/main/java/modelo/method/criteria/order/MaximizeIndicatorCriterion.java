package modelo.method.criteria.order;

import java.time.Year;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.OrderCriterion;

@Entity
@DiscriminatorValue("MI")
public class MaximizeIndicatorCriterion extends OrderCriterion {
	
	@ManyToOne
	private Indicator indicator;
	
	public MaximizeIndicatorCriterion(Indicator indicator){
		this.indicator = indicator;
	}
	
	public MaximizeIndicatorCriterion(){}

	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		int currentYear = Year.now().getValue();
		return indicator.reduce(anotherEnterprise, currentYear).compareTo(indicator.reduce(oneEnterprise, currentYear));
	}

	protected String buildDescription() {
		return "Maximizar indicador " + indicator.getName();
	}

}
