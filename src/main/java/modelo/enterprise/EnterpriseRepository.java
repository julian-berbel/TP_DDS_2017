package modelo.enterprise;

import java.util.List;
import java.util.Optional;

import modelo.db.Repository;
import modelo.db.withFetchableName;

public class EnterpriseRepository extends Repository<Enterprise> implements withFetchableName<Enterprise> {
  private static EnterpriseRepository instance = new EnterpriseRepository();

  private EnterpriseRepository() {
    super("Enterprise", Enterprise.class);
  }

  public static EnterpriseRepository getInstance() {
    return instance;
  }

  public void batchLoad(List<Enterprise> enterprises) {
    enterprises.forEach(enterprise -> {
      Optional<Enterprise> maybeEnterprise = EnterpriseRepository.getInstance().fetchByName(enterprise.getName());
      if (maybeEnterprise.isPresent()) {
        enterprise.merge(maybeEnterprise.get());
      } else
        addElement(enterprise);
    });
  }
}
