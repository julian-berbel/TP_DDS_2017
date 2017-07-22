package vista.method;

import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import viewModel.method.MinimizeIndicatorVM;

@SuppressWarnings("serial")

public class MinimizeIndicatorCriterionWindow extends CriterionWindow<OrderCriterion, MinimizeIndicatorVM>
{
	public MinimizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new MinimizeIndicatorVM(), "Minimizar indicador");
	}
}