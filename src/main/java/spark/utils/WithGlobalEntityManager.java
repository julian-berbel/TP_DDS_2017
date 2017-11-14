package spark.utils;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.WithEntityManager;

public interface WithGlobalEntityManager extends WithEntityManager {

  default EntityManager entityManager() {
    return PerThreadEntityManagers.getEntityManager();
  }
}
