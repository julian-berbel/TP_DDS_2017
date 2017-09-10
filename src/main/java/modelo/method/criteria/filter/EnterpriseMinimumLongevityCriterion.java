package modelo.method.criteria.filter;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;

public class EnterpriseMinimumLongevityCriterion extends FilterCriterion
{
	private int minimumAge;
	
	public EnterpriseMinimumLongevityCriterion(int years) 
	{
		minimumAge = years;
	}
	
	protected EnterpriseMinimumLongevityCriterion(){}

	public boolean test(Enterprise enterprise) {
		return enterprise.age() > minimumAge;
	}
	
	public String buildDescription(){
		return "Antiguedad de la empresa mayor a " + String.valueOf(minimumAge) + " anios";
	}
	
}