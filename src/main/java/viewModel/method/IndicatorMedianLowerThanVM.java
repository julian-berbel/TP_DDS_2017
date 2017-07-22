package viewModel.method;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IndicatorMedianLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.indicatorMedianLowerThan(selectedIndicator, value, years);
	}
}