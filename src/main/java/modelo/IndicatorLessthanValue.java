
package modelo;

import java.math.BigDecimal;
import java.util.Date;



public class IndicatorLessthanValue extends FilterCriterion{

	private int  numberYears;
	private BigDecimal value;
	Indicator indicator;
	
	
	public IndicatorLessthanValue(String name,Indicator indicator, BigDecimal value, int years) 
	{
		super(name);
		this.value=value;
		this.indicator=indicator;
		this.numberYears = years;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean criterion(Enterprise enterprise) 
	{
		int  i = numberYears;
		BigDecimal centinelValue;
		for(int actualYear =(new Date().getYear())+ 1900 ;i>0;i--)
		{
			centinelValue = indicator.reduce(enterprise, actualYear-i);
			if(centinelValue.compareTo(value) > (-1))
			{
				return false;
			}
			
		}
		return true;
	}

}