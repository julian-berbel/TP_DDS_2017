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
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void parseFile()	
	{
		try
		{

			EnterpriseList enterpriseList = this.parseJson();
			Application.setEnterpriseList(enterpriseList); // la cargo en esa clase para que sea parte de una lista global de empresas		

			showLoadedData(enterpriseList);
		}
		catch(Exception e)
		{
			throw new UserException(e.toString()); //La SimpleWindow deberia tirar un messagebox cuando le tiro una UserException
			//e.printStackTrace();
		}
	}		

	private static void showLoadedData(EnterpriseList entlist) // lo muestro por consola; seria mas lindo por messagebox, pero se har�ｿｽa un lio si son muchos periodos

	{
		System.out.println("Estos fueron los datos extraidos del archivo:\n");
		for(Enterprise ent: entlist.getEnterpriseList()){
			System.out.println(ent.getEnterpriseName());
			
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
	
	private EnterpriseList parseJson() throws Exception

	{
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filePath));
		EnterpriseList enterprise = gson.fromJson(reader, EnterpriseList.class);		
		return enterprise;
	}
}
