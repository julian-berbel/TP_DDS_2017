package modelo.enterprise;
import java.util.List;

public class Period 
{
	private int year;
	private List<Calculation> calculations;
	
	public Period(int year, List<Calculation> calculations)
	{
		this.year = year;
		this.calculations = calculations;
	}
	
	public List<Calculation> getCalculations()
	{
		return calculations;
	}
	
	public int getYear() {
		return year;
	}
	
	public Calculation getCalculation(String name){
		return calculations.stream()
				.filter(calculation -> calculation.getName().equals(name))
				.findFirst()
				.get();
	}
	
	@Override
	public String toString(){
		return String.valueOf(year);
	}
}
