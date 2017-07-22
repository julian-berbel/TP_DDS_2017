package vista.method;

import org.uqbar.arena.windows.WindowOwner;
import viewModel.method.IndicatorValueLowerThanVM;

@SuppressWarnings("serial")
public class IndicatorValueLowerThanWindow extends IndicatorStatisticCompareWindow<IndicatorValueLowerThanVM>
{
	public IndicatorValueLowerThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorValueLowerThanVM(), "Indicador menor a un valor durante la cantidad de anios indicados");
	}
}