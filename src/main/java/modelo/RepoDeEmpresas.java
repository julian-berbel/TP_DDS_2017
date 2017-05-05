package modelo;
import java.util.List;
import java.util.stream.Collectors;
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
	public static void setEnterpriseList(List<Enterprise> enterprises)
	{
		repoDeEmpresas = enterprises;
	}
	
	public static List<String> getEnterprisesNameList()
	{
		return repoDeEmpresas.stream().map(empresa -> empresa.getEnterpriseName()).collect(Collectors.toList());
	}
	
	public static List<String> getEnterprisePeriodsList(String enterpriseName)
	{		
		Enterprise searchedEnterprise = repoDeEmpresas.stream().filter(enterprise -> enterprise.getEnterpriseName() == enterpriseName).findFirst().get();

		return searchedEnterprise.getPeriodsNames();		
	}
	
	
	public static List<Calculation> getPeriodAccountList(String enterpriseName,String periodName)
	{
		Enterprise searchedEnterprise = repoDeEmpresas.stream().filter(enterprise -> enterprise.getEnterpriseName() == enterpriseName).findFirst().get();
		
		return searchedEnterprise.getPeriodCalculations(periodName);		
	}
	
	
}
