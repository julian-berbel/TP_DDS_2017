package viewModel.method.criteria.mixed;

import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.mixed.EnterpriseLongevityHigherThan;
import viewModel.method.criteria.CriterionVM;

@Observable
public class EnterpriseLongevityGreaterThanVM extends CriterionVM<MixedCriterion> {

	protected int years;
	
	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public void buildCriterion(){
		targetCriterion = Optional.of(new EnterpriseLongevityHigherThan(years));
	}
}