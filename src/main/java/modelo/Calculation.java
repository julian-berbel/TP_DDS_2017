package modelo;
import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;

@Observable
public class Calculation
{
	private String name;
	private BigDecimal value;
	
	public void setName(String attributeName)
	{
		this.name = attributeName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setValue(BigDecimal attributeValue)
	{
		this.value = attributeValue;
	}
	
	public BigDecimal getValue()
	{
		return value;
	}

}
