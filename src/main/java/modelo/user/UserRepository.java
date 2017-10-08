package modelo.user;

import java.util.List;

import modelo.db.Repository;

public class UserRepository extends Repository<User> {

	private static UserRepository instance = new UserRepository();
		
	private UserRepository(){}
	
	public static UserRepository getInstance(){
		return instance;
	}
	
	public List<User> getList(){
		return getList("User", User.class);
	}
	
	public User getByEmail(String email) {
		return fetchElement("email", email, "User", User.class).get();
	}
	
	public User getById(long id){
		return fetchElement("id", id, "User", User.class).get();
	}
	
}
