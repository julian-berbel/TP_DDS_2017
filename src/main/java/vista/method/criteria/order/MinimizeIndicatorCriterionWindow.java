package vista.method.criteria.order;

import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import viewModel.method.criteria.order.MinimizeIndicatorVM;
import vista.method.criteria.IndicatorRelatedCriterionWindow;

@SuppressWarnings("serial")

public class MinimizeIndicatorCriterionWindow extends IndicatorRelatedCriterionWindow<OrderCriterion, MinimizeIndicatorVM>
{
	public MinimizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new MinimizeIndicatorVM(), "Minimizar indicador");
	}
}