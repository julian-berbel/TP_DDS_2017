package vista.method.criteria.order;

import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import viewModel.method.criteria.order.MaximizeIndicatorVM;
import vista.method.criteria.IndicatorRelatedCriterionWindow;

@SuppressWarnings("serial")

public class MaximizeIndicatorCriterionWindow extends IndicatorRelatedCriterionWindow<OrderCriterion, MaximizeIndicatorVM>
{
	public MaximizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new MaximizeIndicatorVM(), "Maximizar indicador");
	}
}
