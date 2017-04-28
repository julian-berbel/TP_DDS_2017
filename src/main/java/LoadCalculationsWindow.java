import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
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
		new FileSelector(mainPanel).setCaption("Elegir Archivo").bindValueToProperty("filePath");
		new Button(mainPanel).setCaption("Cargar Archivo").onClick(()->{ this.getModelObject().parseFile(); }); //El onClick pide algo que devuelva 'Action';
																											 	//El ()->{} es una lambda		
																												//this.getModelObject() me devuelve el ViewModel de esta vista (especificado arriba en el super del contsructor)

	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}
