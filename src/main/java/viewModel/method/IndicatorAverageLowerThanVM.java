package viewModel.method;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IndicatorAverageLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.indicatorAverageLowerThan(selectedIndicator, value, years);
	}
}