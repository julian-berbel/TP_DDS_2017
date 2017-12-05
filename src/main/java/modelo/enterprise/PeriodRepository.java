package modelo.enterprise;

import modelo.db.Repository;

public class PeriodRepository extends Repository<Period> {
  private static PeriodRepository instance = new PeriodRepository();

  private PeriodRepository() {
    super("Period", Period.class);
  }

  public static PeriodRepository getInstance() {
    return instance;
  }
}
