package vista;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import com.google.gson.JsonSyntaxException;

import exceptions.JsonMappingException;
import exceptions.NoFileSelectedException;
import exceptions.ReadingFileException;
import exceptions.RepeatedIndicatorExcelException;
import exceptions.RepeatedIndicatorInSystemException;
import jxl.read.biff.BiffException;
import viewModel.LoadCalculationsVM;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.FileSelector;


@SuppressWarnings("serial")
public class LoadCalculationsWindow extends SimpleWindow<LoadCalculationsVM>
{	
	public LoadCalculationsWindow(WindowOwner owner)
	{
		super(owner, new LoadCalculationsVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Cargar Cuentas");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Ruta de Archivo:");
	    new Label(mainPanel).setWidth(500).bindValueToProperty("filePath");
		new FileSelector(mainPanel).extensions("*.txt").setCaption("Elegir Archivo").bindValueToProperty("filePath");
		new Button(mainPanel).setCaption("Aceptar").onClick(()->{ 
			try
			{
				this.getModelObject().parseFile();
				this.close();
			}
			catch(ReadingFileException | JsonMappingException | NoFileSelectedException e)
			{
					Error.show(this, e.getMessage());
			}	
		});

	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}
