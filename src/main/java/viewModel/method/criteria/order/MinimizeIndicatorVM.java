package viewModel.method.criteria.order;

import org.uqbar.commons.utils.Observable;

import java.util.Optional;

import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.order.MinimizeIndicatorCriterion;
import viewModel.method.criteria.IndicatorRelatedCriterionVM;

@Observable
public class MinimizeIndicatorVM extends IndicatorRelatedCriterionVM<OrderCriterion> {
	public void buildCriterion(){
		targetCriterion = Optional.of(new MinimizeIndicatorCriterion(selectedIndicator));
	}
}