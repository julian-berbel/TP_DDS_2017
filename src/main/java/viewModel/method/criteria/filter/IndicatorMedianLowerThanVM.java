package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.IndicatorMedianLowerThanCriterion;


public class IndicatorMedianLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorMedianLowerThanCriterion(selectedIndicator, value, years));
	}
}