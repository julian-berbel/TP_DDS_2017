package vista;


import org.uqbar.arena.layout.VerticalLayout;

import java.util.Optional;


import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import exceptions.EmptyFieldException;
import exceptions.ExistingIndicatorException;
import exceptions.FormulaErrorException;
import exceptions.MissingIndicatorException;
import modelo.Indicator;
import modelo.Method;
import modelo.Criterion;
import viewModel.EditIndicatorVM;
import viewModel.EditMethodVM;

@SuppressWarnings("serial")
public class EditMethodWindow extends Dialog<EditMethodVM> {
	public EditMethodWindow(WindowOwner owner, Optional<Method> targetMethod)
	{
		super(owner, new EditMethodVM(targetMethod));
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Crear metodologia");
		
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Nombre de la nueva metodologia:");
	    new TextBox(panel1).setWidth(400).bindValueToProperty("name");
	    
	    new Label(panel1).setText("Criterios:");
	    
	    Table<Method> MethodTable = new Table<Method>(panel1, Method.class);
	    MethodTable.bindItemsToProperty("criteria");
	    MethodTable.bindValueToProperty("selectedCriteria");
	    MethodTable.setWidth(600);
		MethodTable.setHeight(400);
		MethodTable.setNumberVisibleRows(10);
		
		new Button(panel2).setCaption("Agregar criterio").onClick(()->{
			new SelectCriterionWindow(this).open();
		});
		
		new Button(panel2).setCaption("Borrar criterio seleccionado").onClick(()->{
			this.getModelObject().deleteCriteria();	
		});
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close); 
	}
	
	public Optional<Method> openWithReturn(){
		this.open();
		return getModelObject().getTargetMethod();
	}
}
