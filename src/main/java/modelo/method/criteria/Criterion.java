package modelo.method.criteria;

import javax.persistence.MappedSuperclass;

import modelo.db.ModelEntity;

@MappedSuperclass
public abstract class Criterion extends ModelEntity {

  protected abstract String buildDescription();

  public String getDescription() {
    return buildDescription();
  }
}
