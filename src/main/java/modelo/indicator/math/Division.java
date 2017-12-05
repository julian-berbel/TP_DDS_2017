package modelo.indicator.math;

import java.math.BigDecimal;

public class Division extends AlgebraicOperation {

  public Division(Operable firstOperand, Operable secondOperand) {
    super(firstOperand, secondOperand);
  }

  protected BigDecimal apply(BigDecimal firstOp, BigDecimal secondOp) {
    return firstOp.divide(secondOp, 1, BigDecimal.ROUND_HALF_DOWN);
  }

  protected String operationString() {
    return " / ";
  }
}
