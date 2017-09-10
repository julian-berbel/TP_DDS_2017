package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.IndicatorAverageLowerThanCriterion;

@Observable
public class IndicatorAverageLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorAverageLowerThanCriterion(selectedIndicator, value, years));
	}
}