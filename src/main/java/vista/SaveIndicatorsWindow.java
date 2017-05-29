package vista;


import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import jxl.read.biff.BiffException;
import modelo.Indicator;

import viewModel.SaveIndicatorsVM;



@SuppressWarnings("serial")
public class SaveIndicatorsWindow extends Dialog<SaveIndicatorsVM> 
{
	public SaveIndicatorsWindow(WindowOwner owner)
	{
		super(owner, new SaveIndicatorsVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());	
		
		Table<Indicator> indicatorTable = new Table<Indicator>(panel1, Indicator.class);
		indicatorTable.bindItemsToProperty("newIndicators");
		indicatorTable.bindValueToProperty("selectedIndicator");
		indicatorTable.setWidth(600);
		indicatorTable.setHeight(200);
		indicatorTable.setNumberVisibleRows(10);
				
		Column<Indicator> columnName = new Column<Indicator>(indicatorTable);
		columnName.setTitle("Nuevo indicador").setFixedSize(100).bindContentsToProperty("name");
	
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this:: accept);
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask() {
		try {
			this.getModelObject().SaveIndicators();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.executeTask();
	}
}

