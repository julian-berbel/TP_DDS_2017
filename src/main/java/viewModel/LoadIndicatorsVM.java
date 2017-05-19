package viewModel;

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
		
	}
	
	
	
}
