package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.FilterCriteria;

@Observable
public class IndicatorAverageLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(FilterCriteria.indicatorAverageLowerThan(selectedIndicator, value, years));
	}
}