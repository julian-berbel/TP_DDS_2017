package modelo;
import java.util.List;
import java.util.ArrayList;

public class RepoDeEmpresas 
{
	private static List<Enterprise> repoDeEmpresas;
	
	public RepoDeEmpresas()
	{
		repoDeEmpresas = new ArrayList<Enterprise>();
	}
	
	public static void addEnterprise(Enterprise ent)
	{
		repoDeEmpresas.add(ent);
	}
	
	public static List<Enterprise> getEnterpriseList()
	{
		return repoDeEmpresas;
	}
	public static void setEnterpriseList(List<Enterprise> enterprises) {
		repoDeEmpresas = enterprises;
	}
	
	public static List<String> getEnterprisesNameList()
	{
		List<String> enterpriseNameList= new ArrayList<String>();
		for(int index=0;index<(repoDeEmpresas.size());index++)
		{
			enterpriseNameList.add(repoDeEmpresas.get(index).getEnterpriseName());
		}
		return enterpriseNameList;
	}
	
	public static List<String> getEnterprisePeriodsList(String enterpriseName)
	{
		
		int index=0;
		while(repoDeEmpresas.get(index).getEnterpriseName()!=enterpriseName)
		{
			index++;			
		}
		
		return repoDeEmpresas.get(index).getPeriodsNames();
		
		
	}
	
	
	public static List<Calculation> getPeriodAccountList(String enterpriseName,String periodName)
	{
		
		int index213=0;
		while(repoDeEmpresas.get(index213).getEnterpriseName()!=enterpriseName)
		{
			index213++;			
		}
		
		return repoDeEmpresas.get(index213).getPeriodCalculations(periodName);
		
		
		
	}
	
	
}
