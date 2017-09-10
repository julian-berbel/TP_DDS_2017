package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.IndicatorAverageHigherThanCriterion;

@Observable
public class IndicatorAverageHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorAverageHigherThanCriterion(selectedIndicator, value, years));
	}
}