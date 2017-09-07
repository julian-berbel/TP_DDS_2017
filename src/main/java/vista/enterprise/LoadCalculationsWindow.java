package vista.enterprise;

import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.JsonMappingException;
import exceptions.NoFileSelectedException;
import exceptions.ReadingFileException;
import exceptions.RepeatedEnterpriseFileException;
import viewModel.enterprise.LoadCalculationsVM;
import vista.ErrorWindow;

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
			catch(RepeatedEnterpriseFileException|ReadingFileException | JsonMappingException | NoFileSelectedException e)
			{
					ErrorWindow.show(this, e.getMessage());
			}	
		});

	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}
