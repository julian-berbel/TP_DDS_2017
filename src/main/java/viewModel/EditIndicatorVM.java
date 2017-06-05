package viewModel;

import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import exceptions.ExistingIndicatorException;
import modelo.Indicator;
import modelo.IndicatorRepository;

@Observable
public class EditIndicatorVM {
	
	private String name;
	private String formula;
	private Optional<Indicator> targetIndicator;
	private Boolean editing = false;
	
	public Optional<Indicator> getTargetIndicator() {
		return targetIndicator;
	}

	public EditIndicatorVM(Optional<Indicator> target){
		target.ifPresent(_target -> {	name = _target.getName();
										formula = _target.getFormula();
										editing = true;});
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

	public void accept(){
		if(!editing && IndicatorRepository.alreadyExists(name)) throw new ExistingIndicatorException(name);
		
		targetIndicator = Optional.of(new Indicator(name, formula));
	}
	
	public void cancel(){
		targetIndicator = Optional.empty();
	}
	
}
