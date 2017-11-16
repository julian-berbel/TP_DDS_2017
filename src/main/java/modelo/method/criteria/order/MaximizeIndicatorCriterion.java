package modelo.method.criteria.order;

import java.math.BigDecimal;
import java.time.Year;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.OrderCriterion;

@Entity
@DiscriminatorValue("MI")
public class MaximizeIndicatorCriterion extends OrderCriterion<BigDecimal> {
	
	@ManyToOne
	private Indicator indicator;
	
	public MaximizeIndicatorCriterion(Indicator indicator){
		this.indicator = indicator;
	}
	
	public MaximizeIndicatorCriterion(){}

	public BigDecimal weigh(Enterprise enterprise) {
	  return indicator.reduce(enterprise, Year.now().getValue());
	}
	
	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return weigh(anotherEnterprise).compareTo(weigh(oneEnterprise));
	}

	protected String buildDescription() {
		return "Maximizar indicador " + indicator.getName();
	}

}
