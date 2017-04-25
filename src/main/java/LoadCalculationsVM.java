
public class LoadCalculationsVM 
{
	private static String filePath;			// los puse static porque me rompe las pelotas el 'parseFile'
	private static EnterpriseList enterprises;
	
	public LoadCalculationsVM()
	{
		enterprises = new EnterpriseList();
	}
	
	public static void parseFile()	//en realidad deberia devolver algo, pero todavía no se como armar el parser; tampoco se si esta bien que el VM haga esto o tiene que ser una clase aparte
	{
		Parser.parseCalculations(filePath, enterprises);		
	}													
															
	public void setFilePath(String path)
	{
		filePath = path;
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
		enterprise = ent;
	}
}
