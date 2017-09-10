package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.IncreasingIndicatorValueCriterion;

@Observable
public class IncreasingIndicatorValueVM extends FilterCriterionVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new IncreasingIndicatorValueCriterion(selectedIndicator, years));
	}
}