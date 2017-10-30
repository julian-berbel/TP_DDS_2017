package modelo.indicator;
import java.util.List;
import java.util.stream.Collectors;

import modelo.db.Repository;
import modelo.db.withFetchableName;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;

public class IndicatorRepository extends Repository<Indicator> implements withFetchableName<Indicator>
{
	private static IndicatorRepository instance = new IndicatorRepository();

	private IndicatorRepository(){
		super("Indicator", Indicator.class);
	}
	
	public static IndicatorRepository getInstance(){
		return instance;
	}
	
	public Boolean anyUses(Indicator indicator){
		return !entityManager().createQuery("from Indicator where formula like :name", Indicator.class)
		        .setParameter("name", "%{$" + indicator.getName() + "}%")
		        .getResultList().isEmpty();
	}
	
	public List<Indicator> getAvailableIndicatorForPeriodList(Enterprise enterprise, Period period){
		return getList().stream()
				.filter(indicator -> indicator.tryReduce(enterprise, period.getYear())).collect(Collectors.toList());
	}
}
