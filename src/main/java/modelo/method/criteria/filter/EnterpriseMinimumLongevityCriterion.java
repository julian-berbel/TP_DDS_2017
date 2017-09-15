package modelo.method.criteria.filter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;

@Entity
@DiscriminatorValue("ML")
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
		return "Antiguedad de la empresa mayor a " + minimumAge + " anios";
	}
	
}