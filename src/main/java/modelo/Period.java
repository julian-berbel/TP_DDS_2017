package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Period 
{
	private int year;
	private List<Calculation> calculations;
	
	public Period()
	{
		calculations = new ArrayList<Calculation>();
	}
	
	public List<Calculation> getCalculations()
	{
		return calculations;
	}
	public void addCalculation(Calculation calc)
	{
		this.calculations.add(calc);
	}	
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public List<String> getCalculationsNames()
	{
		
		return calculations.stream().map(calculation->calculation.getName()).collect(Collectors.toList());
	}
	
	public Calculation getCalculation(String name){
		return calculations.stream()
				.filter(calculation -> calculation.getName() == name)
				.findFirst()
				.get();
	}
}
