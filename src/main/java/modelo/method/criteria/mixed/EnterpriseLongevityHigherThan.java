package modelo.method.criteria.mixed;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.filter.EnterpriseMinimumLongevityCriterion;
import modelo.method.criteria.order.EnterpriseAgeCriterion;

@Entity
@DiscriminatorValue("LH")
public class EnterpriseLongevityHigherThan extends MixedCriterion{
		
	public EnterpriseLongevityHigherThan(int years)
	{
		super(new EnterpriseAgeCriterion(), new EnterpriseMinimumLongevityCriterion(years));
	}
	
	protected EnterpriseLongevityHigherThan(){}
}