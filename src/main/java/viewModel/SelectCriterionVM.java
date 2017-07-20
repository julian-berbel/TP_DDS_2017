package viewModel;

public class SelectCriterionVM<T> {

	private T targetCriterion;
	
	public T getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(T newCriterion) {
		this.targetCriterion = newCriterion;
	}
}
