package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.IndicatorValueLowerThanCriterion;

@Observable
public class IndicatorValueLowerThanVM extends IndicatorStatisticCompareVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IndicatorValueLowerThanCriterion(selectedIndicator, value, years));
	}
}