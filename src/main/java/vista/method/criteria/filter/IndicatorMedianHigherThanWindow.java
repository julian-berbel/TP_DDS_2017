package vista.method.criteria.filter;

import org.uqbar.arena.windows.WindowOwner;

import viewModel.method.criteria.filter.IndicatorMedianHigherThanVM;

@SuppressWarnings("serial")
public class IndicatorMedianHigherThanWindow extends IndicatorStatisticCompareWindow<IndicatorMedianHigherThanVM>
{
	public IndicatorMedianHigherThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorMedianHigherThanVM(), "Mediana menor a un valor durante la cantidad de anios indicados");
	}
}