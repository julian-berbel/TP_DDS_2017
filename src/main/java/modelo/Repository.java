package modelo;

import java.util.Optional;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

public abstract class Repository<Type> implements WithGlobalEntityManager, TransactionalOps{

	public void addElement(Type entity){
		withTransaction(() -> entityManager().persist(entity)); 
	}
	
	public void updateElement(Type entity){
		withTransaction(() -> entityManager().merge(entity));
	}
	
	public void deleteElement(Type entity){
		withTransaction(() -> entityManager().remove(entity));
	}
	
	public abstract Optional<Type> fetchElement(String name);
	
	public Boolean alreadyExists(String name){
		return fetchElement(name).isPresent();
	}
	
}
