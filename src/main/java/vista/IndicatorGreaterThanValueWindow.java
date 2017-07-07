
package vista;


import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;



import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;

import viewModel.IndicatorGreaterThanValueVM;

import modelo.method.criteria.Criterion;
import modelo.method.criteria.filter.IndicatorValueHigherThanCriterion;
import modelo.indicator.Indicator;



@SuppressWarnings("serial")

public class IndicatorGreaterThanValueWindow extends SimpleWindow<IndicatorGreaterThanValueVM>
{
	public IndicatorGreaterThanValueWindow(WindowOwner owner)
	{
		super(owner, new IndicatorGreaterThanValueVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Indicador mayor a un valor segun cantidad de años indicados");
		
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
		new Label(panel1).setText("Ingrese el valor a comparar");

		new NumericField(panel1).bindValueToProperty("value");
		new Label(panel1).setText("Ingrese la cantidad de años");

		new NumericField(panel1).bindValueToProperty("numberYears");
		
		new Button(panel2).setCaption("Aceptar").onClick(()->
		{
			Criterion newCriterion = new IndicatorValueHigherThanCriterion(this.getModelObject().getSelectedIndicator(), this.getModelObject().getValue(), this.getModelObject().getNumberYears());
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		});
		new Button(panel2).setCaption("Cancelar").onClick(this::close);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {}
	
	public Criterion openWithReturn()
	{
		this.getModelObject().refreshList();
		this.open();
		return getModelObject().getTargetCriterion();
	}
}