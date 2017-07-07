package modelo.method.criteria.filter;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;

public class EnterpriseMinimumLongevityCriterion extends FilterCriterion
{
	private int minimumAge;
	
	public EnterpriseMinimumLongevityCriterion(int years) 
	{
		super();
		minimumAge = years;
	}

	protected boolean criterion(Enterprise enterprise) {
		return enterprise.age() > minimumAge;
	}
	
}