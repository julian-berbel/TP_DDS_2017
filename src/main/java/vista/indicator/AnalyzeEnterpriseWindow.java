package vista.indicator;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import viewModel.AnalyzeEnterpriseVM;

@SuppressWarnings("serial")
public class AnalyzeEnterpriseWindow extends SimpleWindow<AnalyzeEnterpriseVM>
{	
	public AnalyzeEnterpriseWindow(WindowOwner owner)
	{
		super(owner, new AnalyzeEnterpriseVM());
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle("Analizar Empresa");
		mainPanel.setLayout(new VerticalLayout());		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new ColumnLayout(2));
		
		new Label(panel1).setText("Empresas");
		new Label(panel1).setText("Periodos");
		
		List<Enterprise> lstEnterprises = new List<Enterprise>(panel1);
		lstEnterprises.bindItemsToProperty("enterprises");
		lstEnterprises.bindValueToProperty("selectedEnterprise");
		lstEnterprises.setWidth(220);
		lstEnterprises.setHeight(220);
		
		List<Period> lstPeriods = new List<Period>(panel1);
		lstPeriods.bindItemsToProperty("periods");
		lstPeriods.bindValueToProperty("selectedPeriod");
		lstPeriods.setWidth(220);
		lstPeriods.setHeight(220);
		
		Panel panel3 = new Panel(panel1);
		new Label(panel3).setText("Indicadores");
		
		List<Indicator> indicators = new List<Indicator>(panel3);
		indicators.bindItemsToProperty("indicators");
		indicators.bindValueToProperty("selectedIndicator");
		indicators.setWidth(220);
		indicators.setHeight(220);
		
		Panel panel2 = new Panel(panel1);
		panel2.setLayout(new VerticalLayout());
		
		new Label(panel2).setText("valor:");
		new Label(panel2).setText("").bindValueToProperty("value");
	}
	
	@Override	
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
	}
}
