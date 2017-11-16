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
@DiscriminatorValue("mI")
public class MinimizeIndicatorCriterion extends OrderCriterion<BigDecimal> {
	
	@ManyToOne
	private Indicator indicator;
	
	public MinimizeIndicatorCriterion(Indicator indicator){
		this.indicator = indicator;
	}
	
	public MinimizeIndicatorCriterion(){}

	public BigDecimal weigh(Enterprise enterprise) {
	  return indicator.reduce(enterprise, Year.now().getValue());
	}
	
	public int compare(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return weigh(oneEnterprise).compareTo(weigh(anotherEnterprise));
	}

	protected String buildDescription() {
		return "Minimizar indicador " + indicator.getName();
	}

}
