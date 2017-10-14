package viewModel.method.criteria.order;

import java.util.Optional;

import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.order.MinimizeIndicatorCriterion;
import viewModel.method.criteria.IndicatorRelatedCriterionVM;


public class MinimizeIndicatorVM extends IndicatorRelatedCriterionVM<OrderCriterion> {
	public void buildCriterion(){
		targetCriterion = Optional.of(new MinimizeIndicatorCriterion(selectedIndicator));
	}
}