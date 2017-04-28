import java.io.FileReader;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@Observable
public class LoadCalculationsVM 
{
	private String filePath;
	
	public LoadCalculationsVM()
	{
		filePath = "";
	}
	
	public void setFilePath(String path)
	{
		filePath = path;
	}
	public String getFilePath()
	{
		return filePath;
	}
	
	
	public void parseFile()	
	{
		try
		{
			Enterprise enterprise = parseJson();
			Application.getEnterpriseList().addEnterprise(enterprise); // la cargo en esa clase para que sea parte de una lista global de empresas		
			showLoadedData(enterprise);
		}
		catch(Exception e)
		{
			throw new UserException(e.toString()); //La SimpleWindow deberia tirar un messagebox cuando le tiro una UserException
			//e.printStackTrace();
		}
	}		

	private void showLoadedData(Enterprise ent) // lo muestro por consola; seria mas lindo por messagebox, pero se haría un lio si son muchos periodos
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
	
	private Enterprise parseJson() throws Exception
	{
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filePath));
		Enterprise enterprise = gson.fromJson(reader, Enterprise.class);		
		return enterprise;
	}
}
