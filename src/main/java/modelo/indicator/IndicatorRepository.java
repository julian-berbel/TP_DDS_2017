package modelo.indicator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import exceptions.MissingIndicatorException;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;

public class IndicatorRepository implements WithGlobalEntityManager
{
	private static IndicatorRepository instance;
	
	private EntityTransaction transaction;
	
	private IndicatorRepository(){}
	
	public static IndicatorRepository getInstance(){
		if(instance==null) instance = new IndicatorRepository();
		return instance;
	}
	
	public void initTransaction(){
		transaction = entityManager().getTransaction();
		transaction.begin();
	}
	
	public void addIndicator(Indicator indicator){
		System.out.println("addIndicator " + indicator.getName() + " " + indicator.getFormula());
		entityManager().persist(indicator);
	}
	
	public void deleteIndicator(Indicator indicator){
		entityManager().remove(indicator);
	}
	
	public List<Indicator> getIndicatorList(){
		return entityManager()
		        .createQuery("from Indicator", Indicator.class)
		        .getResultList();
	}
	
	public Optional<Indicator> fetchIndicator(String name){
		return entityManager()
		        .createQuery("from Indicator where name like :name", Indicator.class)
		        .setParameter("name", "%" + name + "%")
		        .getResultList().stream()
		        .findFirst();
	}

	public Indicator getIndicator(String name){
		return fetchIndicator(name).orElseThrow(() -> new MissingIndicatorException(name));
	}
	
	public Boolean alreadyExists(String name){
		 return fetchIndicator(name).isPresent();
	}
	
	public void updateIndicator(Indicator indicator) {
		entityManager().merge(indicator);
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

	public void saveChanges() {
		transaction.commit();
	}
}
