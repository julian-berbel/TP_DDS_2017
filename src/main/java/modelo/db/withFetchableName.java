package modelo.db;

import java.util.Optional;

public interface withFetchableName<Type> {

	default public Optional<Type> fetchByName(String name){
		return fetchElement("name", name);
	}
	
	default public Type getByName(String name){
		return getElement("name", name);
	}
	
	public Optional<Type> fetchElement(String searchField, Object value);
	public Type getElement(String searchField, Object value);
	
	default public Boolean alreadyExists(String name){
		return fetchByName(name).isPresent();
	}
}
