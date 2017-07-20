package vista.method;

import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
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
		
		List<Method> MethodList= new List<Method>(panel1);
		MethodList.bindItemsToProperty("methods");
		MethodList.bindValueToProperty("selectedMethod");
		MethodList.setWidth(300);
		
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
		
		new Button(panel2).setCaption("Ejecutar").onClick(()-> new MethodResultWindow(this, this.getModelObject().getSelectedMethod()).open());
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(()->this.close()); //hacer lo de guardar
	}
	
	
}
