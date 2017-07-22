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
		
		Panel panel1 = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		
		addCriterionButton(panel1, "Indicador mayor a cierto valor", new IndicatorValueHigherThanWindow(this));
		
		addCriterionButton(panel1, "Indicador menor a cierto valor", new IndicatorValueLowerThanWindow(this));
		
		addCriterionButton(panel1, "Indicador creciente en los ultimos N anios", new IncreasingIndicatorValueCriterionWindow(this));
		
		addCriterionButton(panel1, "Indicador decreciente en los ultimos N anios", new DecreasingIndicatorValueCriterionWindow(this));
		
		addCriterionButton(panel1, "Promedio mayor a cierto valor", new IndicatorAverageHigherThanWindow(this));
		
		addCriterionButton(panel1, "Promedio menor a cierto valor", new IndicatorAverageLowerThanWindow(this));
		
		addCriterionButton(panel1, "Mediana mayor a cierto valor", new IndicatorMedianHigherThanWindow(this));
		
		addCriterionButton(panel1, "Mediana menor a cierto valor", new IndicatorMedianLowerThanWindow(this));
	}
	
	private void addCriterionButton(Panel panel, String caption, FilterCriterionWindow<?> window){
		new Button(panel).setCaption(caption).onClick(() -> {
			FilterCriterion newCriterion = window.openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
	}
}
