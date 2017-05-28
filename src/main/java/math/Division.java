package math;

public class Division extends AlgebraicOperation {

	public Division(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	protected double apply(double firstOp, double secondOp){
		return firstOp / secondOp;
	}
	
	protected String operationString(){
		return " / ";
	}
}
