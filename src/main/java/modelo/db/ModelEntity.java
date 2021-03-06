package modelo.db;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ModelEntity {
  @Id
  @GeneratedValue
  protected long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
