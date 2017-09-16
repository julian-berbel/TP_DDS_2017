package modelo.method;

import java.util.List;
import java.util.Optional;

import modelo.Repository;

public class MethodRepository extends Repository<Method> {

	private static MethodRepository instance = new MethodRepository();
		
	private MethodRepository(){}
	
	public static MethodRepository getInstance(){
		return instance;
	}
	
	public List<Method> getMethods(){
		return entityManager()
		        .createQuery("from Method", Method.class)
		        .getResultList();
	}
	
	public Optional<Method> fetchElement(String name){
		return entityManager()
		        .createQuery("from Method where name like :name", Method.class)
		        .setParameter("name", "%" + name + "%")
		        .getResultList().stream()
		        .findFirst();
	}
	
}
