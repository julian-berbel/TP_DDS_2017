package modelo.indicator.cache;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import modelo.db.Repository;
import modelo.enterprise.Enterprise;

public class CalculationCache extends Repository<PreCalculation> {
  private static CalculationCache instance = new CalculationCache();

  private CalculationCache() {
    super("PreCalculation", PreCalculation.class);
  }

  public static CalculationCache getInstance() {
    return instance;
  }

  public void clear() {
    entityManager().createQuery("delete from PreCalculation").executeUpdate();
  }

  public Optional<BigDecimal> fetchCalculation(Enterprise enterprise, int year, String formula) {
    Map<String, Object> searchCriteria = new HashMap<>();
    searchCriteria.put("enterpriseId", enterprise.getId());
    searchCriteria.put("year", year);
    searchCriteria.put("formula", formula);

    return fetchElement(searchCriteria).map(precalculation -> precalculation.getResult());
  }
}
