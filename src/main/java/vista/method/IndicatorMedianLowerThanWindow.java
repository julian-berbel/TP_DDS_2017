package vista.method;

import org.uqbar.arena.windows.WindowOwner;
import viewModel.method.IndicatorMedianLowerThanVM;

@SuppressWarnings("serial")
public class IndicatorMedianLowerThanWindow extends IndicatorStatisticCompareWindow<IndicatorMedianLowerThanVM>
{
	public IndicatorMedianLowerThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorMedianLowerThanVM(), "Mediana menor a un valor durante la cantidad de anios indicados");
	}
}