package modelo.method.criteria.mixed;

import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.filter.FilterCriteria;
import modelo.method.criteria.order.EnterpriseAgeCriterion;

public class EnterpriseLongevityHigherThan extends MixedCriterion{
	public EnterpriseLongevityHigherThan(int years)
	{
		super(new EnterpriseAgeCriterion(), FilterCriteria.minimumLongevity(years), "Antiguedad de la empresa mayor a " + years + " anios, y mientras mas antigua sea mejor");
	}
}