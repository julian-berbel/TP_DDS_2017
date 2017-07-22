package vista.method.criteria.filter;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.method.criteria.filter.IndicatorStatisticCompareVM;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;

@SuppressWarnings("serial")
public abstract class IndicatorStatisticCompareWindow<T extends IndicatorStatisticCompareVM> extends FilterCriterionWindow<T>
{
	
	public IndicatorStatisticCompareWindow(WindowOwner owner, T vm, String title)
	{
		super(owner, vm, title);
	}
		
	@Override
	protected void createFormPanel(Panel mainPanel)
	{
		super.createFormPanel(mainPanel);
		
		new Label(mainPanel).setText("Ingrese el valor a comparar");

		new NumericField(mainPanel).bindValueToProperty("value");
	}
}
