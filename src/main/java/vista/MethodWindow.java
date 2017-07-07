package vista;


import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.MethodVM;
import modelo.method.Method;


@SuppressWarnings("serial")
public class MethodWindow  extends SimpleWindow<MethodVM> {
	
	public MethodWindow(WindowOwner owner)
	{
		super(owner, new MethodVM());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Metodologias");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(4));
		
		Table<Method> MethodTable = new Table<Method>(panel1, Method.class);
		MethodTable.bindItemsToProperty("method");
		MethodTable.bindValueToProperty("selectedMethod");
		MethodTable.setWidth(600);
		MethodTable.setHeight(200);
		MethodTable.setNumberVisibleRows(10);
				
		Column<Method> columnName = new Column<Method>(MethodTable);
		columnName.setTitle("Metodologia").setFixedSize(300).bindContentsToProperty("name");
		
		
		new Button(panel2).setCaption("Nuevo").onClick(()->
		{
			Optional<Method> newMethod = new EditMethodWindow(this, Optional.empty()).openWithReturn();
			if(newMethod != null)
			{
				this.getModelObject().addNewMethod(newMethod);	
			} 
			
		});
		
		new Button(panel2).setCaption("Editar").onClick(()->{ });
		
		new Button(panel2).setCaption("Borrar").onClick(()->{});
		
		new Button(panel2).setCaption("Ejecutar").onClick(()->{ });
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(()->this.close()); //hacer lo de guardar
	}
	
	
}
