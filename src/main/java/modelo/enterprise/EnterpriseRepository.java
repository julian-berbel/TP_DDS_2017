package modelo.enterprise;

import java.util.ArrayList;
import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import exceptions.RepeatedEnterpriseFileException;

public class EnterpriseRepository implements WithGlobalEntityManager
{
	private static EnterpriseRepository instance;

	private String filePath;

	private Boolean fileLoaded= false;
	private List<Enterprise> enterprises = new ArrayList<Enterprise>();

	public static EnterpriseRepository getInstance(){
		if(instance == null)
			instance = new EnterpriseRepository();

		return instance;
	}

	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public Boolean getFileLoaded() {
		return fileLoaded;
	}
	
	public void addEnterprise(Enterprise ent)
	{
		enterprises.add(ent);		// no persistir desde cada clase
	}
	
	public List<Enterprise> getEnterpriseList()
	{
		return enterprises;
	}
	
	public void setEnterpriseList(List<Enterprise> enterprises2)
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
	
	public Boolean alreadyExists(String newEnterpriseName)
	{
		
		return enterprises.stream()
			.map(enterprise -> enterprise.getName())
			.anyMatch(enterpriseName->enterpriseName.equals(newEnterpriseName));
	}
	
	public void replaceEnterprise(Enterprise oldEnterprise, Enterprise newEnterprise)
	{
		enterprises.replaceAll(enterprise -> enterprise == oldEnterprise ? newEnterprise:enterprise);
	}
	
	public void deleteEnterprise(Enterprise enterprise)
	{
		enterprises.remove(enterprise);
	}
}
