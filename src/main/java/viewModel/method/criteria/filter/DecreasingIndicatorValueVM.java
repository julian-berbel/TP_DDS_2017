package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.DecreasingIndicatorValueCriterion;


public class DecreasingIndicatorValueVM extends FilterCriterionVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new DecreasingIndicatorValueCriterion(selectedIndicator, years));
	}
}