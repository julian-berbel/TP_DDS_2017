
public class Application 
{
	private static EnterpriseList enterprises; // puse esto aca porque la lista de empresas es global a toda la aplicacion, no la puedo poner solo en un ViewModel
	
	public static void setEnterpriseList(EnterpriseList enterprises) {
		Application.enterprises = enterprises;
	}

	public static EnterpriseList getEnterpriseList()
	{
		return enterprises;
	}	
	
}
