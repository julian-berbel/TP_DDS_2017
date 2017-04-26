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
}
