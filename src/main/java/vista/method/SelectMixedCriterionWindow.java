package vista.method;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.MixedCriterion;
import vista.method.criteria.mixed.EnterpriseLongevityGreaterThanWindow;

@SuppressWarnings("serial")
public class SelectMixedCriterionWindow extends SelectCriterionWindow<MixedCriterion>
{

	public SelectMixedCriterionWindow(WindowOwner owner) 
	{
		super(owner);
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Seleccione el tipo de criterio");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));

		addCriterionButton(panel1, "Longevidad", new EnterpriseLongevityGreaterThanWindow(this));
	}
}
