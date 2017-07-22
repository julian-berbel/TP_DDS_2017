package vista.method;

import org.uqbar.arena.windows.WindowOwner;
import viewModel.method.IndicatorAverageHigherThanVM;

@SuppressWarnings("serial")

public class IndicatorAverageHigherThanWindow extends IndicatorStatisticCompareWindow<IndicatorAverageHigherThanVM>
{
	public IndicatorAverageHigherThanWindow(WindowOwner owner)
	{
		super(owner, new IndicatorAverageHigherThanVM(), "Promedio mayor a un valor durante la cantidad de anios indicados");
	}
}