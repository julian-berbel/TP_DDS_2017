package modelo;
import org.uqbar.commons.utils.Observable;

@Observable
public class Calculation
{
	private String name;
	private double value; 	// le dejo string, para que me puedan poner algo como $100 y sea mas facil parsearlo, pero podria dejarlo double tambien
	
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
	
	public static Calculation getCalculation(Enterprise enterprise, String name, int year){
		return enterprise.getCalculationOnYear(name, year);
	}
}
