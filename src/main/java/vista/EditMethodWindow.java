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

import modelo.method.Method;
import modelo.method.criteria.Criterion;
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
	    
	    Table<Method> CriteriaTable = new Table<Method>(panel1, Method.class);
	    CriteriaTable.bindItemsToProperty("criteria");
	    CriteriaTable.bindValueToProperty("selectedCriteria");
	    CriteriaTable.setWidth(600);
	    CriteriaTable.setHeight(400);
		CriteriaTable.setNumberVisibleRows(10);
		
	/* 
	 Problema: la tabla deberia ser Table<Criterion> pero si lo hago me pide que en modelo.Criterion haya un @Observable, y si pongo eso
	 me jode con que es una interfaz. Asi como esta ahora agrega los criterios (para probar eso primero hay que agregar indicadores al sistema y 
	  despues crear una metodologia con criterio de maximizar indicador), PERO los agrega con un nombre de mierda.
	 */
		
//		Column<Method> columnName = new Column<Method>(CriteriaTable);
//	columnName.setTitle("Criterio").setFixedSize(600).bindContentsToProperty("name");
		
		new Button(panel2).setCaption("Agregar criterio").onClick(()->{
			Criterion newCriterion = new SelectCriterionWindow(this).openWithReturn();
			
	/*     
	        Aca la idea era usar Optional<Criterion> pero cuando llego a MaximizeIndicatorCriterionWindow 
			 y pongo aceptar  me retorna un Criterion (porque estoy haciendo new MaximizeIndicatorCriterion()) 
			 Por eso lo deje de esta forma.
	 */
			
			
			this.getModelObject().addCriterion(newCriterion);
			this.getModelObject().refreshList();
			
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
