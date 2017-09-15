package modelo.enterprise;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class EnterpriseRepository implements WithGlobalEntityManager
{
	private static EnterpriseRepository instance;
	
	private EntityTransaction transaction;
	
	public void initTransaction(){
		transaction = entityManager().getTransaction();
		transaction.begin();
	}
	
	private EnterpriseRepository(){}

	private String filePath;

	private Boolean fileLoaded= false;

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
	
	public void addEnterprise(Enterprise enterprise){
		entityManager().persist(enterprise);
	}
	
	public void updateEnterprise(Enterprise enterprise){
		entityManager().merge(enterprise);
	}
	
	public List<Enterprise> getEnterpriseList(){
		return entityManager()
		        .createQuery("from Enterprise", Enterprise.class)
		        .getResultList();
	}
	
	public Optional<Enterprise> fetchEnterprise(String name){
		return entityManager()
		        .createQuery("from Enterprise where name like :name", Enterprise.class)
		        .setParameter("name", "%" + name + "%")
		        .getResultList().stream()
		        .findFirst();
	}
	
	public void importEnterprises(List<Enterprise> enterprises){
		enterprises.forEach(enterprise -> {
			entityManager().persist(enterprise);
		});

		entityManager().flush();
	}
	
	public Boolean alreadyExists(String name){
		return fetchEnterprise(name).isPresent();
	}
	
	public void deleteEnterprise(Enterprise enterprise){
		enterprise.getPeriods().stream().forEach(period->{period.getCalculations().stream().forEach(calculation->entityManager().remove(calculation));
		entityManager().remove(period);
		});
		entityManager().remove(enterprise);
	}

	public void saveChanges() {
		transaction.commit();
	}
}
