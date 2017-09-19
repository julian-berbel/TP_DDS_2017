package vista.enterprise;

import java.util.Optional;

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

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import viewModel.enterprise.ConsultAccountVM;
import vista.ExportWindow;

@SuppressWarnings("serial")
public class ConsultAccountsWindow extends SimpleWindow<ConsultAccountVM>
{	
	public ConsultAccountsWindow(WindowOwner owner)
	{
		super(owner, new ConsultAccountVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel )
	{
		this.setTitle("Consultar Cuentas");
		mainPanel.setLayout(new VerticalLayout());		
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Empresas");
		new Label(panel1).setText("Periodos");
		
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(3));
		
		List<Enterprise> lstEnterprises = new List<Enterprise>(panel1);
		lstEnterprises.bindItemsToProperty("enterprises");
		lstEnterprises.bindValueToProperty("selectedEnterprise");
		lstEnterprises.setWidth(220);
		lstEnterprises.setHeight(220);
		
		List<Enterprise> lstPeriods = new List<Enterprise>(panel1);
		lstPeriods.bindItemsToProperty("periods");
		lstPeriods.bindValueToProperty("selectedPeriod");
		lstPeriods.setWidth(220);
		lstPeriods.setHeight(220);
		
		Table<Calculation> tableCalculations = new Table<Calculation>(mainPanel, Calculation.class);		
		tableCalculations.setNumberVisibleRows(10).bindItemsToProperty("calculations");
		tableCalculations.setHeight(300);
		tableCalculations.setWidth(600);
		
		Column<Calculation> columnCalculations = new Column<Calculation>(tableCalculations);
		columnCalculations.setTitle("Cuentas").bindContentsToProperty("name");
		
		Column<Calculation> columnValues = new Column<Calculation>(tableCalculations);
		columnValues.setTitle("Valores").bindContentsToProperty("value");
		
		new Button(panel2).setCaption("Nueva Empresa").onClick(()->{ 
			Optional<Enterprise> newEnterprise = new EditEnterpriseWindow(this,Optional.empty()).openWithReturn();
			this.getModelObject().addNewEnterprise(newEnterprise);
		});
		
		new Button(panel2).setCaption("Editar Empresa").onClick(()->{ 
			if(this.getModelObject().getSelectedEnterprise() != null)
			{
				Optional<Enterprise> targetEnterprise = new EditEnterpriseWindow(this, Optional.of(this.getModelObject().getSelectedEnterprise())).openWithReturn();
				this.getModelObject().updateEnterprise(targetEnterprise);	
			}
		});
		
		new Button(panel2).setCaption("Borrar Empresa").onClick(()->{ 
			this.getModelObject().deleteEnterprise();
		});
		
	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this::close);
	}
	
	@SuppressWarnings("unused")
	private void verifyChangesAndSave()
	{
		ExportWindow window = new ExportWindow(this);
		window.open();
		
		this.close();
	}
}
