package modelo.method.result;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;

public abstract class Result {

  protected Enterprise enterprise;

  public Result(Enterprise enterprise) {
    this.enterprise = enterprise;
  }

  public Result eval(FilterCriterion criterion) {
    return this;
  }

  public Enterprise getEnterprise() {
    return enterprise;
  }

  @Override
  public boolean equals(Object r) {
    return this.getClass() == r.getClass() && enterprise == ((Result) r).enterprise;
  }

  abstract public void insertInto(MethodReport report);
}
