package modelo.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import exceptions.MissingElementException;
import modelo.indicator.Indicator;

public abstract class Repository<Type extends ModelEntity> implements WithGlobalEntityManager, TransactionalOps{
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
		Map<String, Object> searchCriteria = new HashMap<>();
		searchCriteria.put(searchField, value);
		
		return fetchElement(searchCriteria);
	}
	
	public Optional<Type> fetchElement(Map<String, Object> searchCriteria){
		String queryString = "from " + tableName + " where " + searchCriteria.keySet().stream()
																			.map(searchField -> searchField + " = :" + searchField)
																			.reduce((a, b) -> a + " and " + b)
																			.get();
		
		TypedQuery<Type> query = entityManager().createQuery(queryString , classType);
		
		searchCriteria.forEach(query::setParameter);
		
		return query.getResultList().stream()
		        					.findFirst();
	}
	
	public Type getElement(String searchField, Object value){
		return fetchElement(searchField, value).orElseThrow(() -> new MissingElementException(searchField, value, tableName));
	}
	
	public Optional<Type> fetchById(long id){
		return fetchElement("id", id);
	}
	
	public Type getById(long id){
		return getElement("id", id);
	}
	
	public List<Type> getList(){
		return entityManager()
		        .createQuery("from " + tableName, classType)
		        .getResultList();
	}	
		
	public List<Type> filterByName(String name){		
		return entityManager()
		        .createQuery("select t from " + tableName+" t where name like :name", classType)
		        .setParameter("name", "%" + name + "%")
		        .getResultList();
	
	}
}
