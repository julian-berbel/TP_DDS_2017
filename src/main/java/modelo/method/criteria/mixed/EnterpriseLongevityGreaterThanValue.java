package modelo.method.criteria.mixed;

import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.filter.EnterpriseMinimumLongevityCriterion;
import modelo.method.criteria.order.EnterpriseAgeCriterion;

public class EnterpriseLongevityGreaterThanValue extends MixedCriterion{
	public EnterpriseLongevityGreaterThanValue(int years) 
	{
		this.filterCriterion = new EnterpriseMinimumLongevityCriterion(years);
		this.orderCriterion = new EnterpriseAgeCriterion();
	}
}