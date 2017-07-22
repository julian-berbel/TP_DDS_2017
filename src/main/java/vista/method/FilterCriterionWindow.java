package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;

import modelo.method.criteria.FilterCriterion;
import viewModel.method.FilterCriterionVM;

@SuppressWarnings("serial")
public abstract class FilterCriterionWindow<VMType extends FilterCriterionVM> extends CriterionWindow<FilterCriterion, VMType>
{	
	public FilterCriterionWindow(WindowOwner owner, VMType vm, String title)
	{
		super(owner, vm, title);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel)
	{
		super.createFormPanel(mainPanel);
		
		new Label(mainPanel).setText("Ingrese la cantidad de anios");

		new NumericField(mainPanel).bindValueToProperty("years");
	}
}
