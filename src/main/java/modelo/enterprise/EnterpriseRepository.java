package modelo.enterprise;

import java.util.ArrayList;
import java.util.List;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import exceptions.RepeatedEnterpriseFileException;

public class EnterpriseRepository implements WithGlobalEntityManager
{
	private static String filePath;
	
	private static Boolean fileLoaded= false;
	private static List<Enterprise> enterprises = new ArrayList<Enterprise>();
	
	public static String getFilePath() {
		return filePath;
	}
	public static void setFilePath(String filePath) {
		EnterpriseRepository.filePath = filePath;
	}
	public static Boolean getFileLoaded() {
		return fileLoaded;
	}
	public static void addEnterprise(Enterprise ent)
	{
//		entityManager().persist(ent); creo que dijeron que tenemos que hacer un repositorio para la persistencia,
		enterprises.add(ent);		// no persistir desde cada clase	
	}
	
	public static List<Enterprise> getEnterpriseList()
	{
		return enterprises;
	}
	
	public static void setEnterpriseList(List<Enterprise> enterprises2)
	{
		if(enterprises.isEmpty())
		{
			
			enterprises = enterprises2;
		}
		else
		{
			
			if(enterprises.stream()
					.anyMatch(enterprise->
						enterprises2.stream()
							.anyMatch(aEnterprise->
								aEnterprise.getName()
									.equals(enterprise.getName())))) throw new RepeatedEnterpriseFileException("El archivo contiene una o mas empresas con un nombre ya cargado, modifiquelo y vuelva a cargar");
			else enterprises.addAll(enterprises2);
		}
		fileLoaded=true;
	}
	
	public static Boolean alreadyExists(String newEnterpriseName)
	{
		
		return enterprises.stream()
			.map(enterprise -> enterprise.getName())
			.anyMatch(enterpriseName->enterpriseName.equals(newEnterpriseName));
	}
	
	public static void replaceEnterprise(Enterprise oldEnterprise, Enterprise newEnterprise)
	{
		enterprises.replaceAll(enterprise -> enterprise == oldEnterprise ? newEnterprise:enterprise);
	}
	
	public static void deleteEnterprise(Enterprise enterprise)
	{
		enterprises.remove(enterprise);
	}
}
