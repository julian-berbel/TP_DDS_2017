package modelo.indicator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import exceptions.MissingIndicatorException;
import modelo.db.Repository;
import modelo.db.withFetchableName;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;

public class IndicatorRepository extends Repository<Indicator> implements withFetchableName<Indicator>
{
	private static IndicatorRepository instance = new IndicatorRepository();

	private IndicatorRepository(){}
	
	public static IndicatorRepository getInstance(){
		return instance;
	}
	
	public List<Indicator> getList(){
		return getList("Indicator", Indicator.class);
	}

	public Indicator getIndicator(String name){
		return fetchByName(name).orElseThrow(() -> new MissingIndicatorException(name));
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

	public Optional<Indicator> fetchByName(String name) {
		return fetchElement("name", name, "Indicator", Indicator.class);
	}
	
	public Optional<Indicator> getById(long id){
		return fetchElement("id", id, "Indicator", Indicator.class);
	}

}
