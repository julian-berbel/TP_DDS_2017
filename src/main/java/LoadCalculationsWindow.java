import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
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
		
		Panel panel1 = new Panel(mainPanel);
		Panel panel2 = new Panel(mainPanel);
		panel1.setLayout(new HorizontalLayout());
		panel2.setLayout(new HorizontalLayout());
		
		
		new Label(panel1).setText("Ruta de Archivo:");
		new TextBox(panel1).setWidth(200).bindValueToProperty("filePath");
		new FileSelector(panel1).setCaption("Elegir Archivo...").bindValueToProperty("filePath");
		new Button(panel1).setCaption("Cargar").onClick(()->{LoadCalculationsVM.parseFile();}); //el onClick pide algo que devuelva 'Action'; parece que el hacer ese juego de simbolos me permite ejecutar el metodo que quiero
		
		// me falta agregar algo para mostrar lo que saca del archivo; el parser debería separar el texto del archivo en tokens o lo que sea, o podría cargar al data en memoria directamente
	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}
