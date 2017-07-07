package viewModel;


import modelo.Criterion;

public class SelectCriterionVM {

	private Criterion targetCriterion;
	
	public Criterion getTargetCriterion() {
		
		return targetCriterion;
	}

	public void setTargetCriterion(Criterion newCriterion) {
		this.targetCriterion = newCriterion;
	}
}
