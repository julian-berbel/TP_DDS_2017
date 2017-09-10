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
public class MinimizeIndicatorCriterion extends OrderCriterion {
	
	@ManyToOne
	private Indicator indicator;
	
	public MinimizeIndicatorCriterion(Indicator indicator){
		this.indicator = indicator;
	}

	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		int currentYear = Year.now().getValue();
		return indicator.reduce(oneEnterprise, currentYear).compareTo(indicator.reduce(anotherEnterprise, currentYear));
	}

	protected String buildDescription() {
		return "Minimizar indicador " + indicator.getName();
	}

}
