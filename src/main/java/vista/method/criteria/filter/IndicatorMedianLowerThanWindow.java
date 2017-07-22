package vista.method.criteria.filter;

import org.uqbar.arena.windows.WindowOwner;

import viewModel.method.criteria.filter.IndicatorMedianLowerThanVM;

@SuppressWarnings("serial")
public class IndicatorMedianLowerThanWindow extends IndicatorStatisticCompareWindow<IndicatorMedianLowerThanVM>
{
	public IndicatorMedianLowerThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorMedianLowerThanVM(), "Mediana menor a un valor durante la cantidad de anios indicados");
	}
}