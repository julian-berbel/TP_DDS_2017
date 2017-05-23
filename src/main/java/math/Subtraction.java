package math;

public class Subtraction extends AlgebraicOperation {

	public Subtraction(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
		this.operation = (firstOp, secondOp) -> firstOp - secondOp;
	}
	
}
