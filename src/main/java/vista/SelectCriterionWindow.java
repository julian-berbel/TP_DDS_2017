package vista;


import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.Criterion;
import viewModel.SelectCriterionVM;

@SuppressWarnings("serial")
public class SelectCriterionWindow extends SimpleWindow<SelectCriterionVM>
{

	public SelectCriterionWindow(WindowOwner owner) 
	{
		super(owner, new SelectCriterionVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Seleccione el tipo de criterio");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
		
		new Button(panel1).setCaption("Maximizar indicador                                      ").onClick(()->{ 
			Criterion newCriterion = new MaximizeIndicatorCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		});
		new Button(panel1).setCaption("Minimizar indicador                                       ").onClick(()->{ });
		new Button(panel1).setCaption("Mejor indicador en los ultimos N años").onClick(()->{ });
		new Button(panel1).setCaption("Antigüedad de empresa                               ").onClick(()->{ });
		new Button(panel1).setCaption("Indicador mayor a cierto valor                 ").onClick(()->{ });
	}
	

	@Override
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(()->this.close());	
	}
	
	public Criterion openWithReturn() 
	{
		this.open();
		return getModelObject().getTargetCriterion();
	}
	
	
}
