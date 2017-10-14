package viewModel.method.criteria;

import java.util.Optional;


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
