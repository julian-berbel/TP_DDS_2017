package modelo.method.criteria.filter;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
public abstract class IndicatorMedianCompareCriterion extends IndicatorStatisticCompareCriterion {
  public IndicatorMedianCompareCriterion(Indicator indicator, BigDecimal value, int years,
      ComparisonCriterion comparisonCriterion) {
    super(indicator, value, years, comparisonCriterion);
  }

  protected IndicatorMedianCompareCriterion() {
  }

  protected boolean test(List<BigDecimal> values) {
    values = values.stream().sorted().collect(Collectors.toList());

    int middle = values.size() / 2;
    BigDecimal median = values.get(middle);

    if (values.size() % 2 == 0)
      median = median.add(values.get(middle - 1)).divide(new BigDecimal(2));

    return compare(median.compareTo(value));
  }

  public String buildDescription() {
    return buildDescription("Mediana");
  }
}