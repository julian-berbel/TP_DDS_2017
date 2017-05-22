package viewModel;

import java.util.List;
import java.util.Set;
import org.uqbar.commons.utils.Observable;
import exceptions.IndicatorFormulaIsEmptyException;
import exceptions.OperatorException;
import modelo.EnterpriseRepository;
import modelo.IndicatorsRepository;

@Observable
public class AddIndicatorsVM {
	
	private String filePath;
	private String newIndicator ="";
	private String indicatorFormula= "";
	private List<String> indicators;	
	private String selectedIndicator;
	private Set<String> calculations;
	private String selectedCalculation;
	private boolean formulaFlag = true;
	private List<String> usedCalculations;
	private List<String> usedIndicators;
	
	public AddIndicatorsVM(String filePath_)
	{
		filePath = filePath_;
		indicators= IndicatorsRepository.getIndicatorsNameList();
		calculations = EnterpriseRepository.getEnterprisesCalculationsName();
		
	}
	
	public String getFilePath() 
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public String getNewIndicator() 
	{
		return newIndicator;
	}

	public void setNewIndicator(String newIndicator) 
	{
		this.newIndicator = newIndicator;
		indicatorFormula = newIndicator + " = ";
	}

	public String getIndicatorFormula() 
	{
		return indicatorFormula;
	}
	
	public void setIndicatorFormula(String indicatorFormula) 
	{
		this.indicatorFormula = indicatorFormula;
	}
	
	public List<String> getIndicators() 
	{
		return indicators;
	}
	
	public void setIndicators(List<String> indicators) 
	{
		this.indicators = indicators;		
	}
	
	public String getSelectedIndicator() 
	{
		return selectedIndicator;
	}
	
	public void setSelectedIndicator(String selectedIndicator) 
	{
		this.selectedIndicator = selectedIndicator;
	}
	
	public Set<String> getCalculations() {
		return calculations;
	}
	
	public void setCalculations(Set<String> calculations) 
	{
		this.calculations = calculations;
	}
	
	public String getSelectedCalculation() 
	{
		return selectedCalculation;
	}
	
	public void setSelectedCalculation(String selectedCalculation) 
	{
		this.selectedCalculation = selectedCalculation;
	}
	
	public void addIndicatorToFormula()
	{
		if(indicatorFormula.isEmpty())
		{
			throw new IndicatorFormulaIsEmptyException("Debe introducir el nombre del nuevo indicador antes de agregar elementos a la formula");
		}else if(formulaFlag)
			{
				indicatorFormula = indicatorFormula.concat(selectedIndicator);
				formulaFlag = false;
			} else
			{
				throw new OperatorException("Debe introducir un operador antes de otro indicador");
			}
	}
	
	public void addCalculationToFormula()
	{
		if(indicatorFormula.isEmpty())
		{
			throw new IndicatorFormulaIsEmptyException("Debe introducir el nombre del nuevo indicador antes de agregar elementos a la formula");

		}else if(formulaFlag)
			{ 
				indicatorFormula = indicatorFormula.concat(selectedCalculation);
				formulaFlag = false;
			} else
			{
				throw new OperatorException("Debe introducir un operador antes de otra cuenta");
			}
		
	}	
	
	public void addPlusToFormula()
	{
		if(indicatorFormula.isEmpty())
		{
			throw new IndicatorFormulaIsEmptyException("Debe introducir el nombre del nuevo indicador antes de agregar elementos a la formula");

		}else if(formulaFlag)
			{
				throw new OperatorException("Debe introducir una cuenta o indicador antes de la suma");
			}
			else
			{
				indicatorFormula = indicatorFormula.concat(" + ");
				formulaFlag = true;
			}
		
	}
	
	public void addMinusToFormula()
	{
		if(indicatorFormula.isEmpty())
		{
			throw new IndicatorFormulaIsEmptyException("Debe introducir el nombre del nuevo indicador antes de agregar elementos a la formula");

		}else if(formulaFlag)
		{
			throw new OperatorException("Debe introducir una cuenta o indicador antes de la resta");
		}
		else
		{
			indicatorFormula = indicatorFormula.concat(" - ");
			formulaFlag = true;
		}
	}	
	
	public void addMultiplicationToFormula()
	{
		if(indicatorFormula.isEmpty())
		{
			throw new IndicatorFormulaIsEmptyException("Debe introducir el nombre del nuevo indicador antes de agregar elementos a la formula");

		}else if(formulaFlag)
		{
			throw new OperatorException("Debe introducir una cuenta o indicador antes de la multiplicacion");
		}
		else
		{
			indicatorFormula = indicatorFormula.concat(" * ");
			formulaFlag = true;
		}
	
	}
	
	public void addDivisionToFormula()
	{
		if(indicatorFormula.isEmpty())
		{
			throw new IndicatorFormulaIsEmptyException("Debe introducir el nombre del nuevo indicador antes de agregar elementos a la formula");

		}else if(formulaFlag)
		{
			throw new OperatorException("Debe introducir una cuenta o indicador antes de la suma");
		}
		else
		{
			indicatorFormula = indicatorFormula.concat(" / ");
			formulaFlag = true;
		}
	
	}
	
	public void limpiarCampos()
	{
		indicatorFormula = "";
		newIndicator = "";
		formulaFlag = true;
	}


/*	private List<String> indicators;	
	private String selectedIndicator;
	private Set<String> calculations;
	private String selectedCalculation;

	private List<String> usedCalculations;
	private List<String> usedIndicators;*/
/*	public void excepcion() esto esta al p2 parece
	{
		throw new IndicatorFormulaIsEmptyException("asdf");
	}*/
	
}
