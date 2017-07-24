package viewModel.method.criteria.order;

import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.order.MaximizeIndicatorCriterion;
import viewModel.method.criteria.IndicatorRelatedCriterionVM;

@Observable
public class MaximizeIndicatorVM extends IndicatorRelatedCriterionVM<OrderCriterion> {
	public void buildCriterion(){
		targetCriterion = new MaximizeIndicatorCriterion(selectedIndicator);
	}
}