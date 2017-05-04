package vista;


import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Calculation;
import modelo.Enterprise;
import viewModel.ConsultAccountVM;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;



@SuppressWarnings("serial")
public class ConsultAccountsWindow extends SimpleWindow<ConsultAccountVM>
{	
	public ConsultAccountsWindow(WindowOwner owner)
	{
		super(owner, new ConsultAccountVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Consultar Cuentas");
		mainPanel.setLayout(new VerticalLayout());		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new HorizontalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new HorizontalLayout());
	
		
		
		new Label(panel1).setText("\t\t\tEmpresas");
		List<Enterprise> lstEnterprises = new List<Enterprise>(panel2);
		lstEnterprises.bindItemsToProperty("enterprises");
		lstEnterprises.bindValueToProperty("selectedEnterprise");
		lstEnterprises.setWidth(220);
		lstEnterprises.setHeight(220);
		new Label(panel1).setText("\t\t\t\t\t\t\t\tPeriodos");
		List<Enterprise> lstPeriods = new List<Enterprise>(panel2);
		lstPeriods.bindItemsToProperty("periods");
		lstPeriods.bindValueToProperty("selectedPeriod");
		lstPeriods.setWidth(220);
		lstPeriods.setHeight(220);
		
		
		Table<Calculation> tableCalculations = new Table<Calculation>(panel2, Calculation.class);		
		tableCalculations.setNumberVisibleRows(10).bindItemsToProperty("calculations");
		tableCalculations.setHeight(300);
		tableCalculations.setWidth(600);
		
		Column<Calculation> columnCalculations = new Column<Calculation>(tableCalculations);
		columnCalculations.setTitle("Cuentas").bindContentsToProperty("name");
		
		Column<Calculation> columnValues = new Column<Calculation>(tableCalculations);
		columnValues.setTitle("Valores").bindContentsToProperty("value");
		
		
		
	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}
