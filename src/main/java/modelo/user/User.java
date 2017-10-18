package modelo.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exceptions.EmptyFieldException;
import modelo.db.ModelEntity;
import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.Method;

@Entity
@Table(name = "Users")
public class User extends ModelEntity {
	
	private String email;
	private String password;

	@OneToMany(	cascade = CascadeType.ALL,
				orphanRemoval = true,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Enterprise> enterprises;
	
	@OneToMany(	cascade = CascadeType.ALL,
				orphanRemoval = true,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Indicator> indicators;
	
	@OneToMany(	cascade = CascadeType.ALL,
				orphanRemoval = true,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Method> methods;
	
	public User(String email, String password){
		if(email == null) throw new EmptyFieldException("Email");
		if(password == null) throw new EmptyFieldException("Contraseña");
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password, long id){
		this(email, password);
		this.id = id;
	}

	protected User(){}

	public String getEmail() {
		return email;
	}

	public boolean validatePassword(String password) {
		return this.password.equals(password);
	}
	
	public void addEnterprise(Enterprise enterprise) {
		enterprises.add(enterprise);
	}
	
	public void addIndicator(Indicator indicator) {
		indicators.add(indicator);
	}
	
	public void addMethod(Method method) {
		methods.add(method);
	}
	
	public void removeEnterprise(Enterprise enterprise) {
		enterprises.remove(enterprise);
	}
	
	public void removeIndicator(Indicator indicator) {
		indicators.remove(indicator);
	}
	
	public void removeMethod(Method method) {
		methods.remove(method);
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public List<Method> getMethods() {
		return methods;
	}

}
