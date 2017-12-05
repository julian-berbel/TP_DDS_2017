package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IMH")
public class IndicatorMedianHigherThanCriterion extends IndicatorMedianCompareCriterion {
  public IndicatorMedianHigherThanCriterion(Indicator indicator, BigDecimal value, int years) {
    super(indicator, value, years, ComparisonCriterion.HigherThan);
  }

  protected IndicatorMedianHigherThanCriterion() {
    this.comparisonCriterion = ComparisonCriterion.HigherThan;
  }
}