package modelo.method.criteria.mixed;

import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.filter.EnterpriseMinimumLongevityCriterion;
import modelo.method.criteria.order.EnterpriseAgeCriterion;

public class EnterpriseLongevityHigherThan extends MixedCriterion{
	private int years;
	public EnterpriseLongevityHigherThan(int years)
	{
		super(new EnterpriseAgeCriterion(), new EnterpriseMinimumLongevityCriterion(years));
		this.years = years;
	}

	protected String buildDescription() {
		return "Antiguedad de la empresa mayor a " + years + " anios, y mientras mas antigua sea mejor";
	}
}