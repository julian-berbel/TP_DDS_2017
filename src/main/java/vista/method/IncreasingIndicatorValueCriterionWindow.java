package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;

import viewModel.VariatingIndicatorValueVM;

import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.filter.FilterCriteria;
import modelo.indicator.Indicator;


@SuppressWarnings("serial")
public class IncreasingIndicatorValueCriterionWindow extends SimpleWindow<VariatingIndicatorValueVM> 
{
	public IncreasingIndicatorValueCriterionWindow(WindowOwner owner)
	{
		super(owner, new VariatingIndicatorValueVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Indicador creciente en una cantidad de años");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Seleccione el indicador que desea comparar");
		
		Table<Indicator> indicatorTable = new Table<Indicator>(panel1, Indicator.class);
		indicatorTable.bindItemsToProperty("indicators");
		indicatorTable.bindValueToProperty("selectedIndicator");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
		
		new Label(panel1).setText("Ingrese la cantidad de anios");

		new NumericField(panel1).bindValueToProperty("numberYears");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(()->
		{
			FilterCriterion newCriterion = FilterCriteria.increasingIndicatorValue(this.getModelObject().getSelectedIndicator(), this.getModelObject().getNumberYears());
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		});
		
		new Button(actions).setCaption("Cancelar").onClick(this::close);
	}
	
	public FilterCriterion openWithReturn()
	{
		this.getModelObject().refreshList();
		this.open();
		return getModelObject().getTargetCriterion();
	}
	
}



