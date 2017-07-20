package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.NumericField;
import viewModel.IndicatorStatisticCompareVM;
import modelo.method.criteria.FilterCriterion;
import modelo.indicator.Indicator;

@SuppressWarnings("serial")
public abstract class IndicatorStatisticCompareWindow extends SimpleWindow<IndicatorStatisticCompareVM>
{
	public IndicatorStatisticCompareWindow(WindowOwner owner)
	{
		super(owner, new IndicatorStatisticCompareVM());
	}
		
	protected void createFormPanel(Panel mainPanel, String title)
	{
		this.setTitle(title);
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Seleccione el indicador que desea comparar");
		
		List<Indicator> indicatorList= new List<Indicator>(panel1);
		indicatorList.bindItemsToProperty("indicators");
		indicatorList.bindValueToProperty("selectedIndicator");
		indicatorList.setWidth(300);
		indicatorList.setHeight(200);
		new Label(panel1).setText("Ingrese el valor a comparar");

		new NumericField(panel1).bindValueToProperty("value");
		new Label(panel1).setText("Ingrese la cantidad de anios");

		new NumericField(panel1).bindValueToProperty("numberYears");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Cancelar").onClick(this::close);
	}
	
	public FilterCriterion openWithReturn()
	{
		this.getModelObject().refreshList();
		this.open();
		return getModelObject().getTargetCriterion();
	}
}
