package modelo.user;

import modelo.db.Repository;

public class UserRepository extends Repository<User> {

  private static UserRepository instance = new UserRepository();

  private UserRepository() {
    super("User", User.class);
  }

  public static UserRepository getInstance() {
    return instance;
  }

  public User getByEmail(String email) {
    return fetchElement("email", email).get();
  }
}
