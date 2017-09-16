package modelo.indicator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import exceptions.MissingIndicatorException;
import modelo.Repository;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;

public class IndicatorRepository extends Repository<Indicator>
{
	private static IndicatorRepository instance = new IndicatorRepository();

	private IndicatorRepository(){}
	
	public static IndicatorRepository getInstance(){
		return instance;
	}
	
	public List<Indicator> getIndicatorList(){
		return entityManager()
		        .createQuery("from Indicator", Indicator.class)
		        .getResultList();
	}
	
	public Optional<Indicator> fetchElement(String name){
		return entityManager()
		        .createQuery("from Indicator where name like :name", Indicator.class)
		        .setParameter("name", "%" + name + "%")
		        .getResultList().stream()
		        .findFirst();
	}

	public Indicator getIndicator(String name){
		return fetchElement(name).orElseThrow(() -> new MissingIndicatorException(name));
	}
	
	public Boolean anyUses(Indicator indicator){
		return !entityManager().createQuery("from Indicator where formula like :name", Indicator.class)
		        .setParameter("name", "%{$" + indicator.getName() + "}%")
		        .getResultList().isEmpty();
	}
	
	public List<Indicator> getAvailableIndicatorForPeriodList(Enterprise enterprise, Period period){
		return getIndicatorList().stream()
				.filter(indicator -> indicator.tryReduce(enterprise, period.getYear())).collect(Collectors.toList());
	}

}
