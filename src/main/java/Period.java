import java.util.ArrayList;
import java.util.List;

public class Period 
{
	private String period;						// el periodo podria ser algo como "2016-2017"
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
	public void setPeriod(String p)
	{
		this.period = p;
	}
	public String getPeriod()
	{
		return period;
	}
}
