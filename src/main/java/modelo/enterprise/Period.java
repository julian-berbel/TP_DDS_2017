package modelo.enterprise;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exceptions.MissingCalculationInPeriodException;
import modelo.db.ModelEntity;

@Entity
@Table(name = "Periods")
public class Period extends ModelEntity
{	
	@Column(nullable = false)
	private int year;
	
	@OneToMany(	cascade = CascadeType.ALL,
				orphanRemoval = true,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "period_id", referencedColumnName = "id")
	private List<Calculation> calculations;
	
	public Period(int year, List<Calculation> calculations)
	{
		this.year = year;
		this.calculations = calculations;
	}
	
	protected Period(){}
	
	public List<Calculation> getCalculations()
	{
		return calculations;
	}
	
	public int getYear() {
		return year;
	}
	public void addCalculation(Calculation calculation)
	{
		calculations.add(calculation);
	}
	public void replaceCalculation(Calculation oldCalculation, Calculation newCalculation)
	{
		calculations.replaceAll(calculation -> calculation == oldCalculation ? newCalculation:calculation);
	}
		
	public Calculation getCalculation(String name){
		return calculations.stream()
				.filter(calculation -> calculation.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new MissingCalculationInPeriodException(name, this));
	}
	
	@Override
	public String toString(){
		return String.valueOf(year);
	}

	public void merge(Period period) {
		calculations.forEach(c -> System.out.println("Calculation " + c.getName() + " " + c.getValue()));
		calculations.stream().forEach(calculation -> {
			Map<String, Object> searchCriteria = new HashMap<>();
			searchCriteria.put("period_id", period.getId());
			searchCriteria.put("name", calculation.getName());
			Optional<Calculation> maybeCalculation = CalculationRepository.getInstance().fetchElement(searchCriteria);
			
			if(maybeCalculation.isPresent()){
				calculation.merge(maybeCalculation.get());
			}else {
				CalculationRepository.getInstance().addElement(calculation);
				period.addCalculation(calculation);
				PeriodRepository.getInstance().updateElement(period);
			}
		});
	}
}
