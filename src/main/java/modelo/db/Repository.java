package modelo.db;

import java.util.List;
import java.util.Optional;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import exceptions.MissingElementException;

public abstract class Repository<Type> implements WithGlobalEntityManager, TransactionalOps{
	private String tableName;
	private Class<Type> classType;
	
	public Repository(String tableName, Class<Type> classType){
		this.tableName = tableName;
		this.classType = classType;
	}

	public void addElement(Type entity){
		entityManager().persist(entity);
	}
	
	public void updateElement(Type entity){
		entityManager().merge(entity);
	}
	
	public void deleteElement(Type entity){
		entityManager().remove(entity);
	}
	
	public Optional<Type> fetchElement(String searchField, Object value){
		return entityManager()
		        .createQuery("from " + tableName + " where " + searchField + " = :" + searchField , classType)
		        .setParameter(searchField, value)
		        .getResultList().stream()
		        .findFirst();
	}
	
	public Type getElement(String searchField, Object value){
		return fetchElement(searchField, value).orElseThrow(() -> new MissingElementException(searchField, value, tableName));
	}
	
	public Type getById(long id){
		return getElement("id", id);
	}
	
	public List<Type> getList(){
		return entityManager()
		        .createQuery("from " + tableName, classType)
		        .getResultList();
	}
		
}
