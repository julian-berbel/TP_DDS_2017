package modelo.enterprise;
import java.math.BigDecimal;

import javax.persistence.Convert;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.uqbar.commons.utils.Observable;

import modelo.ModelEntity;

@Observable
public class Calculation extends ModelEntity
{
	private String name;
	
	@Convert(converter = BigDecimalConverter.class)
	private BigDecimal value;
	
	public Calculation(String name, BigDecimal value){
		this.name = name;
		this.value = value;
	}
	
	public String getName()
	{
		return name;
	}
	
	public BigDecimal getValue()
	{
		return value;
	}

}
