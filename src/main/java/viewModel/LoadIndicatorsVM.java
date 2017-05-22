package viewModel;

import java.io.IOException;

import org.uqbar.commons.utils.Observable;
import modelo.IndicatorsLoader;

@Observable
public class LoadIndicatorsVM {
	private String filePath;

	public LoadIndicatorsVM()
	{
		filePath = "";
	}
	
	
	
	public String getFilePath() 
	{
		
		return filePath;
	}

	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
		this.loadIndicators();
	}
	
	public void loadIndicators()
	{
		IndicatorsLoader indicatorsLoader = new IndicatorsLoader(filePath);
		try{
			indicatorsLoader.read();                   				// hay que catchear una excepcion del read que diga que el formato del archivo es invalido por que tiene que ser .xls
		}
		catch(IOException e)
		{
			// Hacer algo si lanza IO exception, no se que habria que informarle al cliente, por que no se si el lo podria solucionar. 
			// La del .xls si por que el tiene que cambiar el archivo.
		}
	}
	
	
	
}
