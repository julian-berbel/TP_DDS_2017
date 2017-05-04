package modelo;

public class Application 
{
	private static RepoDeEmpresas enterprises; // puse esto aca porque la lista de empresas es global a toda la aplicacion, no la puedo poner solo en un ViewModel
	
	public static void setEnterpriseList(RepoDeEmpresas enterprises) {
		Application.enterprises = enterprises;
	}

	public static RepoDeEmpresas getEnterpriseList()
	{
		return enterprises;
	}	
	
}
