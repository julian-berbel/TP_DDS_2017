package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;

import viewModel.OrderByIndicatorValueVM;
import modelo.method.criteria.OrderCriterion;
import modelo.indicator.Indicator;
import modelo.method.criteria.order.MinimizeIndicatorCriterion;

@SuppressWarnings("serial")
public class MinimizeIndicatorCriterionWindow extends SimpleWindow<OrderByIndicatorValueVM>
{
	public MinimizeIndicatorCriterionWindow(WindowOwner owner)
	{
		super(owner, new OrderByIndicatorValueVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Maximizar criterio");
		
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Seleccione el indicador que desea minimizar");
		
		Table<Indicator> indicatorTable = new Table<Indicator>(panel1, Indicator.class);
		indicatorTable.bindItemsToProperty("indicators");
		indicatorTable.bindValueToProperty("selectedIndicator");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
		
		new Button(panel2).setCaption("Aceptar").onClick(()->
		{
			OrderCriterion newCriterion = new MinimizeIndicatorCriterion( this.getModelObject().getSelectedIndicator());	
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		});
		new Button(panel2).setCaption("Cancelar").onClick(this::close);
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {}
	
	public OrderCriterion openWithReturn()
	{
		this.getModelObject().refreshList();
		this.open();
		return getModelObject().getTargetCriterion();
	}
}