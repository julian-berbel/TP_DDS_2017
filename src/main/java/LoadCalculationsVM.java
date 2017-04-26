import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class LoadCalculationsVM 
{
	private static String filePath;			// los puse static porque me rompe las pelotas el 'parseFile'
	private static EnterpriseList enterprises;
	
	public LoadCalculationsVM()
	{
		enterprises = new EnterpriseList();
	}
	
	public static void parseFile()	
	{
		try
		{
			enterprises.addEnterprise(Parser.parseCalculations(filePath)); // hago que el parser me cargue la empresa en un objeto y la agrego a la lista, entonces cada vez que pongo para cargar los datos, crea otro objeto empresa y lo agrega a la lista... faltaria verificar si la empresa ya fue cargada, y de ser asi la elimino y la vuelvo a cargar (si no tengo que andar buscando si los periodos del archivo ya fueron cargados o no, y es un lio)		
		}
		catch(Exception e)
		{
			throw new UserException(e.toString()); // se supone que la simpleWindow me tira un messagebox cuando tiro una UserException
		}
	}	
	
	public void setFilePath(String path)
	{
		filePath = path;
	}
	public String getFilePath()
	{
		return filePath;
	}
}
