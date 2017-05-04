package viewModel;
import java.io.FileNotFoundException;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import com.google.gson.JsonSyntaxException;
import exceptions.JsonMappingException;
import exceptions.ReadingFileException;
import modelo.FileLoader;
import modelo.JsonMapper;

@Observable
public class LoadCalculationsVM 
{
	private String filePath;
	
	public LoadCalculationsVM()
	{

		filePath = "";
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		this.parseFile();
	}

	public void parseFile()	
	{
		try
		{

			this.parseJson();
			//Application.setEnterpriseList(enterpriseList); // la cargo en esa clase para que sea parte de una lista global de empresas		
			
			
		}
		catch(ReadingFileException readingFileException)
		{
			throw new UserException(readingFileException.toString()); //La SimpleWindow deberia tirar un messagebox cuando le tiro una UserException
			//e.printStackTrace();
		}
		catch(JsonMappingException jsonMappingException)
		{
			throw new UserException(jsonMappingException.toString()); //La SimpleWindow deberia tirar un messagebox cuando le tiro una UserException
			//e.printStackTrace();
		}
		
	}		

	
	
	private void parseJson() 

	{
		try
		{
			FileLoader fileLoader = new FileLoader(filePath);
			JsonMapper jsonMapper = new JsonMapper();
			jsonMapper.mapper(fileLoader.reader());		
		
		}
		catch(FileNotFoundException fileReaderException)	
		{						
			throw new ReadingFileException("Error en la letura del archivo de Empresas");
		}
		
		catch(JsonSyntaxException jsonFormatException)
		{
			throw new JsonMappingException("Error en el formato del archivo de Empresas");
		}
		
		
		
		
	}
}
