package vista.method;

import org.uqbar.arena.layout.VerticalLayout;

import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.EmptyFieldException;
import modelo.method.Method;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.OrderCriterion;
import viewModel.method.EditMethodVM;
import vista.ErrorWindow;

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
		
		List<FilterCriterion> filterCriteriaList = new List<FilterCriterion>(mainPanel);
	    filterCriteriaList.bindItemsToProperty("filterCriteria");
	    filterCriteriaList.bindValueToProperty("selectedFilterCriterion");
	    filterCriteriaList.setWidth(400);
	    filterCriteriaList.setHeight(100);
	    
		Panel panel2 = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		
		new Button(panel2).setCaption("Agregar criterio").onClick(()->{			
			this.getModelObject().addFilterCriterion(new SelectFilterCriterionWindow(this).openWithReturn());
		});
		
		new Button(panel2).setCaption("Borrar criterio seleccionado").onClick(()->{
			this.getModelObject().deleteFilterCriterion();	
		});
				
		new Label(mainPanel).setText("Criterios de Orden:");
		Panel panel3 = new Panel(mainPanel).setLayout(new HorizontalLayout());
		
		List<OrderCriterion> orderCriteriaTable = new List<OrderCriterion>(panel3);
		orderCriteriaTable.bindItemsToProperty("orderCriteria");
		orderCriteriaTable.bindValueToProperty("selectedOrderCriterion");
		orderCriteriaTable.setWidth(370);
		orderCriteriaTable.setHeight(100);

		Panel panel4 = new Panel(panel3).setLayout(new VerticalLayout());
		
		new Button(panel4).setCaption("ª").onClick(()->{
			this.getModelObject().switchUp();
		});
		
		new Button(panel4).setCaption("«").onClick(()->{
			this.getModelObject().switchDown();
		});
		
		Panel panel5 = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		
		new Button(panel5).setCaption("Agregar criterio").onClick(()->{
			this.getModelObject().addOrderCriterion(new SelectOrderCriterionWindow(this).openWithReturn());
		});
		
		new Button(panel5).setCaption("Borrar criterio seleccionado").onClick(()->{
			this.getModelObject().deleteOrderCriterion();	
		});
		
		new Label(mainPanel).setText("Criterios Mixtos:");
		
		List<MixedCriterion> mixedCriteriaTable = new List<MixedCriterion>(mainPanel);
		mixedCriteriaTable.bindItemsToProperty("mixedCriteria");
		mixedCriteriaTable.bindValueToProperty("selectedMixedCriterion");
		mixedCriteriaTable.setWidth(400);
		mixedCriteriaTable.setHeight(100);
		
		Panel panel6 = new Panel(mainPanel).setLayout(new ColumnLayout(2));
		
		new Button(panel6).setCaption("Agregar criterio").onClick(()->{
			this.getModelObject().addMixedCriterion(new SelectMixedCriterionWindow(this).openWithReturn());
		});
		
		new Button(panel6).setCaption("Borrar criterio seleccionado").onClick(()->{
			this.getModelObject().deleteMixedCriterion();	
		});
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(() -> {
			try{
				accept();
			} catch(EmptyFieldException e){
				ErrorWindow.show(this, e);
			}
		});
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
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
