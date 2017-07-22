package vista;

import viewModel.MainVM;
import vista.enterprise.ConsultAccountsWindow;
import vista.enterprise.LoadCalculationsWindow;
import vista.indicator.AnalyzeEnterpriseWindow;
import vista.indicator.IndicatorsWindow;
import vista.method.MethodWindow;

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
			.onClick(()->{ new LoadCalculationsWindow(this).open(); })
			.setWidth(300);
				
		new Button(panel1)
			.setCaption("Indicadores")
			.onClick(()->{ new IndicatorsWindow(this).open(); })
			.setWidth(300);	
		
		new Button(panel1)
			.setCaption("Metodologias")
			.onClick(()->{ new MethodWindow(this) .open();})
			.setWidth(300);	
		
		new Button(panel1)
			.setCaption("Visualizar Graficos de Indicadores")
			.onClick(()->{ showFeatureNotAvailableMessage(); })
			.setWidth(300);	
		
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
				}})
			.setWidth(300);
		
		new Button(panel1)
			.setCaption("Analizar Empresa")
			.onClick(()-> new AnalyzeEnterpriseWindow(this).open())
			.setWidth(300);		
	}	
	
	
	private void showFeatureNotAvailableMessage()
	{
		ErrorWindow.show(this, "Esta funcionalidad aun no ha sido implementada!");
	}
	
	private void noFileLoadedMessage()
	{
		ErrorWindow.show(this, "No se ha cargado el archivo de cuentas");
	}
	
	public static void main(String[] args)
	{
		new MainView().startApplication();
	}
}