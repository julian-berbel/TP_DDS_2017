package vista.method.criteria.mixed;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;

import modelo.method.criteria.MixedCriterion;
import viewModel.method.criteria.mixed.EnterpriseLongevityGreaterThanVM;
import vista.method.criteria.CriterionWindow;

@SuppressWarnings("serial")

public class EnterpriseLongevityGreaterThanWindow extends CriterionWindow<MixedCriterion, EnterpriseLongevityGreaterThanVM>
{
	public EnterpriseLongevityGreaterThanWindow(WindowOwner owner)
	{
		super(owner, new EnterpriseLongevityGreaterThanVM(), "Edad de la empresa");
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{		
		new Label(mainPanel).setText("Edad minima de la empresa:");
		
		new NumericField(mainPanel).bindValueToProperty("years");
	}
}
