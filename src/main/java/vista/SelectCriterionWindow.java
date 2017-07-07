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
		
		new Button(panel1).setCaption("Maximizar indicador").onClick(()->{ 
			Criterion newCriterion = new MaximizeIndicatorCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		new Button(panel1).setCaption("Minimizar indicador").onClick(()->{
			Criterion newCriterion = new MinimizeIndicatorCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		new Button(panel1).setCaption("Mejor indicador en los ultimos N años").onClick(()->{ }).setWidth(300);
	
		new Button(panel1).setCaption("Antigüedad de empresa").onClick(()->{ }).setWidth(300);
		new Button(panel1).setCaption("Indicador mayor a cierto valor").onClick(()->{
			Criterion newCriterion = new IndicatorGreaterThanValueWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		new Button(panel1).setCaption("Indicador menor a cierto valor                        ").onClick(()->{
			Criterion newCriterion = new IndicatorLessThanValueWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		new Button(panel1).setCaption("Indicador creciente en los ultimos N años").onClick(()->{ }).setWidth(300);
		new Button(panel1).setCaption("Indicador decreciente en los ultimos N años").onClick(()->{ }).setWidth(300);
		new Button(panel1).setCaption("Promedio mayor a cierto valor").onClick(()->{
			new AverageHigherThanValueWindow();
		}).setWidth(300);
		new Button(panel1).setCaption("Promedio menor a cierto valor").onClick(()->{
			new AverageLessThanValueWindow();
		}).setWidth(300);
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
