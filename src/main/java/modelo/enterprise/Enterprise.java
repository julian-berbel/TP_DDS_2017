package modelo.enterprise;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Enterprise 
{
	private String enterpriseName;
	private List<Period> periods;
	
	public Enterprise()
	{
		periods = new ArrayList<Period>();
	}
	
	public void addPeriod(Period p)
	{
		this.periods.add(p);
	}
	
	public List<Period> getPeriods()
	{
		return periods;
	}
	
	public void setEnterpriseName(String name)
	{
		this.enterpriseName = name;
	}
	
	public String getEnterpriseName()
	{
		return enterpriseName;
	}
	
	public Calculation getCalculationOnYear(String name, int year){
		return periods.stream()
				.filter(period -> period.getYear() == year)
				.findFirst()
				.get()
				.getCalculation(name);
	}
	
	public int age(){
		return Year.now().getValue() - this.getPeriods().stream()
											.mapToInt(period -> period.getYear())
											.min()
											.getAsInt();
	}
	
	@Override
	public String toString(){
		return enterpriseName;
	}
}
