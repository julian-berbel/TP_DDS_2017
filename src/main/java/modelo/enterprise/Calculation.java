package modelo.enterprise;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.uqbar.commons.utils.Observable;

import modelo.ModelEntity;

@Observable
@Entity
public class Calculation extends ModelEntity
{
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Convert(converter = BigDecimalConverter.class)
	private BigDecimal value;
	
	public Calculation(String name, BigDecimal value){
		this.name = name;
		this.value = value;
	}
	
	protected Calculation(){}
	
	public String getName()
	{
		return name;
	}
	
	public BigDecimal getValue()
	{
		return value;
	}
}
