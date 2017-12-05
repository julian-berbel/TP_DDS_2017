package modelo.method;

import modelo.db.Repository;
import modelo.db.withFetchableName;

public class MethodRepository extends Repository<Method> implements withFetchableName<Method> {

  private static MethodRepository instance = new MethodRepository();

  private MethodRepository() {
    super("Method", Method.class);
  }

  public static MethodRepository getInstance() {
    return instance;
  }
}
