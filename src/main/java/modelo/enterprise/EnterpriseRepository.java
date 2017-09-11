package modelo.enterprise;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;
import java.util.stream.Collectors;


import exceptions.RepeatedEnterpriseFileException;

import java.util.ArrayList;

public class EnterpriseRepository implements WithGlobalEntityManager
{
	private static EnterpriseRepository repository;


	private String filePath;
	

	private Boolean fileLoaded= false;
	private List<Enterprise> enterprises = new ArrayList<Enterprise>();
	

	public static EnterpriseRepository getInstance(){
		if(repository == null)
			repository = new EnterpriseRepository();

		return repository;
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
		if(enterprises.size()==0)
		{
			
			enterprises = enterprises2;
		}
		else
		{
			
			if(enterprises.stream().filter(enterprise->enterprises2.stream().anyMatch(aEnterprise->aEnterprise.getName().equals(enterprise.getName()))).collect(Collectors.toList()).size()>0)
			{	
				throw new RepeatedEnterpriseFileException("El archivo contiene una o mas empresas con un nombre ya cargado, modifiquelo y vuelva a cargar");
			}
			else
			{
				List<Enterprise> newEnterprises = new ArrayList<Enterprise>();
				newEnterprises.addAll(enterprises2);
				newEnterprises.addAll(enterprises);
				enterprises.clear();
				enterprises.addAll(newEnterprises);
			}
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
