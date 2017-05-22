package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Period 
{
	private String periodName;						// el periodo podria ser algo como "2016-2017"
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
	public void setPeriodName(String p)
	{
		this.periodName = p;
	}
	public String getPeriodName()
	{
		return periodName;
	}
	public List<String> getCalculationsName()
	{
		
		return calculations.stream().map(calculation->calculation.getName()).collect(Collectors.toList());
	}
}
