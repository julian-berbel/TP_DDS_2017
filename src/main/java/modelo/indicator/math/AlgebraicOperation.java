package modelo.indicator.math;

import java.math.BigDecimal;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public abstract class AlgebraicOperation implements Operable {

  private Operable firstOperand;

  private Operable secondOperand;

  public AlgebraicOperation(Operable firstOperand, Operable secondOperand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  protected abstract BigDecimal apply(BigDecimal firstOp, BigDecimal secondOp);

  protected abstract String operationString();

  public BigDecimal reduce(Enterprise enterprise, int year) {
    return this.apply(firstOperand.reduce(enterprise, year), secondOperand.reduce(enterprise, year));
  }

  public String toString() {
    return "(" + firstOperand.toString() + this.operationString() + secondOperand.toString() + ")";
  }

  public Boolean includes(Indicator indicator) {
    return firstOperand.includes(indicator) || secondOperand.includes(indicator);
  }
}
