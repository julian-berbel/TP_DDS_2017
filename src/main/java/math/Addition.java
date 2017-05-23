package math;

public class Addition extends AlgebraicOperation {

	public Addition(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
		this.operation = (firstOp, secondOp) -> firstOp + secondOp;
	}

}
