package vista.method;

import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.Method;
import viewModel.method.MethodVM;

@SuppressWarnings("serial")
public class MethodWindow extends SimpleWindow<MethodVM> {
	
	public MethodWindow(WindowOwner owner)
	{
		super(owner, new MethodVM());
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Metodologias");
		mainPanel.setLayout(new VerticalLayout());
		
		List<Method> MethodList= new List<Method>(mainPanel);
		MethodList.bindItemsToProperty("methods");
		MethodList.bindValueToProperty("selectedMethod");
		MethodList.setWidth(300);
		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(4));
		
		new Button(panel1).setCaption("Nuevo").onClick(()->
		{
			Optional<Method> newMethod = new EditMethodWindow(this, Optional.empty()).openWithReturn();
			
			this.getModelObject().addNewMethod(newMethod);	
		});
		
		new Button(panel1).setCaption("Editar").onClick(()->{
			if(this.getModelObject().getSelectedMethod() != null){
				Optional<Method> targetMethod = new EditMethodWindow(this, Optional.of(this.getModelObject().getSelectedMethod())).openWithReturn();
				this.getModelObject().replaceSelectedMethodWith(targetMethod);
			}
		});
		
		new Button(panel1).setCaption("Borrar").onClick(()->this.getModelObject().deleteMethod());
		
		new Button(panel1).setCaption("Ejecutar").onClick(()-> new MethodResultWindow(this, this.getModelObject().getSelectedMethod()).open());
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close); //hacer lo de guardar
	}
	
	
}
