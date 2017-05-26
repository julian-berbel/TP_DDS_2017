package math;

public class Subtraction extends AlgebraicOperation {

	public Subtraction(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	protected double apply(double firstOp, double secondOp){
		return firstOp - secondOp;
	}
	
}
