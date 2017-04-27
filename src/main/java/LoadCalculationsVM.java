import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class LoadCalculationsVM 
{
	private static String filePath;			// Los puse static porque me rompe las pelotas el 'parseFile'
	
	public LoadCalculationsVM()
	{
		
	}
	
	public void setFilePath(String path)
	{
		filePath = path;
	}
	public String getFilePath()
	{
		return filePath;
	}
	
	
	public static void parseFile()	
	{
		try
		{
			Enterprise enterprise = Parser.parseCalculations(filePath);
			Application.getEnterpriseList().addEnterprise(enterprise); //Hago que el parser me cargue la empresa en un objeto y la agrego a la lista. Entonces, cada vez que pongo para cargar los datos, crea otro objeto empresa y lo agrega a la lista... faltaria verificar si la empresa ya fue cargada, y de ser asi la elimino y la vuelvo a cargar (si no tengo que andar buscando si los periodos del archivo ya fueron cargados o no, y es un lio)		
			showLoadedData(enterprise);
		}
		catch(Exception e)
		{
			throw new UserException(e.toString()); //La SimpleWindow deberia tirar un messagebox cuando le tiro una UserException
		}
	}		

	private static void showLoadedData(Enterprise ent) // lo muestro por consola; seria mas lindo por messagebox, pero se haría un lio si son muchos periodos
	{
		System.out.println("Estos fueron los datos extraidos del archivo:\n" + ent.getEnterpriseName());
		
		for(Period p : ent.getPeriods())
		{
			System.out.println("Periodo: " + p.getPeriodName() + "\nCuentas:");
			
			for(Calculation c : p.getCalculations())
			{
				System.out.println(c.getName() + ": " + c.getValue());
			}
		}
		
	}
}
