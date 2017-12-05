package exceptions;

import modelo.enterprise.Period;

@SuppressWarnings("serial")
public class MissingCalculationInPeriodException extends RuntimeException {

  public MissingCalculationInPeriodException(String calculationName, Period period) {
    super("La empresa no posee el valor de la cuenta " + calculationName + " en el periodo "
        + String.valueOf(period.getYear()));
  }
}
