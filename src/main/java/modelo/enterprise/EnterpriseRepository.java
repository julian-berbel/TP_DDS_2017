package modelo.enterprise;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import exceptions.RepeatedEnterpriseFileException;

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
		try{
			enterprises.forEach(enterprise -> {
				entityManager().persist(enterprise);
			});
		}catch(Exception e){	// TODO la excepcion que tira realmente es com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException
			cancel();			// pero no me deja catchearla, me dice unreachable catch code
			throw new RepeatedEnterpriseFileException();
		}
		
	}
	
	public Boolean alreadyExists(String name){
		return fetchEnterprise(name).isPresent();
	}
	
	public void deleteEnterprise(Enterprise enterprise){
		entityManager().remove(enterprise);
	}

	public void saveChanges() {
		transaction.commit();
	}
	
	public void cancel(){
		transaction.rollback();
		initTransaction();
	}
}
