package viewModel.method;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IndicatorValueLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = FilterCriteria.indicatorValueLowerThan(selectedIndicator, value, years);
	}
}