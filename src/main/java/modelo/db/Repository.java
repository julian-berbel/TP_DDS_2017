package modelo.db;

import java.util.List;
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
	
	protected Optional<Type> fetchElement(String searchField, Object value, String table, Class<Type> resultClass){
		return entityManager()
		        .createQuery("from " + table + " where " + searchField + " = :" + searchField , resultClass)
		        .setParameter(searchField, value)
		        .getResultList().stream()
		        .findFirst();
	}

	public abstract List<Type> getList();
	
	protected List<Type> getList(String table, Class<Type> resultClass){
		return entityManager()
		        .createQuery("from " + table, resultClass)
		        .getResultList();
	}
	
}
