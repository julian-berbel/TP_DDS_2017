package vista.enterprise;

import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.EmptyFieldException;
import exceptions.ExistingCalculationException;
import exceptions.ExistingEnterpriseException;
import exceptions.ExistingIndicatorException;
import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;

import viewModel.enterprise.EditCalculationVM;
import vista.ErrorWindow;


@SuppressWarnings("serial")
public class EditCalculationWindow extends Dialog<EditCalculationVM> {

	public EditCalculationWindow(WindowOwner owner,Period period,Optional<Calculation> targetCalculation)
	{
		super(owner, new EditCalculationVM(period,targetCalculation));
	}	
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new VerticalLayout());
		
		new Label(panel1).setText("Nombre de la nueva cuenta:");
	    new TextBox(panel1).setWidth(200).bindValueToProperty("calculationName");
	    
	    new Label(panel1).setText("Valor de la cuenta:");
	    new NumericField(panel1).setWidth(150).bindValueToProperty("calculationValue");
	    
	    
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(()->{ 
			try
			{
				this.accept(); 	
			}
			catch(EmptyFieldException|ExistingCalculationException exception)
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
		
	public Optional<Calculation> openWithReturn(){
		this.open();
		return getModelObject().getTargetCalculation();
	}
	
	
}