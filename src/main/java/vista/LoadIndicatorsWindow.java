package vista;

import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import viewModel.LoadCalculationsVM;
import viewModel.LoadIndicatorsVM;

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
		new FileSelector(mainPanel).setCaption("Elegir Archivo").bindValueToProperty("filePath");
//		new Button(mainPanel).setCaption("Cargar Archivo").onClick(()->{ this.getModelObject().parseFile(); }); //El onClick pide algo que devuelva 'Action';
																											 	//El ()->{} es una lambda		
																												//this.getModelObject() me devuelve el ViewModel de esta vista (especificado arriba en el super del contsructor)
		
	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}