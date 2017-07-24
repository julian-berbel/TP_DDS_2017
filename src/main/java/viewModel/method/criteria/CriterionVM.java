package viewModel.method.criteria;

import java.util.Optional;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class CriterionVM<CriterionType> {
	protected Optional<CriterionType> targetCriterion = Optional.empty();
	
	public Optional<CriterionType> getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(Optional<CriterionType> newCriterion) {
		this.targetCriterion = newCriterion;
	}
	
	public abstract void buildCriterion();
}
