package vista.method;

import org.uqbar.arena.windows.WindowOwner;
import viewModel.method.DecreasingIndicatorValueVM;

@SuppressWarnings("serial")
public class DecreasingIndicatorValueCriterionWindow extends FilterCriterionWindow<DecreasingIndicatorValueVM> 
{
	public DecreasingIndicatorValueCriterionWindow(WindowOwner owner)
	{
		super(owner, new DecreasingIndicatorValueVM(), "Indicador decreciente durante una cantidad de anios");
	}
}