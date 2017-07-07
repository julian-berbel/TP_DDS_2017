package modelo.indicator.math;

import java.math.BigDecimal;

public class Multiplication extends AlgebraicOperation{

	public Multiplication(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	protected BigDecimal apply(BigDecimal firstOp, BigDecimal secondOp){
		return firstOp.multiply(secondOp);
	}
	
	protected String operationString(){
		return " * ";
	}
}
