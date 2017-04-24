
public class LoadCalculationsVM 
{
	private String filePath;
	
	public LoadCalculationsVM()
	{
		
	}
	
	public static void ParseFile()	//en realidad deberia devolver algo, pero todavía no se como armar el parser; tampoco se si esta bien que el VM haga esto o tiene que ser una clase aparte
	{
		
	}
	
	public void setFilePath(String path)
	{
		this.filePath = path;
	}
	public String getFilePath()
	{
		return filePath;
	}	
}
