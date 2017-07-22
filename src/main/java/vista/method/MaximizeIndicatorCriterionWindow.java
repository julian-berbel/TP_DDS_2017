package vista.method;

import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import viewModel.method.MaximizeIndicatorVM;

@SuppressWarnings("serial")

public class MaximizeIndicatorCriterionWindow extends CriterionWindow<OrderCriterion, MaximizeIndicatorVM>
{
	public MaximizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new MaximizeIndicatorVM(), "Maximizar indicador");
	}
}
