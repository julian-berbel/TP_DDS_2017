package vista.method;

import org.uqbar.arena.windows.WindowOwner;
import viewModel.method.IncreasingIndicatorValueVM;

@SuppressWarnings("serial")
public class IncreasingIndicatorValueCriterionWindow extends FilterCriterionWindow<IncreasingIndicatorValueVM> 
{
	public IncreasingIndicatorValueCriterionWindow(WindowOwner owner)
	{
		super(owner, new IncreasingIndicatorValueVM(), "Indicador creciente durante una cantidad de anios");
	}
}