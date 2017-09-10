package viewModel.method.criteria.filter;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.filter.DecreasingIndicatorValueCriterion;

@Observable
public class DecreasingIndicatorValueVM extends FilterCriterionVM {
	public void buildCriterion(){
		targetCriterion = Optional.of(new DecreasingIndicatorValueCriterion(selectedIndicator, years));
	}
}