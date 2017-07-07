package viewModel;


import modelo.method.criteria.Criterion;

public class SelectCriterionVM {

	private Criterion targetCriterion;
	
	public Criterion getTargetCriterion() {
		
		return targetCriterion;
	}

	public void setTargetCriterion(Criterion newCriterion) {
		this.targetCriterion = newCriterion;
	}
}
