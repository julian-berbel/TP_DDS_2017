package math;

import java.math.BigDecimal;
import modelo.Indicator;

public abstract class ComparisonOperation implements Comparable
{
	private Comparable firstOperand;
	private Comparable secondOperand;
	
	public ComparisonOperation(Comparable first, Comparable second)
	{
		firstOperand = first;
		secondOperand = second;
	}
	
	protected abstract Boolean compare(BigDecimal firstOp, BigDecimal secondOp);
	protected abstract String operationString();
	
	public String toString()
	{
		return "(" + firstOperand.toString() + this.operationString() + secondOperand.toString() + ")";
	}
	
	public Boolean includes(Indicator indicator)
	{
		return firstOperand.includes(indicator) || secondOperand.includes(indicator);
	}
}
