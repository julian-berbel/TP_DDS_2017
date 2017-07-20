package vista.method;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.OrderCriterion;

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
		
		new Button(panel1).setCaption("Maximizar indicador").onClick(()->{ 
			OrderCriterion newCriterion = new MaximizeIndicatorCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		
		new Button(panel1).setCaption("Minimizar indicador").onClick(()->{
			OrderCriterion newCriterion = new MinimizeIndicatorCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
	}	
}
