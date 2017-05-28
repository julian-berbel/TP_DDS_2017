package math;

public class Multiplication extends AlgebraicOperation{

	public Multiplication(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	protected double apply(double firstOp, double secondOp){
		return firstOp * secondOp;
	}
	
	protected String operationString(){
		return " * ";
	}
}
