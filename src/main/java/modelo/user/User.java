package modelo.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exceptions.EmptyFieldException;
import exceptions.ExistingIndicatorException;
import modelo.db.ModelEntity;
import modelo.indicator.Indicator;
import modelo.method.Method;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@DiscriminatorValue("U")
public class User extends ModelEntity {

  private String email;
  private String password;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private List<Indicator> indicators;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private List<Method> methods;

  public User(String email, String password) {
    if (email == null)
      throw new EmptyFieldException("Email");
    if (password == null)
      throw new EmptyFieldException("Contraseña");
    this.email = email;
    this.password = password;
  }

  public User(String email, String password, long id) {
    this(email, password);
    this.id = id;
  }

  protected User() {
  }

  public String getEmail() {
    return email;
  }

  public boolean validatePassword(String password) {
    return this.password.equals(password);
  }

  public void addIndicator(Indicator indicator) {
    if (indicators.stream().anyMatch(indicator2 -> indicator2.getName().equals(indicator.getName()))) {
      throw new ExistingIndicatorException(indicator.getName());
    }
    indicators.add(indicator);
  }

  public void addMethod(Method method) {
    methods.add(method);
  }

  public List<Indicator> getIndicators() {
    return indicators;
  }

  public List<Method> getMethods() {
    return methods;
  }

  public String homeView() {
    return "home/home.hbs";
  }

}
