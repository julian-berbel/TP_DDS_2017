package vista.enterprise;

import java.util.Optional;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.EmptyEnterpriseException;
import exceptions.EmptyFieldException;
import exceptions.ExistingEnterpriseException;
import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import viewModel.enterprise.EditEnterpriseVM;
import vista.ErrorWindow;


@SuppressWarnings("serial")
public class EditEnterpriseWindow extends Dialog<EditEnterpriseVM> {

	public EditEnterpriseWindow(WindowOwner owner,Optional<Enterprise> targetEnterprise)
	{
		super(owner, new EditEnterpriseVM(targetEnterprise));
	}	
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Nueva Empresa");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		
//		Panel panel1v1= new Panel(panel1);
		Panel panel1v3 = new Panel(panel1);
		panel1v3.setLayout(new VerticalLayout());
//		Panel panel1v2 = new Panel(panel1);
		
		
		
		
		
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new VerticalLayout());
		Panel panel3 = new Panel(panel2);
		panel3.setLayout(new VerticalLayout());
		Panel panel4 = new Panel(panel2);
		panel4.setLayout(new HorizontalLayout());
		
		
		
		new Label(panel1).setText("Nombre de la nueva empresa:");
	    new TextBox(panel1).setWidth(200).bindValueToProperty("enterpriseName");
	    
	    new Label(panel3).setText("Seleccionar periodo:");
		List<Integer> lstPeriods = new List<Integer>(panel3);
		lstPeriods.bindItemsToProperty("year");
		lstPeriods.bindValueToProperty("selectedYear");
		lstPeriods.setWidth(220);		
		lstPeriods.setHeight(220);
		    
	    
		
		
		
		new Button(panel4).setCaption("Agregar Cuenta").onClick(()->{
			if(this.getModelObject().getSelectedYear() != null)
			{
				this.getModelObject().createPeriod();
				Optional<Calculation> newCalculation = new EditCalculationWindow(this,this.getModelObject().getPeriod(),Optional.empty()).openWithReturn();
				this.getModelObject().addNewCalculation(newCalculation);
			}
			});
		new Button(panel4).setCaption("Editar Cuenta").onClick(()->{
			if(this.getModelObject().getSelectedYear() != null && this.getModelObject().getSelectedCalculation() != null)
			{
			Optional<Calculation> targetCalculation = new EditCalculationWindow(this,this.getModelObject().getPeriod(),Optional.of(this.getModelObject().getSelectedCalculation())).openWithReturn();
			this.getModelObject().replaceSelectedCalculationWith(targetCalculation);	
			}
			});
		new Button(panel4).setCaption("Borrar Cuenta").onClick(()->{
			if(this.getModelObject().getSelectedYear() != null && this.getModelObject().getSelectedCalculation() != null)
			{
			this.getModelObject().deleteCalculation();	
			}
			});
		
		Table<Calculation> tableCalculations = new Table<Calculation>(mainPanel, Calculation.class);		
		tableCalculations.setNumberVisibleRows(10).bindItemsToProperty("calculations");
		tableCalculations.bindValueToProperty("selectedCalculation");
		tableCalculations.setHeight(300);
		tableCalculations.setWidth(600);
		
		Column<Calculation> columnCalculations = new Column<Calculation>(tableCalculations);
		columnCalculations.setTitle("Cuentas").bindContentsToProperty("name");
		
		Column<Calculation> columnValues = new Column<Calculation>(tableCalculations);
		columnValues.setTitle("Valores").bindContentsToProperty("value");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(()->{ 
			try
			{
				this.accept(); 	
			}
			catch( ExistingEnterpriseException|EmptyFieldException | EmptyEnterpriseException exception)
			{
				ErrorWindow.show(this, exception.getMessage());	
			}
		});
		
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	@Override
	protected void executeTask() {
		this.getModelObject().accept();
		super.executeTask();
	}
		
	public Optional<Enterprise> openWithReturn(){
		this.open();
		return getModelObject().getTargetEnterprise();
	}
	
	
}
