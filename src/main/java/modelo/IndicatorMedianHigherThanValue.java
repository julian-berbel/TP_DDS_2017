package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class IndicatorMedianHigherThanValue extends FilterCriterion
{

	private int  numberYears;
	private BigDecimal value;
	Indicator indicator;


	public IndicatorMedianHigherThanValue(String name,Indicator indicator, BigDecimal value, int years) 
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
		ArrayList<BigDecimal> arrayListBigDecimal = new ArrayList<BigDecimal>();
		for(int actualYear = 2017;i>0;i--)
		{
			arrayListBigDecimal.add(indicator.reduce(enterprise, actualYear-i)) ;
		}	
		
		Collections.sort(arrayListBigDecimal);
		
		if((arrayListBigDecimal.size() % 2) == 0)
		{
		BigDecimal centinelValue2=arrayListBigDecimal.get((arrayListBigDecimal.size() / 2)-1);
		BigDecimal centinelValue3=arrayListBigDecimal.get((arrayListBigDecimal.size() / 2));
		centinelValue = centinelValue2.add(centinelValue3);
		centinelValue = centinelValue.divide(new BigDecimal("2"));
			if(centinelValue.compareTo(value)== 1)
			{
				return true;
			}else
			{
			return false;
			}
		}else
		{
			centinelValue = arrayListBigDecimal.get((arrayListBigDecimal.size() / 2));
			if(centinelValue.compareTo(value)== 1)
			{
				return true;
			}else
			{
				return false;
			}
		}
	}
}