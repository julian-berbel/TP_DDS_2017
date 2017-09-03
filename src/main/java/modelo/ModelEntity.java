package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class ModelEntity {
	@Id
	@GeneratedValue
	private long id;
}
