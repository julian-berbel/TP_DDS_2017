package viewModel;
import java.io.IOException;
import org.uqbar.commons.utils.Observable;

import exceptions.RepeatedIndicatorExcelException;
import jxl.read.biff.BiffException;
import modelo.IndicatorsManager;


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

	public void setFilePath(String filePath_) throws IOException, BiffException
	{
			this.filePath = filePath_;
	}
	
	public void loadIndicators() throws IOException, BiffException
	{
		IndicatorsManager.setFilePath(filePath);	
		IndicatorsManager.read();		
	}	
}
