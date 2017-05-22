package vista;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import exceptions.IndicatorFormulaIsEmptyException;
import exceptions.OperatorException;
import modelo.Calculation;

import modelo.Indicator;
import viewModel.AddIndicatorsVM;


@SuppressWarnings("serial")
public class AddIndicatorsWindow extends SimpleWindow<AddIndicatorsVM> 
{
	public AddIndicatorsWindow(WindowOwner owner,String filePath)
	{
		super(owner, new AddIndicatorsVM(filePath));
	}



	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Agregar Indicadores");
		mainPanel.setLayout(new VerticalLayout());		
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());
		Panel panel2 = new Panel(mainPanel);
		panel2.setLayout(new ColumnLayout(2));
		Panel panel3 = new Panel(mainPanel);
		panel3.setLayout(new HorizontalLayout());
		
		new Label(panel1).setText("Nombre del nuevo indicador:");
	    new TextBox(panel1).setWidth(500).bindValueToProperty("newIndicator");
	    
	    List<Indicator> lstIndicators = new List<Indicator>(panel2);
	    lstIndicators.bindItemsToProperty("indicators");
	    lstIndicators.bindValueToProperty("selectedIndicator");
	    lstIndicators.setWidth(220);
	    lstIndicators.setHeight(220);
	    
	    List<Calculation> lstCalculations = new List<Calculation>(panel2);
	    lstCalculations.bindItemsToProperty("calculations");
	    lstCalculations.bindValueToProperty("selectedCalculation");
	    lstCalculations.setWidth(220);
	    lstCalculations.setHeight(220);
	    
	    new Button(panel2).setCaption("Agregar indicador a la formula").onClick(()->{
	    	try
	    	{
	    		this.getModelObject().addIndicatorToFormula(); 
	    	} 
	    	catch(IndicatorFormulaIsEmptyException indicatorFormulaIsEmptyException) 
	    	{
	    		this.IndicatorFormulaIsEmptyMessage(indicatorFormulaIsEmptyException.getMessage());
	    	}
	    	catch(OperatorException operatorException)
		    {
		    	this.missingOperatorMessage(operatorException.getMessage());
		    }
	    	catch(NullPointerException nullPointerException)
	    	{
	    		this.noIndicatorSelectedMessage();
	    	}
	    });
	    
	    new Button(panel2).setCaption("Agregar cuenta a la formula").onClick(()->{
	    	try
	    	{
	    		this.getModelObject().addCalculationToFormula(); 
	    	} 
	    	catch(IndicatorFormulaIsEmptyException indicatorFormulaIsEmptyException) 
	    	{
	    		this.IndicatorFormulaIsEmptyMessage(indicatorFormulaIsEmptyException.getMessage());
	    	}
	    	catch(OperatorException operatorException)
		    {
		    	this.missingOperatorMessage(operatorException.getMessage());
		    }
	    	catch(NullPointerException nullPointerException)
	    	{
	    		this.noCalculationSelectedMessage();
	    	}
	    });
	     
	    new Button(panel3).setCaption("\t\t\t+\t\t\t").onClick(()->{
	    	try
	    	{
	    		this.getModelObject().addPlusToFormula(); 
	    	} 
	    	catch(IndicatorFormulaIsEmptyException indicatorFormulaIsEmptyException) 
	    	{
	    		this.IndicatorFormulaIsEmptyMessage(indicatorFormulaIsEmptyException.getMessage());
	    	}
	    	catch(OperatorException operatorException)
		    {
		    	this.missingOperatorMessage(operatorException.getMessage());
		    }
	    });
	    	
	    new Button(panel3).setCaption("\t\t\t-\t\t\t").onClick(()->{
	    	try
	    	{
	    		this.getModelObject().addMinusToFormula(); 
	    	} 
	    	catch(IndicatorFormulaIsEmptyException indicatorFormulaIsEmptyException) 
	    	{
	    		this.IndicatorFormulaIsEmptyMessage(indicatorFormulaIsEmptyException.getMessage());
	    	}
	    	catch(OperatorException operatorException)
		    {
		    	this.missingOperatorMessage(operatorException.getMessage());
		    }
	    });
	    
	    new Button(panel3).setCaption("\t\t\t*\t\t\t").onClick(()->{
	    	try
	    	{
	    		this.getModelObject().addMultiplicationToFormula(); 
	    	} 
	    	catch(IndicatorFormulaIsEmptyException indicatorFormulaIsEmptyException) 
	    	{
	    		this.IndicatorFormulaIsEmptyMessage(indicatorFormulaIsEmptyException.getMessage());
	    	}
	    	catch(OperatorException operatorException)
		    {
		    	this.missingOperatorMessage(operatorException.getMessage());
		    }
	    });
	    
	    new Button(panel3).setCaption("\t\t\t/\t\t\t").onClick(()->{
	    	try
	    	{
	    		this.getModelObject().addDivisionToFormula(); 
	    	} 
	    	catch(IndicatorFormulaIsEmptyException indicatorFormulaIsEmptyException) 
	    	{
	    		this.IndicatorFormulaIsEmptyMessage(indicatorFormulaIsEmptyException.getMessage());
	    	}
	    	catch(OperatorException operatorException)
		    {
		    	this.missingOperatorMessage(operatorException.getMessage());
		    }
	    });
	    
	    new Label(mainPanel).setWidth(500).bindValueToProperty("indicatorFormula");
	    
		
	}
	
	private void IndicatorFormulaIsEmptyMessage(String mensaje)
	{
//		System.out.println(mensaje);  creo que esto esta de mas
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage(mensaje);
		msgBox.open();
	}
	
	private void missingOperatorMessage(String mensaje)
	{
		
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage(mensaje);
		msgBox.open();
	}
	
	private void noIndicatorSelectedMessage()
	{
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage("Seleccione el indicador que desea agregar");
		msgBox.open();
	}
	
	private void noCalculationSelectedMessage()
	{
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage("Seleccione la cuenta que desea agregar");
		msgBox.open();
	}
	
	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Volver").onClick(this:: close);
		
	}
}

