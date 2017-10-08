package modelo.method;

import java.util.List;
import java.util.Optional;

import modelo.db.Repository;
import modelo.db.withFetchableName;

public class MethodRepository extends Repository<Method> implements withFetchableName<Method>{

	private static MethodRepository instance = new MethodRepository();
		
	private MethodRepository(){}
	
	public static MethodRepository getInstance(){
		return instance;
	}
	
	public List<Method> getList(){
		return getList("Method", Method.class);
	}
	
	public Optional<Method> fetchByName(String name){
		return fetchElement("name", name, "Method", Method.class);
	}
	
	public Optional<Method> getById(long id){
		return fetchElement("id", id, "Method", Method.class);
	}
	
}
