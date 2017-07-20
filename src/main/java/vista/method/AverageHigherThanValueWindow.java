package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.filter.FilterCriteria;

@SuppressWarnings("serial")

public class AverageHigherThanValueWindow extends IndicatorStatisticCompareWindow
{
	public AverageHigherThanValueWindow(WindowOwner owner)
	{
		super(owner);
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		super.createFormPanel(mainPanel, "Promedio mayor a un valor durante la cantidad de anios indicados");
	}
	
	@Override
	protected void addActions(Panel actions) {
		super.addActions(actions);
		
		new Button(actions).setCaption("Aceptar").onClick(()->
		{
			FilterCriterion newCriterion = FilterCriteria.indicatorAverageHigherThan(this.getModelObject().getSelectedIndicator(), this.getModelObject().getValue(), this.getModelObject().getNumberYears());
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		});
	}
}
