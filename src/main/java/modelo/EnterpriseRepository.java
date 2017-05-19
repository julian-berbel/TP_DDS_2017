package modelo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class EnterpriseRepository 
{
	private static List<Enterprise> enterprises;
	
	public EnterpriseRepository()
	{
		enterprises = new ArrayList<Enterprise>();
	}
	
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
	
	public static List<String> getEnterprisesNameList()
	{
		return enterprises.stream().map(empresa -> empresa.getEnterpriseName()).collect(Collectors.toList());
	}
	
	public static List<String> getEnterprisePeriodsList(String enterpriseName)
	{		
		Enterprise searchedEnterprise = enterprises.stream().filter(enterprise -> enterprise.getEnterpriseName().equals(enterpriseName)).findFirst().get();

		return searchedEnterprise.getPeriodsNames();		
	}
	
	
	public static List<Calculation> getPeriodAccountList(String enterpriseName,String periodName)
	{
		Enterprise searchedEnterprise = enterprises.stream().filter(enterprise -> enterprise.getEnterpriseName().equals(enterpriseName)).findFirst().get();
		
		return searchedEnterprise.getPeriodCalculations(periodName);		
	}
	
	
}
