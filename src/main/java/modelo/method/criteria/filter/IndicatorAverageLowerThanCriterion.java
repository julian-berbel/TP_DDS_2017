package modelo.method.criteria.filter;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("IAL")
public class IndicatorAverageLowerThanCriterion extends IndicatorAverageCompareCriterion {
  public IndicatorAverageLowerThanCriterion(Indicator indicator, BigDecimal value, int years) {
    super(indicator, value, years, ComparisonCriterion.LowerThan);
  }

  protected IndicatorAverageLowerThanCriterion() {
    this.comparisonCriterion = ComparisonCriterion.LowerThan;
  }
}