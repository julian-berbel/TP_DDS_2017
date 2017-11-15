import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.math.Addition;
import modelo.indicator.math.Constant;
import modelo.indicator.math.Division;
import modelo.indicator.math.Multiplication;
import modelo.indicator.math.Subtraction;

public class AlgebraicOperationTest {
  Constant firstOperand = new Constant(new BigDecimal(4));
  Constant secondOperand = new Constant(new BigDecimal(8));
  Enterprise dummyEnterprise = new Enterprise("", new ArrayList<Period>());

  @Test
  public void addition() {
    assertEquals(new Addition(firstOperand, secondOperand).reduce(dummyEnterprise, 0), new BigDecimal(12));
  }

  @Test
  public void subtraction() {
    assertEquals(new Subtraction(firstOperand, secondOperand).reduce(dummyEnterprise, 0), new BigDecimal(-4));
  }

  @Test
  public void multiplication() {
    assertEquals(new Multiplication(firstOperand, secondOperand).reduce(dummyEnterprise, 0), new BigDecimal(32));
  }

  @Test
  public void division() {
    assertEquals(new Division(firstOperand, secondOperand).reduce(dummyEnterprise, 0), new BigDecimal(0.5));
  }

  @Test
  public void complex() {
    Addition add = new Addition(firstOperand, secondOperand);
    Multiplication mult = new Multiplication(add, new Constant(new BigDecimal(2)));

    assertEquals(mult.reduce(dummyEnterprise, 0), new BigDecimal(24));
  }
}