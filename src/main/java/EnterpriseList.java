import java.util.List;
import java.util.ArrayList;

public class EnterpriseList 
{
	private List<Enterprise> enterpriseList;
	
	public EnterpriseList()
	{
		enterpriseList = new ArrayList<Enterprise>();
	}
	
	public void addEnterprise(Enterprise ent)
	{
		enterpriseList.add(ent);
	}
	
	public List<Enterprise> getEnterpriseList()
	{
		return enterpriseList;
	}

}
