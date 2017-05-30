package viewModel;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import jxl.read.biff.BiffException;
import modelo.Indicator;
import modelo.IndicatorRepository;
import modelo.IndicatorsManager;

@Observable
public class SaveIndicatorsVM {
	
	

	public void SaveIndicators() throws BiffException 		//hay que hacerlo con try y catch con una excpcion nuestra (En realidad no por que esto es para que tire excepcion 
	{														//si el archivono es xls pero como ya se verifica en e momento de abrir el archivo en un principio)
															//Hay que hacer un cartelito por si quiere guardar y no hay nada
		
			IndicatorsManager.writeExcel();
				
	}
	
}
