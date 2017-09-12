package modelo.method.criteria.mixed;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;

import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.filter.EnterpriseMinimumLongevityCriterion;
import modelo.method.criteria.order.EnterpriseAgeCriterion;

@Entity
@DiscriminatorValue("LH")
public class EnterpriseLongevityHigherThan extends MixedCriterion{
	
	private int years;
	
	public EnterpriseLongevityHigherThan(int years)
	{
		super(new EnterpriseAgeCriterion(), new EnterpriseMinimumLongevityCriterion(years));
		this.years = years;
	}
	
	protected EnterpriseLongevityHigherThan()
	{
		this.orderCriterion = new EnterpriseAgeCriterion();
	}
	
	@PostLoad
	protected void postLoad(){
		this.filterCriterion = new EnterpriseMinimumLongevityCriterion(years);
	}

	protected String buildDescription() {
		return "Antiguedad de la empresa mayor a " + years + " anios, y mientras mas antigua sea mejor";
	}
}