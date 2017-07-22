package vista.method.criteria.filter;

import org.uqbar.arena.windows.WindowOwner;

import viewModel.method.criteria.filter.IndicatorAverageLowerThanVM;

@SuppressWarnings("serial")

public class IndicatorAverageLowerThanWindow extends IndicatorStatisticCompareWindow<IndicatorAverageLowerThanVM>
{
	public IndicatorAverageLowerThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorAverageLowerThanVM(), "Promedio menor a un valor durante la cantidad de anios indicados");
	}
}