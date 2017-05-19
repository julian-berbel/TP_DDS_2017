package modelo;

public class Application 
{
	private static EnterpriseRepository enterprises; // puse esto aca porque la lista de empresas es global a toda la aplicacion, no la puedo poner solo en un ViewModel
	
	public static void setEnterpriseList(EnterpriseRepository enterprises) {
		Application.enterprises = enterprises;
	}

	public static EnterpriseRepository getEnterpriseList()
	{
		return enterprises;
	}	
	
}
