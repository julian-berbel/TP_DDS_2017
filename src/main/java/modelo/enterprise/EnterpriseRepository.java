package modelo.enterprise;

import java.util.List;
import java.util.Optional;

import exceptions.RepeatedEnterpriseFileException;
import modelo.Repository;

public class EnterpriseRepository extends Repository<Enterprise>
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
	
	public List<Enterprise> getEnterpriseList(){
		return entityManager()
		        .createQuery("from Enterprise", Enterprise.class)
		        .getResultList();
	}
	
	public Optional<Enterprise> fetchElement(String name){
		return entityManager()
		        .createQuery("from Enterprise where name like :name", Enterprise.class)
		        .setParameter("name", "%" + name + "%")
		        .getResultList().stream()
		        .findFirst();
	}
	
	public void importEnterprises(List<Enterprise> enterprises){
		if(enterprises.stream().map(enterprise -> enterprise.getName()).anyMatch(this::alreadyExists)) throw new RepeatedEnterpriseFileException();
		withTransaction(() ->
			enterprises.forEach(this::addElement)
		);
	}

}
