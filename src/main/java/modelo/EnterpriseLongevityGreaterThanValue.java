package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class EnterpriseLongevityGreaterThanValue extends FilterCriterion{
	private int  numberYears;
	
	
	
	
	public EnterpriseLongevityGreaterThanValue(String name, int years) 
	{
		super(name);		
		this.numberYears = years;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean criterion(Enterprise enterprise) 
	{
		return enterprise.getPeriods().stream()
				.map(period -> period.getYear())
				.anyMatch(year->year<=new Date().getYear()+ 1900-numberYears);
	}
}