package viewModel.method;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IndicatorAverageHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.indicatorAverageHigherThan(selectedIndicator, value, years);
	}
}