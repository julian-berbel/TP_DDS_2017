package vista.method;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.enterprise.Enterprise;
import modelo.method.Method;
import viewModel.method.MethodResultVM;
import modelo.method.result.Error;

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
		
		Panel panel1 = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Vale la pena invertir en:");
		new Label(panel1).setText("No Vale la pena invertir en:");
		
		List<Enterprise> passesList = new List<Enterprise>(panel1);
		passesList.bindItemsToProperty("passes");
		passesList.setWidth(300);
		passesList.setHeight(200);
		
		List<Enterprise> failuresList = new List<Enterprise>(panel1);
		failuresList.bindItemsToProperty("failures");
		failuresList.setWidth(300);
		failuresList.setHeight(200);
		
		new Label(mainPanel).setText("No se pudo calcular:");
		
		Table<Error> errorsTable = new Table<Error>(mainPanel, Error.class);
		errorsTable.bindItemsToProperty("errors");
		errorsTable.setNumberVisibleRows(10);
		
		Column<Error> columnCalculations = new Column<Error>(errorsTable);
		columnCalculations.setTitle("Empresa")
							.setFixedSize(300)
							.bindContentsToProperty("enterprise");
		
		Column<Error> columnValues = new Column<Error>(errorsTable);
		columnValues.setTitle("Error")
						.setFixedSize(400)
						.bindContentsToProperty("errorMessage");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(()->this.close());
	}
	
}
