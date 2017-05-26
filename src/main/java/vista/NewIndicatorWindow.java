package vista;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.NewIndicatorVM;


@SuppressWarnings("serial")
public class NewIndicatorWindow extends Dialog<NewIndicatorVM> 
{
	public NewIndicatorWindow(WindowOwner owner)
	{
		super(owner, new NewIndicatorVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Nuevo Indicador");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new VerticalLayout());
		
		new Label(panel1).setText("Nombre del nuevo indicador:");
	    new TextBox(panel1).setWidth(500).bindValueToProperty("name");
	    
	    new Label(panel1).setText("Formula del nuevo indicador:");
	    new TextBox(panel1).setWidth(500).bindValueToProperty("formula");
	    
	    new Label(panel2).setText("Referencia:\nIndicadores: @<nombre del indicador>\nCuentas: #<nombre de la cuenta>");
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this:: accept);
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask() {
		this.getModelObject().newIndicator();
		super.executeTask();
	}
}

