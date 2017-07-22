package vista.method.criteria.order;

import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import viewModel.method.criteria.order.MinimizeIndicatorVM;
import vista.method.criteria.CriterionWindow;

@SuppressWarnings("serial")

public class MinimizeIndicatorCriterionWindow extends CriterionWindow<OrderCriterion, MinimizeIndicatorVM>
{
	public MinimizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new MinimizeIndicatorVM(), "Minimizar indicador");
	}
}