package modelo.indicator.math;

import java.math.BigDecimal;

public class Subtraction extends AlgebraicOperation {

  public Subtraction(Operable firstOperand, Operable secondOperand) {
    super(firstOperand, secondOperand);
  }

  protected BigDecimal apply(BigDecimal firstOp, BigDecimal secondOp) {
    return firstOp.subtract(secondOp);
  }

  protected String operationString() {
    return " - ";
  }
}
