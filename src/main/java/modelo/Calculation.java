package modelo;
import org.uqbar.commons.utils.Observable;

@Observable
public class Calculation 
{
	private String name;
	private String value; 	// le dejo string, para que me puedan poner algo como $100 y sea mas facil parsearlo, pero podria dejarlo double tambien
	
	
	public void setName(String attributeName)
	{
		this.name = attributeName;
	}
	public String getName()
	{
		return name;
	}
	public void setValue(String attributeValue)
	{
		this.value = attributeValue;
	}
	public String getValue()
	{
		return value;
	}	
}
