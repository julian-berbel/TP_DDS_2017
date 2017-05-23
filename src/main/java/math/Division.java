package math;

public class Division extends AlgebraicOperation {

	public Division(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
		this.operation = (firstOp, secondOp) -> firstOp / secondOp;
	}
	
}
