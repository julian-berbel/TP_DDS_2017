package viewModel;
import java.io.IOException;
import org.uqbar.commons.utils.Observable;
import org.uqbar.arena.windows.MessageBox;
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
		try
		{
			this.filePath = filePath_;
			if(filePath != null)
			{
				this.loadIndicators();
			}	
		}
		catch(IOException e)		// no se si habrá forma de pasar esto a la vista, ya que no tengo forma de controlar el bindValueToPropery (o si?)
		{
			System.out.println("\nError al abrir el archivo\n");
			e.printStackTrace();
		}
		catch(BiffException e)
		{
			System.out.println("\nEl archivo indicado no es valido o no es un archivo Excel (.xls)\n");
			e.printStackTrace();
		}
	}
	
	public void loadIndicators() throws IOException, BiffException
	{
		IndicatorsManager.setFilePath(filePath);	
		IndicatorsManager.read();		
	}	
}
