import java.util.ArrayList;
import java.util.List;

public class Enterprise 
{
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
}
