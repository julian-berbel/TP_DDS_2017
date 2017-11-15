import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.method.criteria.filter.DecreasingIndicatorValueCriterion;
import modelo.method.criteria.filter.IncreasingIndicatorValueCriterion;
import modelo.method.criteria.filter.IndicatorAverageHigherThanCriterion;
import modelo.method.criteria.filter.IndicatorAverageLowerThanCriterion;
import modelo.method.criteria.filter.IndicatorMedianHigherThanCriterion;
import modelo.method.criteria.filter.IndicatorMedianLowerThanCriterion;
import modelo.method.criteria.filter.IndicatorValueHigherThanCriterion;
import modelo.method.criteria.filter.IndicatorValueLowerThanCriterion;

public class FilterCriteriaTest {

  List<Period> periods = Arrays.asList(new Period(2014, Arrays.asList(new Calculation("a", new BigDecimal("1")))),
      new Period(2015, Arrays.asList(new Calculation("a", new BigDecimal("2")))),
      new Period(2016, Arrays.asList(new Calculation("a", new BigDecimal("3")))),
      new Period(2017, Arrays.asList(new Calculation("a", new BigDecimal("4")))));

  Enterprise anEnterprise = new Enterprise("", periods);
  Enterprise anotherEnterprise = new Enterprise("",
      periods.stream().sorted((a, b) -> b.getCalculation("a").getValue().compareTo(a.getCalculation("a").getValue()))
          .collect(Collectors.toList()));

  Indicator anIndicator = new Indicator("", "#a");

  @Test
  public void increasingIndicatorValue() {
    assertTrue(new IncreasingIndicatorValueCriterion(anIndicator, 3).test(anEnterprise));
  }

  @Test
  public void decreasingIndicatorValue() {
    assertTrue(new DecreasingIndicatorValueCriterion(anIndicator, 3).test(anotherEnterprise));
  }

  @Test
  public void indicatorAverageHigherThan() {
    assertTrue(new IndicatorAverageHigherThanCriterion(anIndicator, new BigDecimal("2.49"), 3).test(anEnterprise));
  }

  @Test
  public void indicatorAverageLowerThan() {
    assertTrue(new IndicatorAverageLowerThanCriterion(anIndicator, new BigDecimal("2.51"), 3).test(anEnterprise));
  }

  @Test
  public void indicatorMedianHigherThan() {
    assertTrue(new IndicatorMedianHigherThanCriterion(anIndicator, new BigDecimal("2.49"), 3).test(anEnterprise));
  }

  @Test
  public void indicatorMedianLowerThan() {
    assertTrue(new IndicatorMedianLowerThanCriterion(anIndicator, new BigDecimal("2.51"), 3).test(anEnterprise));
  }

  @Test
  public void indicatorValueHigherThan() {
    assertTrue(new IndicatorValueHigherThanCriterion(anIndicator, new BigDecimal("0.99"), 3).test(anEnterprise));
  }

  @Test
  public void indicatorValueLowerThan() {
    assertTrue(new IndicatorValueLowerThanCriterion(anIndicator, new BigDecimal("4.01"), 3).test(anEnterprise));
  }
}