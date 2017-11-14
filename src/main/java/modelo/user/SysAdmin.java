package modelo.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class SysAdmin extends User {

	public SysAdmin(String email, String password) {
		super(email, password);
	}
	
	protected SysAdmin(){}

	@Override
	public String homeView(){
		return "home/admin.hbs";
	}
}
