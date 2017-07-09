package modelo.enterprise;
import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;

@Observable
public class Calculation
{
	private String name;
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
