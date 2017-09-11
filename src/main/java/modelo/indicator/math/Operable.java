package modelo.indicator.math;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)		//Lo pongo asi por que no me gusta que haya campos que puedan ser nulos
public abstract class Operable {					//(que una single-table permite), aparte que los atributos cambian bastante entre las clases
	
	@Id
	@GeneratedValue
	private int id;
	
	public abstract BigDecimal reduce(Enterprise enterprise, int year);
	
	public abstract Boolean includes(Indicator indicator);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
