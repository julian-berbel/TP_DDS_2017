package math;

import modelo.Enterprise;

public abstract class AlgebraicOperation implements Operable {
	private Operable firstOperand;
	private Operable secondOperand;
	
	public AlgebraicOperation(Operable firstOperand, Operable secondOperand){
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}
	
	protected abstract double apply(double firstOp, double secondOp);
	protected abstract String operationString();
	
	public double reduce(Enterprise enterprise, int year){
		return this.apply(firstOperand.reduce(enterprise, year), secondOperand.reduce(enterprise, year));
	}
	
	public String toString(){
		return "(" + firstOperand.toString() + this.operationString() + secondOperand.toString() + ")";
	}
}
