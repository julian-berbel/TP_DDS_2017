package modelo.enterprise;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import exceptions.MissingCalculationInPeriodException;
import modelo.ModelEntity;

@Entity
public class Period extends ModelEntity
{
	private int year;
	
	@OneToMany
	private List<Calculation> calculations;
	
	public Period(int year, List<Calculation> calculations)
	{
		this.year = year;
		this.calculations = calculations;
	}
	
	public List<Calculation> getCalculations()
	{
		return calculations;
	}
	
	public int getYear() {
		return year;
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
}
