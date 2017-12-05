package modelo.indicator.math;

import java.math.BigDecimal;

public class Addition extends AlgebraicOperation {

  public Addition(Operable firstOperand, Operable secondOperand) {
    super(firstOperand, secondOperand);
  }

  protected BigDecimal apply(BigDecimal firstOp, BigDecimal secondOp) {
    return firstOp.add(secondOp);
  }

  protected String operationString() {
    return " + ";
  }
}
