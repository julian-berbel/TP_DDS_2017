package modelo.enterprise;
import java.util.ArrayList;
import java.util.List;

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
