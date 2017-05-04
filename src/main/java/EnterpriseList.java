import java.util.List;
import java.util.ArrayList;

public class EnterpriseList 
{
	private static List<Enterprise> enterpriseList;
	
	public EnterpriseList()
	{
		enterpriseList = new ArrayList<Enterprise>();
	}
	
	public static void addEnterprise(Enterprise ent)
	{
		enterpriseList.add(ent);
	}
	
	public static List<Enterprise> getEnterpriseList()
	{
		return enterpriseList;
	}
	public static void setEnterpriseList(List<Enterprise> enterprises) {
		enterpriseList = enterprises;
	}
	
	public static List<String> getEnterprisesNameList()
	{
		List<String> enterpriseNameList= new ArrayList<String>();
		for(int index=0;index<(enterpriseList.size());index++)
		{
			enterpriseNameList.add(enterpriseList.get(index).getEnterpriseName());
		}
		return enterpriseNameList;
	}
	
	public static List<String> getEnterprisePeriodsList(String enterpriseName)
	{
		
		int index=0;
		while(enterpriseList.get(index).getEnterpriseName()!=enterpriseName)
		{
			index++;			
		}
		
		return enterpriseList.get(index).getPeriodsNames();
		
		
	}
	
	
	public static List<Calculation> getPeriodAccountList(String enterpriseName,String periodName)
	{
		
		int index213=0;
		while(enterpriseList.get(index213).getEnterpriseName()!=enterpriseName)
		{
			index213++;			
		}
		
		return enterpriseList.get(index213).getPeriodCalculations(periodName);
		
		
		
	}
	
	
}
