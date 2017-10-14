package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.IncreasingIndicatorValueCriterion;


public class IncreasingIndicatorValueVM extends FilterCriterionVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IncreasingIndicatorValueCriterion(selectedIndicator, years));
	}
}