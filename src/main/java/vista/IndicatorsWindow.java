package vista;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Indicator;
import viewModel.IndicatorsVM;


@SuppressWarnings("serial")
public class IndicatorsWindow extends SimpleWindow<IndicatorsVM> 
{
	public IndicatorsWindow(WindowOwner owner)
	{
		super(owner, new IndicatorsVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Indicadores");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(4));
		
		Table<Indicator> indicatorTable = new Table<Indicator>(panel1, Indicator.class);
		indicatorTable.bindItemsToProperty("indicators");
		indicatorTable.bindValueToProperty("selectedIndicator");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
				
		Column<Indicator> columnName = new Column<Indicator>(indicatorTable);
		columnName.setTitle("Indicador").setFixedSize(100).bindContentsToProperty("name");
		
		Column<Indicator> columnFormula = new Column<Indicator>(indicatorTable);
		columnFormula.setTitle("Formula").setFixedSize(500).bindContentsToProperty("formula");
		
		new Button(panel2).setCaption("Nuevo").onClick(() -> { 	new EditIndicatorWindow(this, this.getModelObject().newIndicator()).open();
																this.getModelObject().addNewIndicator();});
		new Button(panel2).setCaption("Editar").onClick(() -> new EditIndicatorWindow(this, this.getModelObject().editIndicator()).open());
		new Button(panel2).setCaption("Borrar").onClick(() -> this.getModelObject().deleteIndicator());
		new Button(panel2).setCaption("Cargar archivo").onClick(() -> { new LoadIndicatorsWindow(this).open(); 
																		this.getModelObject().refreshList();});
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}

