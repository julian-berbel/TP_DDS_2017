package vista.method.criteria.filter;

import org.uqbar.arena.windows.WindowOwner;

import viewModel.method.criteria.filter.IndicatorValueHigherThanVM;

@SuppressWarnings("serial")
public class IndicatorValueHigherThanWindow extends IndicatorStatisticCompareWindow<IndicatorValueHigherThanVM>
{
	public IndicatorValueHigherThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorValueHigherThanVM(), "Indicador mayor a un valor durante la cantidad de anios indicados");
	}
}