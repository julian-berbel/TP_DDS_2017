package modelo.enterprise;

import java.math.BigDecimal;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exceptions.EmptyFieldException;
import modelo.db.ModelEntity;
import modelo.indicator.Indicator;

@Entity
@Table(name = "Enterprises")
public class Enterprise extends ModelEntity
{
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(	cascade = CascadeType.ALL,
				orphanRemoval = true,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "enterprise_id", referencedColumnName = "id")
	private List<Period> periods;
	
	public Enterprise(String name, List<Period> periods)
	{
		if(name == null) throw new EmptyFieldException("Nombre de la empresa"); 
		this.name = name;
		this.periods = periods;
	}
	
	public Enterprise(String name, List<Period> periods, Long id)
	{
		this(name, periods);
		this.id = id;
	}
	
	protected Enterprise(){}
	
	public List<Period> getPeriods()
	{
		return periods;
	}
	
	public List<BigDecimal> getIndicatorValueFromLastNYears(Indicator indicator, int n){
		return periods.stream()
				.filter(period -> period.getYear() >= (Year.now().getValue() - n))
				.map(period -> indicator.reduce(this, period.getYear()))
				.collect(Collectors.toList());
	}
	
	public String getName()
	{
		return name;
	}
	
	public Calculation getCalculationOnYear(String name, int year){
		return periods.stream()
				.filter(period -> period.getYear() == year)
				.findFirst()
				.get()
				.getCalculation(name);
	}
	
	public int age(){
		return Year.now().getValue() - this.getPeriods().stream()
											.mapToInt(period -> period.getYear())
											.min()
											.getAsInt();
	}
	
	public void addPeriod(Period period){
		periods.add(period);
	}

	public void merge(Enterprise oldEnterprise) {
		periods.stream().forEach(period -> {
			Map<String, Object> searchCriteria = new HashMap<>();
			searchCriteria.put("enterprise_id", oldEnterprise.getId());
			searchCriteria.put("year", period.getYear());
			Optional<Period> maybePeriod = PeriodRepository.getInstance().fetchElement(searchCriteria);
			
			if(maybePeriod.isPresent()){
				period.merge(maybePeriod.get());
			}else {
				PeriodRepository.getInstance().addElement(period);
				oldEnterprise.addPeriod(period);
				EnterpriseRepository.getInstance().updateElement(oldEnterprise);
			}
		});
	}

}
