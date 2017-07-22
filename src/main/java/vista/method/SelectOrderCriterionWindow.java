package vista.method;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;
import vista.method.criteria.order.MaximizeIndicatorCriterionWindow;
import vista.method.criteria.order.MinimizeIndicatorCriterionWindow;

@SuppressWarnings("serial")
public class SelectOrderCriterionWindow extends SelectCriterionWindow<OrderCriterion>
{

	public SelectOrderCriterionWindow(WindowOwner owner) 
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
		
		addCriterionButton(panel1, "Maximizar indicador", new MaximizeIndicatorCriterionWindow(this));
		
		addCriterionButton(panel1, "Minimizar indicador", new MinimizeIndicatorCriterionWindow(this));
	}	
}
