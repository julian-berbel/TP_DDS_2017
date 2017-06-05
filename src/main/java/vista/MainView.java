package vista;

import modelo.EnterpriseRepository;
import modelo.IndicatorRepository;
import parser.IndicatorParser;
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
			.setCaption("Indicadores")
			.onClick(()->{ new IndicatorsWindow(this).open(); });	
		
		new Button(panel1)
			.setCaption("Cargar Metodologia")
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
			.onClick(()-> new AnalyzeEnterpriseWindow(this).open());	
	
		new Button(panel1)
		.setCaption("Guardar cambios")
		.onClick(()->{ new SaveChangesWindow(this).open(); });
		
	}	
	
	
	private void showFeatureNotAvailableMessage()
	{
		Error.show(this, "Esta funcionalidad aun no ha sido implementada!");
	}
	
	private void noFileLoadedMessage()
	{
		Error.show(this, "No se ha cargado el archivo de cuentas");
	}
	
	public static void main(String[] args)
	{
		new EnterpriseRepository();
		new IndicatorRepository();
		new IndicatorParser(System.in);
		new MainView().startApplication();
	}
}