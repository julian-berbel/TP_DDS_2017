package vista.method;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.MethodResultVM;
import modelo.enterprise.Enterprise;
import modelo.method.Method;

@SuppressWarnings("serial")
public class MethodResultWindow  extends SimpleWindow<MethodResultVM> {
	
	public MethodResultWindow(WindowOwner owner, Method selectedMethod)
	{
		super(owner, new MethodResultVM(selectedMethod));
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		mainPanel.setLayout(new VerticalLayout());
		
		List<Enterprise> resultList = new List<Enterprise>(mainPanel);
		resultList.bindItemsToProperty("results");
		resultList.setWidth(600);
		resultList.setHeight(200);
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(()->this.close());
	}
	
}
