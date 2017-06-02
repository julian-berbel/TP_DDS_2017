package vista;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.FormulaErrorException;
import exceptions.MissingFormulaException;
import exceptions.MissingIndicatorException;
import exceptions.RepeatedIndicatorNameException;
import modelo.Indicator;

import viewModel.EditIndicatorVM;


@SuppressWarnings("serial")
public class EditIndicatorWindow extends Dialog<EditIndicatorVM> 
{
	public EditIndicatorWindow(WindowOwner owner, Indicator indicadorAEditar)
	{
		super(owner, new EditIndicatorVM(indicadorAEditar));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new VerticalLayout());
		
		new Label(panel1).setText("Nombre del nuevo indicador:");
	    new TextBox(panel1).setWidth(200).bindValueToProperty("name");
	    
	    new Label(panel1).setText("Formula del nuevo indicador:");
	    new TextBox(panel1).setWidth(200).bindValueToProperty("formula");
	    
	    new Label(panel2).setText("Referencia:\nIndicadores: @<nombre del indicador>\nCuentas: #<nombre de la cuenta>");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(()->{ 
			try
			{
				this.accept(); 	
			}
			catch(FormulaErrorException formulaErrorException)
			{
				messageBox(formulaErrorException.getMessage());	
			}
			catch (MissingIndicatorException missingIndicatorException)	
			{				
				
				messageBox("El indicador @"+ missingIndicatorException.getMessage() + " no existe" );
				
			}
			catch(MissingFormulaException missingFormulaException)
			{
				messageBox("Debe introducir una formula para el nuevo indicador");
			}
			catch(RepeatedIndicatorNameException repeatedIndicatorNameException)
			{			
				messageBox("El nombre de indicador "+repeatedIndicatorNameException.getMessage()+" ya fue utilizado, introduzca otro nombre");
			}
			});
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask() {
		this.getModelObject().newIndicator();
		super.executeTask();
	}

	private void messageBox(String message)
	{
		
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage(message);
		msgBox.open();
	}
	
}

