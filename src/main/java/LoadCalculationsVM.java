
public class LoadCalculationsVM 
{
	private String filePath;
	Enterprise enterprise;
	
	public LoadCalculationsVM()
	{
		enterprise = new Enterprise();
	}
	
	public static void parseFile()	//en realidad deberia devolver algo, pero todavía no se como armar el parser; tampoco se si esta bien que el VM haga esto o tiene que ser una clase aparte
	{
		Parser.parseCalculations(filePath, enterprise);		//tengo problemas con el static; si no se lo pongo a este metodo, no me deja llamarlo desde la vista
	}														//si intento crear un objeto de esta clase en la vista e instanciarlo en el constructor, no me deja
															//el sacarle el static al metodo del parser no cambia nada, el problema está acá	
	public void setFilePath(String path)
	{
		this.filePath = path;
	}
	public String getFilePath()
	{
		return filePath;
	}	
	public Enterprise getEnterprise()
	{
		return enterprise;
	}
	public void setEnterprise(Enterprise ent)
	{
		this.enterprise = ent;
	}
}
