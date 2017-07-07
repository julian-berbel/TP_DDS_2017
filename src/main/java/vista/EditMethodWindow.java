package vista;

import java.util.Optional;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;

import modelo.FilterCriteria;
import modelo.Method;
import viewModel.EditMethodVM;

public class EditMethodWindow extends SimpleWindow<EditMethodVM> {

	public EditMethodWindow(WindowOwner owner, Optional<Method> targetMethod)
	{
		super(owner, new EditMethodVM(targetMethod));
	}
	
	
	@Override
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Editar Metodologia");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new HorizontalLayout());
		
		new Label(panel1).setText("Nombre del método:");
		new TextBox(panel1).setWidth(200).bindValueToProperty("methodName");
		
		Table<FilterCriteria> criteriaTable = new Table<FilterCriteria>(panel1, FilterCriteria.class);
		criteriaTable.bindItemsToProperty("criteria");
		criteriaTable.bindValueToProperty("selectedCriteria");
		criteriaTable.setHeight(200);
		criteriaTable.setWidth(600);
		criteriaTable.setNumberVisibleRows(10);
		
		new Button(panel2).setCaption("Editar Criterio");
		new Button(panel2).setCaption("Eliminar Criterio");
	}

	
	public Optional<Method> openWithReturn()
	{
		return null;
	}

	@Override
	protected void addActions(Panel actionsPanel) 
	{
		
	}
}
