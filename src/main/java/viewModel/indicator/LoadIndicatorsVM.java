package viewModel.indicator;
import java.io.IOException;

import jxl.read.biff.BiffException;
import modelo.indicator.IndicatorsManager;
import exceptions.NoFileSelectedException;;


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

	public void setFilePath(String filePath_) throws IOException, BiffException
	{
			this.filePath = filePath_;
	}
	
	public void loadIndicators() throws IOException, BiffException, NoFileSelectedException
	{
		if((filePath == "") || (filePath == null))		//Verifico ambos casos por las dudas
			throw new NoFileSelectedException();
		
		IndicatorsManager.setFilePath(filePath);	
		IndicatorsManager.read();		
	}	
}
