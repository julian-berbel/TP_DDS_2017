package vista.method.criteria.order;

import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import viewModel.method.criteria.order.MaximizeIndicatorVM;
import vista.method.criteria.CriterionWindow;

@SuppressWarnings("serial")

public class MaximizeIndicatorCriterionWindow extends CriterionWindow<OrderCriterion, MaximizeIndicatorVM>
{
	public MaximizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new MaximizeIndicatorVM(), "Maximizar indicador");
	}
}
