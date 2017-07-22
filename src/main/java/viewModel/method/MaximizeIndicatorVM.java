package viewModel.method;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.order.MaximizeIndicatorCriterion;

@Observable
public class MaximizeIndicatorVM extends CriterionVM<OrderCriterion> {
	public void buildCriterion(){
		targetCriterion = new MaximizeIndicatorCriterion(selectedIndicator);
	}
}