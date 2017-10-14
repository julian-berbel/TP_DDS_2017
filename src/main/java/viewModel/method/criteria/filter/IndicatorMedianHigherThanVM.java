package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.IndicatorMedianHigherThanCriterion;


public class IndicatorMedianHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorMedianHigherThanCriterion(selectedIndicator, value, years));
	}
}