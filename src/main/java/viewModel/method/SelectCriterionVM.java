package viewModel.method;

import java.util.Optional;

public class SelectCriterionVM<T> {

	private Optional<T> targetCriterion = Optional.empty();
	
	public Optional<T> getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(Optional<T> newCriterion) {
		this.targetCriterion = newCriterion;
	}
}
