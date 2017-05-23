package math;

import java.util.function.BiFunction;;

public abstract class AlgebraicOperation implements Operable {
	public Operable firstOperand;
	public Operable secondOperand;
	public BiFunction<Double, Double, Double> operation;
	
	public AlgebraicOperation(Operable firstOperand, Operable secondOperand){
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}
	
	public double reduce(){
		return operation.apply(firstOperand.reduce(), secondOperand.reduce());
	}
}
