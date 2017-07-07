
package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


public class IndicatorIsCrescentPeriod extends FilterCriterion
{

	private int  numberYears;
	Indicator indicator;


	public IndicatorIsCrescentPeriod(String name,Indicator indicator, int years) 
	{
		super(name);		
		this.indicator=indicator;
		this.numberYears = years;
	}

	@Override	
	public boolean criterion(Enterprise enterprise) 
	{
		int  i = numberYears;
		ArrayList<BigDecimal> arrayListBigDecimal = new ArrayList<BigDecimal>();
		
		for(int actualYear =(new Date().getYear())+ 1900;i>0;i--)
		{
			arrayListBigDecimal.add(indicator.reduce(enterprise, actualYear-i)) ;
		}	
		
		if(arrayListBigDecimal.size()==1){
			return true;
		}
		
		for(int index = 0 ;index<(arrayListBigDecimal.size()-1);index++)
		{
			if (arrayListBigDecimal.get(index).compareTo(arrayListBigDecimal.get(index+1))>(-1))
			{
				return false;
			}
		}	
		
		return true;
		

	}
}