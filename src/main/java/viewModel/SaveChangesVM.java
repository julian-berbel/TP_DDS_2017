package viewModel;
import java.io.IOException;

import org.uqbar.commons.utils.Observable;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import modelo.IndicatorsManager;

@Observable
public class SaveChangesVM {
	
	//hay que hacerlo con try y catch con una excpcion nuestra (En realidad no por que esto es para que tire excepcion 
	//si el archivono es xls pero como ya se verifica en e momento de abrir el archivo en un principio)
	//Hay que hacer un cartelito por si quiere guardar y no hay nada

	public void SaveIndicators() throws BiffException, WriteException, IOException		
	{	
			IndicatorsManager.writeExcel();
	}
	
}
