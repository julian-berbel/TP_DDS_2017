package vista.method;

import org.uqbar.arena.layout.VerticalLayout;

import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import modelo.method.Method;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.OrderCriterion;
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
		
		new Label(mainPanel).setText("Nombre de la nueva metodologia:");
	    new TextBox(mainPanel).setWidth(400).bindValueToProperty("name");
		
		new Label(mainPanel).setText("Criterios de Filtro:");
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(2));
		
		new Label(mainPanel).setText("Criterios de Orden:");
		Panel panel3 = new Panel(mainPanel);
		panel3.setLayout(new VerticalLayout());
		Panel panel4 = new Panel(mainPanel);
		panel4.setLayout(new ColumnLayout(2));
		
		new Label(mainPanel).setText("Criterios Mixtos:");
		Panel panel5 = new Panel(mainPanel);
		panel5.setLayout(new VerticalLayout());
		Panel panel6 = new Panel(mainPanel);
		panel6.setLayout(new ColumnLayout(2));
		  
	    List<FilterCriterion> filterCriteriaList = new List<FilterCriterion>(panel1);
	    filterCriteriaList.bindItemsToProperty("filterCriteria");
	    filterCriteriaList.bindValueToProperty("selectedFilterCriterion");
	    filterCriteriaList.setWidth(400);
	    filterCriteriaList.setHeight(115);
		
		new Button(panel2).setCaption("Agregar criterio").onClick(()->{			
			this.getModelObject()
				.addFilterCriterion(new SelectFilterCriterionWindow(this).openWithReturn());
		});
		
		new Button(panel2).setCaption("Borrar criterio seleccionado").onClick(()->{
			this.getModelObject().deleteFilterCriterion();	
		});
		
		List<OrderCriterion> orderCriteriaTable = new List<OrderCriterion>(panel3);
		orderCriteriaTable.bindItemsToProperty("orderCriteria");
		orderCriteriaTable.bindValueToProperty("selectedOrderCriterion");
		orderCriteriaTable.setWidth(400);
		orderCriteriaTable.setHeight(115);
		
		new Button(panel4).setCaption("Agregar criterio").onClick(()->{
			OrderCriterion newCriterion = new SelectOrderCriterionWindow(this).openWithReturn();			
			
			this.getModelObject().addOrderCriterion(newCriterion);
		});
		
		new Button(panel4).setCaption("Borrar criterio seleccionado").onClick(()->{
				this.getModelObject().deleteOrderCriterion();	
			});
		
		List<MixedCriterion> mixedCriteriaTable = new List<MixedCriterion>(panel5);
		mixedCriteriaTable.bindItemsToProperty("mixedCriteria");
		mixedCriteriaTable.bindValueToProperty("selectedMixedCriterion");
		mixedCriteriaTable.setWidth(400);
		mixedCriteriaTable.setHeight(115);
		
		new Button(panel6).setCaption("Agregar criterio").onClick(()->{
			MixedCriterion newCriterion = new SelectMixedCriterionWindow(this).openWithReturn();			
			
			this.getModelObject().addMixedCriterion(newCriterion);
		});
		
		new Button(panel6).setCaption("Borrar criterio seleccionado").onClick(()->{
			this.getModelObject().deleteMixedCriterion();	
		});
		
		
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this::accept);
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
		
	@Override
	public void cancel(){
		this.getModelObject().cancel();
		super.cancel();
	}
	
	@Override
	protected void executeTask() {
		this.getModelObject().accept();
		super.executeTask();
	}
		
	public Optional<Method> openWithReturn(){
		this.open();
		return getModelObject().getTargetMethod();
	}
}
