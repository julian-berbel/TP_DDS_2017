package math;

public class Addition extends AlgebraicOperation {

	public Addition(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	protected double apply(double firstOp, double secondOp){
		return firstOp + secondOp;
	}

	public Operable a(){
		return this;
	}
}
