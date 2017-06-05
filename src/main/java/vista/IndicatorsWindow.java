package vista;

import org.uqbar.arena.layout.VerticalLayout;

import java.util.Optional;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.DeleteUsedIndicatorException;
import exceptions.RepeatedIndicatorExcelException;
import exceptions.RepeatedIndicatorInSystemException;
import modelo.Indicator;
import viewModel.IndicatorsVM;


@SuppressWarnings("serial")
public class IndicatorsWindow extends SimpleWindow<IndicatorsVM> 
{
	public IndicatorsWindow(WindowOwner owner)
	{
		super(owner, new IndicatorsVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Indicadores");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(4));
		
		Table<Indicator> indicatorTable = new Table<Indicator>(panel1, Indicator.class);
		indicatorTable.bindItemsToProperty("indicators");
		indicatorTable.bindValueToProperty("selectedIndicator");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
				
		Column<Indicator> columnName = new Column<Indicator>(indicatorTable);
		columnName.setTitle("Indicador").setFixedSize(100).bindContentsToProperty("name");
		
		Column<Indicator> columnFormula = new Column<Indicator>(indicatorTable);
		columnFormula.setTitle("Formula").setFixedSize(500).bindContentsToProperty("formula");
		
		new Button(panel2).setCaption("Nuevo").onClick(()->{ 
				Optional<Indicator> newIndicator = new EditIndicatorWindow(this, Optional.empty()).openWithReturn();
				this.getModelObject().addNewIndicator(newIndicator);	
			});
		
		new Button(panel2).setCaption("Editar").onClick(()->{ 
				Optional<Indicator> targetIndicator = new EditIndicatorWindow(this, Optional.of(this.getModelObject().getSelectedIndicator())).openWithReturn();
				this.getModelObject().replaceSelectedIndicatorWith(targetIndicator);	
			});
		
		new Button(panel2).setCaption("Borrar").onClick(() -> {
			try{
				this.getModelObject().deleteIndicator();
			}catch(DeleteUsedIndicatorException exception){
				Error.show(this, exception.getMessage());
			}
		});
		
		new Button(panel2).setCaption("Cargar archivo")	
		.onClick(()->{ 
			try
			{
				new LoadIndicatorsWindow(this).open(); 
				this.getModelObject().refreshList();	
			}
			catch(RepeatedIndicatorExcelException repeatedIndicatorExcelException)
			{
				Error.show(this, "El indicador "+ repeatedIndicatorExcelException.getMessage() + " esta repetido en la hoja de excel, modifiquela y vuelva a cargar el archivo");
			}
			catch(RepeatedIndicatorInSystemException repeatedIndicatorInSystemException)
			{
				Error.show(this, "El indicador "+ repeatedIndicatorInSystemException.getMessage() + " de la hoja de excel, ya existe en el sistema, modifique el archivo y vuelva a cargar el archivo"			);
			}
			});
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}

