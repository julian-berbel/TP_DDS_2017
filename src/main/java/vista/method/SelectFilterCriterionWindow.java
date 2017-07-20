package vista.method;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.criteria.FilterCriterion;

@SuppressWarnings("serial")
public class SelectFilterCriterionWindow extends SelectCriterionWindow<FilterCriterion>
{

	public SelectFilterCriterionWindow(WindowOwner owner) 
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
		
		new Button(panel1).setCaption("Indicador mayor a cierto valor").onClick(()->{
			FilterCriterion newCriterion = new IndicatorGreaterThanValueWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		
		new Button(panel1).setCaption("Indicador menor a cierto valor").onClick(()->{
			FilterCriterion newCriterion = new IndicatorLessThanValueWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		
		new Button(panel1).setCaption("Indicador creciente en los ultimos N anios").onClick(()->{
			FilterCriterion newCriterion = new IncreasingIndicatorValueCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		
		new Button(panel1).setCaption("Indicador decreciente en los ultimos N anios").onClick(()->{
			FilterCriterion newCriterion = new DecreasingIndicatorValueCriterionWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		
		new Button(panel1).setCaption("Promedio mayor a cierto valor").onClick(()->{
			FilterCriterion newCriterion = new AverageHigherThanValueWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
		
		new Button(panel1).setCaption("Promedio menor a cierto valor").onClick(()->{
			FilterCriterion newCriterion = new AverageLessThanValueWindow(this).openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
	}
}
