package viewModel.method;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class DecreasingIndicatorValueVM extends FilterCriterionVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.decreasingIndicatorValue(selectedIndicator, years);
	}
}