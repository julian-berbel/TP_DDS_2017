package viewModel.method.criteria.filter;
import java.util.Optional;


import modelo.method.criteria.filter.IndicatorAverageLowerThanCriterion;


public class IndicatorAverageLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorAverageLowerThanCriterion(selectedIndicator, value, years));
	}
}