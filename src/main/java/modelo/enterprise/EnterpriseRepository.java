package modelo.enterprise;

import java.util.List;
import java.util.Optional;

import exceptions.MissingEnterpriseException;
import exceptions.RepeatedEnterpriseFileException;
import modelo.db.Repository;
import modelo.db.withFetchableName;

public class EnterpriseRepository extends Repository<Enterprise> implements withFetchableName<Enterprise>
{
	private static EnterpriseRepository instance = new EnterpriseRepository();
		
	private EnterpriseRepository(){}

	private String filePath;

	private Boolean fileLoaded= false;

	public static EnterpriseRepository getInstance(){
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
	
	public List<Enterprise> getList(){
		return getList("Enterprise", Enterprise.class);
	}
	
	public Optional<Enterprise> fetchByName(String name){
		return fetchElement("name", name, "Enterprise", Enterprise.class);
	}
	
	public Enterprise getById(long id){
		return getElement("id", id, "Enterprise", Enterprise.class);
	}
	
	public void importEnterprises(List<Enterprise> enterprises){
		if(enterprises.stream().anyMatch(enterprise -> alreadyExists(enterprise.getName()))) throw new RepeatedEnterpriseFileException();
		withTransaction(() ->
			enterprises.forEach(this::addElement)
		);
	}
	
	public Enterprise getEnterprise(String name){
		return fetchByName(name).orElseThrow(() -> new MissingEnterpriseException(name));
	}
}
