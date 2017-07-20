package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.filter.FilterCriteria;

@SuppressWarnings("serial")
public class IndicatorLessThanValueWindow extends IndicatorStatisticCompareWindow
{
	public IndicatorLessThanValueWindow(WindowOwner owner)
	{
		super(owner);
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		super.createFormPanel(mainPanel, "Indicador mayor a un valor segun cantidad de anios indicados");
	}
	
	@Override
	protected void addActions(Panel actions) {
		super.addActions(actions);
		
		new Button(actions).setCaption("Aceptar").onClick(()->
		{
			FilterCriterion newCriterion = FilterCriteria.indicatorValueLowerThan(this.getModelObject().getSelectedIndicator(), this.getModelObject().getValue(), this.getModelObject().getNumberYears());
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		});
	}
}