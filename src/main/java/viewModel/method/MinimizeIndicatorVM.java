package viewModel.method;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.order.MinimizeIndicatorCriterion;

@Observable
public class MinimizeIndicatorVM extends CriterionVM<OrderCriterion> {
	public void buildCriterion(){
		targetCriterion = new MinimizeIndicatorCriterion(selectedIndicator);
	}
}