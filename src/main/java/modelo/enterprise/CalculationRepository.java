package modelo.enterprise;

import modelo.db.Repository;
import modelo.db.withFetchableName;

public class CalculationRepository extends Repository<Calculation> implements withFetchableName<Calculation> {
  private static CalculationRepository instance = new CalculationRepository();

  private CalculationRepository() {
    super("Calculation", Calculation.class);
  }

  public static CalculationRepository getInstance() {
    return instance;
  }
}
