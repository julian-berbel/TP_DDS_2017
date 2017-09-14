package modelo.method;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class MethodRepository implements WithGlobalEntityManager {

	private static MethodRepository instance;
	
	private EntityTransaction transaction;
	
	public void initTransaction(){
		transaction = entityManager().getTransaction();
		transaction.begin();
	}
		
	private MethodRepository(){}
	
	public static MethodRepository getInstance(){
		if(instance==null)instance = new MethodRepository();
		return instance;
	}

	public void addMethod(Method method){
		entityManager().persist(method);
	}
	
	public void deleteMethod(Method method){
		entityManager().remove(method);
	}
	
	public List<Method> getMethods(){
		return entityManager()
		        .createQuery("from Method", Method.class)
		        .getResultList();
	}
	
	public Optional<Method> fetchMethod(String name){
		return entityManager()
		        .createQuery("from Method where name like :name", Method.class)
		        .setParameter("name", "%" + name + "%")
		        .getResultList().stream()
		        .findFirst();
	}
	
	public Boolean alreadyExists(String name){
		 return fetchMethod(name).isPresent();
	}

	public void updateMethod(Method method) {
		entityManager().merge(method);
	}

	public void saveChanges() {
		transaction.commit();
	}
	
}
