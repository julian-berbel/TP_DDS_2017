package modelo.db;

import java.util.Optional;

public interface withFetchableName<Type> {

	public Optional<Type> fetchByName(String name);
	
	default public Boolean alreadyExists(String name){
		return fetchByName(name).isPresent();
	}
}
