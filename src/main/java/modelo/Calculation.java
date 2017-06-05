package modelo;
import org.uqbar.commons.utils.Observable;

@Observable
public class Calculation
{
	private String name;
	private double value;
	
	public void setName(String attributeName)
	{
		this.name = attributeName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setValue(double attributeValue)
	{
		this.value = attributeValue;
	}
	
	public double getValue()
	{
		return value;
	}

}
