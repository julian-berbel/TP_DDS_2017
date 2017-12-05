package modelo.method.criteria.filter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import modelo.indicator.Indicator;

@Entity
@DiscriminatorValue("DIV")
public class DecreasingIndicatorValueCriterion extends VariatingIndicatorValueCriterion {
  public DecreasingIndicatorValueCriterion(Indicator indicator, int years) {
    super(indicator, years, ComparisonCriterion.HigherThan);
  }

  protected DecreasingIndicatorValueCriterion() {
    this.comparisonCriterion = ComparisonCriterion.HigherThan;
  }
}