package modelo.enterprise;
import java.util.List;
import java.util.ArrayList;

public class EnterpriseRepository 
{
	private static List<Enterprise> enterprises = new ArrayList<Enterprise>();
	
	public static void addEnterprise(Enterprise ent)
	{
		enterprises.add(ent);
	}
	
	public static List<Enterprise> getEnterpriseList()
	{
		return enterprises;
	}
	
	public static void setEnterpriseList(List<Enterprise> _enterprises)
	{
		enterprises = _enterprises;
	}
	
}
