
package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class IndicatorAverageLessThanValue extends FilterCriterion{
	private int  numberYears;
	private BigDecimal value;
	Indicator indicator;
	
	
	public IndicatorAverageLessThanValue(String name,Indicator indicator, BigDecimal value, int years) 
	{
		super(name);
		this.value=value;
		this.indicator=indicator;
		this.numberYears = years;
	}

	@Override
	public boolean criterion(Enterprise enterprise) 
	{
		int  i = numberYears;
		BigDecimal centinelValue = new BigDecimal("0");
		for(int actualYear =(new Date().getYear())+ 1900;i>0;i--)
		{
			centinelValue = centinelValue.add(indicator.reduce(enterprise, actualYear-i)) ;
		
		}
		if(centinelValue.compareTo(value) == (-1))
		{
			return true;
		}else
		{
			return false;
		}
		
	}
}