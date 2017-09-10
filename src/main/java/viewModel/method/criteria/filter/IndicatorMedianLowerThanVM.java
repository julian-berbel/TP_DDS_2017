package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.IndicatorMedianLowerThanCriterion;

@Observable
public class IndicatorMedianLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorMedianLowerThanCriterion(selectedIndicator, value, years));
	}
}