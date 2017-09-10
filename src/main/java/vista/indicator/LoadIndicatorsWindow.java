package vista.indicator;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.RepeatedIndicatorExcelException;
import exceptions.RepeatedIndicatorInSystemException;
import exceptions.NoFileSelectedException;
import jxl.read.biff.BiffException;
import viewModel.indicator.LoadIndicatorsVM;
import vista.ErrorWindow;

import java.io.IOException;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.FileSelector;


@SuppressWarnings("serial")
public class LoadIndicatorsWindow extends SimpleWindow<LoadIndicatorsVM>
{	
	public LoadIndicatorsWindow(WindowOwner owner)
	{
		super(owner, new LoadIndicatorsVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Cargar Indicadores");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Ruta de Archivo:");
	    new Label(mainPanel).setWidth(500).bindValueToProperty("filePath");
		new FileSelector(mainPanel).extensions("*.xls").setCaption("Elegir Archivo").bindValueToProperty("filePath");
		new Button(mainPanel).setCaption("Aceptar").onClick(()->{ 
			try
			{
				this.getModelObject().loadIndicators();
				this.close();
			}
			catch(IOException ioException)
			{
					ErrorWindow.show(this, "Error al abrir el archivo");
			}
			catch(BiffException biffException)
			{
				ErrorWindow.show(this, "Archivo invalido o no es un archivo Excel (.xls)");
			}
			catch(RepeatedIndicatorExcelException repeatedInExcel)
			{
				ErrorWindow.show(this, "El indicador: "+repeatedInExcel.getMessage()+" esta repetido en la hoja de excel, modifiquela y vuelva a cargar el archivo");
			}
			catch(RepeatedIndicatorInSystemException repeatedIndicator)
			{
				ErrorWindow.show(this, "El indicador: " + repeatedIndicator.getMessage()+" de la hoja de excel ya existe en el sistema. Modifique el archivo y vuelva a cargarlo");
			}
			catch(NoFileSelectedException ex)
			{
				ErrorWindow.show(this, ex.getMessage());
			}
			
		
		});
	}
	
	
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
	
	
}