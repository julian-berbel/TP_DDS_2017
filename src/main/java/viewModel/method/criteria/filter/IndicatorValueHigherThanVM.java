package viewModel.method.criteria.filter;
import java.util.Optional;

import modelo.method.criteria.filter.IndicatorValueHigherThanCriterion;

public class IndicatorValueHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorValueHigherThanCriterion(selectedIndicator, value, years));
	}
}