package vista;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.MethodResultVM;
import modelo.enterprise.Enterprise;
import modelo.method.Method;

@SuppressWarnings("serial")
public class MethodResultWindow  extends SimpleWindow<MethodResultVM> {
	
	public MethodResultWindow(WindowOwner owner, Method selectedMethod)
	{
		super(owner, new MethodResultVM(selectedMethod));
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(4));
		
		Table<Enterprise> ResultTable = new Table<Enterprise>(panel1, Enterprise.class);
		ResultTable.bindItemsToProperty("results");
		ResultTable.setWidth(600);
		ResultTable.setHeight(200);
		ResultTable.setNumberVisibleRows(10);
				
		Column<Enterprise> columnName = new Column<Enterprise>(ResultTable);
		columnName.setTitle("Empresa").setFixedSize(300).bindContentsToProperty("enterpriseName");
				
		new Button(panel2).setCaption("Volver").onClick(()->{ });
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(()->this.close());
	}
	
}
