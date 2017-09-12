package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ModelEntity {
	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}
}
