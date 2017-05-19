package vista;
import org.uqbar.arena.windows.MessageBox;
import viewModel.MainVM;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import java.lang.NullPointerException;

@SuppressWarnings("serial")
public class MainView extends MainWindow<MainVM>
{
	public MainView()
	{
		super(new MainVM());
	}
	
	@Override	
	public void createContents(Panel mainPanel)
	{
		this.setTitle("Pantalla Principal");
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
	
		new Button(panel1)
			.setCaption("Cargar Cuentas")
			.onClick(()->{ new LoadCalculationsWindow(this).open(); });
				
		new Button(panel1)
			.setCaption("Cargar Indicadores")
			.onClick(()->{ new LoadIndicatorsWindow(this).open(); });	
		
		new Button(panel1)
			.setCaption("Cargar Metodologia")
			.onClick(()->{ showFeatureNotAvailableMessage(); });	
		
		new Button(panel1)
			.setCaption("Consultar Indicadores")
			.onClick(()->{ showFeatureNotAvailableMessage(); });	
		
		new Button(panel1)
			.setCaption("Visualizar Graficos de Indicadores")
			.onClick(()->{ showFeatureNotAvailableMessage(); });	
		
		new Button(panel1)
			.setCaption("Consultar Cuentas")
			.onClick(()->{ 
				try
				{
					new ConsultAccountsWindow(this).open(); 	
				}
				catch(NullPointerException nullPointerException)
				{
					noFileLoadedMessage();	
				}});
		
		new Button(panel1)
			.setCaption("Analizar Empresa")
			.onClick(()->{ showFeatureNotAvailableMessage(); });	
	}
	
	
	private void showFeatureNotAvailableMessage()
	{
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Information);
		msgBox.setMessage("Esta funcionalidad aun no ha sido implementada!");
		msgBox.open();
	}
	
	private void noFileLoadedMessage()
	{
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage("No se ha cargado el archivo de cuentas");
		msgBox.open();
	}
	
	public static void main(String[] args)
	{
		new MainView().startApplication();
	}
}