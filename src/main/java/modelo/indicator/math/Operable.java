package modelo.indicator.math;

import java.math.BigDecimal;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public interface Operable {
  public BigDecimal reduce(Enterprise enterprise, int year);

  public Boolean includes(Indicator indicator);
}
