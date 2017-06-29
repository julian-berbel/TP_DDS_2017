package vista;

import java.io.IOException;
import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.DeleteUsedIndicatorException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import viewModel.MethodVM;
import modelo.Method;


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
		
		Table<Method> indicatorTable = new Table<Method>(panel1, Method.class);
		indicatorTable.bindItemsToProperty("method");
		indicatorTable.bindValueToProperty("selectedMethod");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
				
		Column<Method> columnName = new Column<Method>(indicatorTable);
		columnName.setTitle("Metodologia").setFixedSize(100).bindContentsToProperty("name");
		
		Column<Method> columnFormula = new Column<Method>(indicatorTable);
		columnFormula.setTitle("Formula").setFixedSize(500).bindContentsToProperty("formula");
		
		new Button(panel2).setCaption("Nuevo").onClick(()->{});
		
		new Button(panel2).setCaption("Editar").onClick(()->{ });
		
		new Button(panel2).setCaption("Borrar").onClick(()->{});
		
		new Button(panel2).setCaption("Ejecutar").onClick(()->{ });
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(()->this.close()); //hacer lo de guardar
	}
	
/*	private void verifyChangesAndSave()
	{
		//Verifico si se hicieron cambios
		if(this.getModelObject().verifyIfSomethingChanged())
		{
			//Si se hicieron cambios, muestro un dialogo preguntando si se quieren guardar esos cambios
			//Luego guardo los cambios o salgo de la ventana, dependiendo de la eleccion del usuario
			
			SaveChangesWindow window = new SaveChangesWindow(this);			
			window.onAccept(()->applySave());
			window.open();
		}		
		
		this.close();
	}
	
	private void applySave()
	{
		try
		{				
			this.getModelObject().saveChanges();
		}
		catch(BiffException e)	//es la excepcion que tira al invocar el metodo, que a su vez contiene la excepcion que tira el metodo
		{	
			Error.show(this, "El archivo no existe o no es un archivo '.xls'  ");
			e.printStackTrace();
		}
		catch(WriteException e)
		{
			Error.show(this, "No se a podido modificar el archivo");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			Error.show(this, "El archivo que se intenta abrir no existe");
			e.printStackTrace();
		}
		
	}*/
	
}
