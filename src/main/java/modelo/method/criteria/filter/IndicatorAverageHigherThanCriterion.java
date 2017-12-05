package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IAH")
public class IndicatorAverageHigherThanCriterion extends IndicatorAverageCompareCriterion {
  public IndicatorAverageHigherThanCriterion(Indicator indicator, BigDecimal value, int years) {
    super(indicator, value, years, ComparisonCriterion.HigherThan);
  }

  protected IndicatorAverageHigherThanCriterion() {
    this.comparisonCriterion = ComparisonCriterion.HigherThan;
  }
}