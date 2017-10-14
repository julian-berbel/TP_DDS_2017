package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.IndicatorValueLowerThanCriterion;


public class IndicatorValueLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorValueLowerThanCriterion(selectedIndicator, value, years));
	}
}