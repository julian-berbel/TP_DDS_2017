package viewModel.method.criteria;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class CriterionVM<CriterionType> {
	protected CriterionType targetCriterion;
	
	public CriterionType getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(CriterionType newCriterion) {
		this.targetCriterion = newCriterion;
	}
	
	public abstract void buildCriterion();
}
