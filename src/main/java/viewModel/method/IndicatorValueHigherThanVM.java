package viewModel.method;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IndicatorValueHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.indicatorValueHigherThan(selectedIndicator, value, years);
	}
}