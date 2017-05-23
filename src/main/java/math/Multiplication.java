package math;

public class Multiplication extends AlgebraicOperation{

	public Multiplication(Operable firstOperand, Operable secondOperand) {
		super(firstOperand, secondOperand);
		this.operation = (firstOp, secondOp) -> firstOp * secondOp;
	}
	
}
