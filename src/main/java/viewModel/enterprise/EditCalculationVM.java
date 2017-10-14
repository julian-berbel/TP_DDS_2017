package viewModel.enterprise;

import java.math.BigDecimal;
import java.util.Optional;

import exceptions.EmptyFieldException;
import exceptions.ExistingCalculationException;
import modelo.enterprise.Calculation;
import modelo.enterprise.Period;


public class EditCalculationVM {
	private String calculationName;
	private String calculationOriginalName;
	private BigDecimal calculationValue;
	private Period period;
	private Optional<Calculation> targetCalculation = Optional.empty();
	private Boolean editing = false;
	
	public EditCalculationVM(Period actualPeriod,Optional<Calculation> targetCalculation){
		period=actualPeriod;
		targetCalculation.ifPresent(_target -> {
			this.targetCalculation=targetCalculation;
			calculationName = _target.getName();
			calculationOriginalName = _target.getName();
			calculationValue = _target.getValue();
			editing = true;
			
		});
	}
	
	public String getCalculationName() {
		return calculationName;
	}

	public void setCalculationName(String calculationName) {
		this.calculationName = calculationName;
	}

	public BigDecimal getCalculationValue() {
		return calculationValue;
	}

	public void setCalculationValue(BigDecimal calculationValue) {
		this.calculationValue = calculationValue;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Optional<Calculation> getTargetCalculation() {
		return targetCalculation;
	}

	public void setTargetCalculation(Optional<Calculation> targetCalculation) {
		this.targetCalculation = targetCalculation;
	}

	public Boolean getEditing() {
		return editing;
	}
	private Boolean calculationNameAlreadyExists()
	{
		return period.getCalculations().stream().anyMatch(calculation->calculation.getName().equals(calculationName));
	}
	public void accept(){
		if(!editing && this.calculationNameAlreadyExists()) throw new ExistingCalculationException(calculationName);
		if(calculationName == null) throw new EmptyFieldException("Nombre de la cuenta");
		if(calculationValue == null) throw new EmptyFieldException("Valor de la cuenta");
		
		
		if(editing && !calculationName.equals(calculationOriginalName) && this.calculationNameAlreadyExists())
		{
			throw new ExistingCalculationException(calculationName);
		}
		
		targetCalculation = Optional.of(
				editing ? new Calculation(calculationName, calculationValue, targetCalculation.get().getId()) : new Calculation(calculationName, calculationValue));
	
	
		
	}
	
}
