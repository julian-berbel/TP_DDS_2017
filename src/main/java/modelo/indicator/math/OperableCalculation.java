package modelo.indicator.math;

import java.math.BigDecimal;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public class OperableCalculation implements Operable {

  private String name;

  public OperableCalculation(String name) {
    this.name = name;
  }

  public BigDecimal reduce(Enterprise enterprise, int year) {
    return enterprise.getCalculationOnYear(name, year).getValue();
  }

  public String toString() {
    return "#" + name;
  }

  public Boolean includes(Indicator indicator) {
    return false;
  }
}
