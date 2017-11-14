package spark.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PerThreadEntityManagers {

  private static EntityManagerFactory emf;

  private static ThreadLocal<EntityManager> threadLocal;

  static {
    try {
      //
      String databaseUrl = System.getenv("DATABASE_URL");
      StringTokenizer st = new StringTokenizer(databaseUrl, ":@/");
      String dbVendor = st.nextToken(); // if DATABASE_URL is set
      String userName = st.nextToken();
      String password = st.nextToken();
      String host = st.nextToken();
      String port = st.nextToken();
      String databaseName = st.nextToken();
      String jdbcUrl = String.format(
          "jdbc:postgresql://%s:%s/%s?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", host, port,
          databaseName);
      Map<String, String> properties = new HashMap<String, String>();
      properties.put("javax.persistence.jdbc.url", jdbcUrl);
      properties.put("javax.persistence.jdbc.user", userName);
      properties.put("javax.persistence.jdbc.password", password);
      properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
      properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

      properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
      properties.put("hibernate.connection.url", jdbcUrl);
      properties.put("hibernate.connection.user", userName);
      properties.put("hibernate.connection.password", password);
      emf = Persistence.createEntityManagerFactory("db", properties);
      //
      threadLocal = new ThreadLocal<>();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static EntityManager getEntityManager() {
    EntityManager manager = threadLocal.get();
    if (manager == null || !manager.isOpen()) {
      manager = emf.createEntityManager();
      threadLocal.set(manager);
    }
    return manager;
  }

  public static void closeEntityManager() {
    EntityManager em = threadLocal.get();
    threadLocal.set(null);
    em.close();
  }
}
