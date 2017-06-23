package math;

import java.math.BigDecimal;

public class Lesser extends ComparisonOperation
{
	public Lesser(Comparable firstOperand, Comparable secondOperand)
	{
		super(firstOperand, secondOperand);
	}
	
	public Boolean compare(BigDecimal first, BigDecimal second)
	{
		return first.doubleValue() < second.doubleValue();
	}
	
	public String operationString()
	{
		return " < ";
	}
}
