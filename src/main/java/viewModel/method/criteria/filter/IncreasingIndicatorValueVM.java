package viewModel.method.criteria.filter;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IncreasingIndicatorValueVM extends FilterCriterionVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.increasingIndicatorValue(selectedIndicator, years);
	}
}