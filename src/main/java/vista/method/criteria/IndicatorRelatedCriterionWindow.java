package vista.method.criteria;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;

import modelo.indicator.Indicator;
import viewModel.method.criteria.IndicatorRelatedCriterionVM;

@SuppressWarnings("serial")

public class IndicatorRelatedCriterionWindow<CriterionType, VMType extends IndicatorRelatedCriterionVM<CriterionType>> extends CriterionWindow<CriterionType, VMType>
{	
	public IndicatorRelatedCriterionWindow(WindowOwner owner, VMType vm, String title)
	{
		super(owner, vm, title);
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		super.createFormPanel(mainPanel);
		
		new Label(mainPanel).setText("Seleccione el indicador que desea comparar");
		
		List<Indicator> indicatorList = new List<Indicator>(mainPanel);
		indicatorList.bindItemsToProperty("indicators");
		indicatorList.bindValueToProperty("selectedIndicator");
		indicatorList.setWidth(300);
		indicatorList.setHeight(200);
	}
}
