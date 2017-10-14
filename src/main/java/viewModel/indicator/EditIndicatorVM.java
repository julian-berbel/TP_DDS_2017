package viewModel.indicator;

import java.util.Optional;


import exceptions.ExistingIndicatorException;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;


public class EditIndicatorVM {
	
	private String name;
	private String formula;
	private Optional<Indicator> targetIndicator;
	
	public Optional<Indicator> getTargetIndicator() {
		return targetIndicator;
	}

	public EditIndicatorVM(Optional<Indicator> target){
		targetIndicator = target;
		target.ifPresent(_target -> {
			name = _target.getName();
			formula = _target.getFormula();
		});
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
	private boolean nameViolation(){
		return (!editing() && IndicatorRepository.getInstance().alreadyExists(name)) ||
				(editing() && !name.equals(targetIndicator.get().getName()) && IndicatorRepository.getInstance().alreadyExists(name));
	}

	public void accept(){
		if(nameViolation()) throw new ExistingIndicatorException(name);

		targetIndicator = Optional.of(
				editing() ? new Indicator(name, formula, targetIndicator.get().getId()) : new Indicator(name, formula));
	}
	
	private boolean editing(){
		return targetIndicator.isPresent();
	}
	
}
