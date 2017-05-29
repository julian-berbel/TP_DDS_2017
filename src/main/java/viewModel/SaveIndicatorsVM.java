package viewModel;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import jxl.read.biff.BiffException;
import modelo.Indicator;
import modelo.IndicatorRepository;
import modelo.IndicatorsManager;

@Observable
public class SaveIndicatorsVM {
	
	private List<Indicator> newIndicators;	
	private Indicator selectedIndicator;
	
	public List<Indicator> getNewIndicators() 
	{
		return newIndicators;
	}

	public void setNewIndicators(List<Indicator> newIndicators) 
	{
		this.newIndicators = newIndicators;
	}

	public Indicator getSelectedIndicator() 
	{
		return selectedIndicator;
	}

	public void setSelectedIndicator(Indicator selectedIndicator) 
	{
		this.selectedIndicator = selectedIndicator;
	}

	
	public SaveIndicatorsVM()
	{
		newIndicators = IndicatorRepository.getNewIndicators();
	}

	public void SaveIndicators() throws BiffException 		//hay que hacerlo con try y catch con una excpcion nuestra (En realidad no por que esto es para que tire excepcion 
	{															//si el archivono es xls pero como ya se verifica en e momento de abrir el archivo en un principio)
		for(int index=0;index<newIndicators.size();index++)		//Hay que hacer un cartelito por si quiere guardar y no hay nada
		{
			IndicatorsManager.writeExcel(newIndicators.get(index));
		}		
	}
	
}
