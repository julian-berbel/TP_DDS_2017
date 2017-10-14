package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.IndicatorAverageHigherThanCriterion;


public class IndicatorAverageHigherThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorAverageHigherThanCriterion(selectedIndicator, value, years));
	}
}