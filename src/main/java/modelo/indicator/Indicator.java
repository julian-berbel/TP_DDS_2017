package modelo.indicator;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import exceptions.EmptyFieldException;
import modelo.db.ModelEntity;
import modelo.enterprise.Enterprise;
import modelo.indicator.cache.CalculationCache;
import modelo.indicator.cache.PreCalculation;
import modelo.indicator.math.Operable;
import modelo.indicator.parser.IndicatorParser;

@Entity
@Table(name = "Indicators")
public class Indicator extends ModelEntity implements Operable {

  @Column(nullable = false, unique = true)
  private String name;
  private String formula;

  @Transient
  private Operable value;

  public Indicator(String name, String formula) {
    if (name == null)
      throw new EmptyFieldException("Nombre");
    if (formula == null)
      throw new EmptyFieldException("Formula");
    this.name = name;
    this.formula = formula;
    this.value = IndicatorParser.parseIndicator(formula);
  }

  public Indicator(String name, String formula, Long id) {
    this(name, formula);
    this.id = id;
  }

  protected Indicator() {
  }

  public String getName() {
    return name;
  }

  public String getFormula() {
    return formula;
  }

  @PostLoad
  protected void postLoad() {
    value = IndicatorParser.parseIndicator(formula);
  }

  public BigDecimal reduce(Enterprise enterprise, int year) {
    return CalculationCache.getInstance().fetchCalculation(enterprise, year, normalize()).orElseGet(() -> {
      BigDecimal result = value.reduce(enterprise, year);

      CalculationCache.getInstance().addElement(new PreCalculation(normalize(), enterprise.getId(), year, result));

      return result;
    });
  }

  public boolean tryReduce(Enterprise enterprise, int year) {
    try {
      reduce(enterprise, year);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public String normalize() {
    return value.toString();
  }

  public String getUrl() {
    return "indicators/" + id;
  }

  public Boolean uses(Indicator indicator) {
    return value.includes(indicator);
  }

  public Boolean includes(Indicator indicator) {
    return this == indicator || value.includes(indicator);
  }

}
