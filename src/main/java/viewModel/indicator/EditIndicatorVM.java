package viewModel.indicator;

import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import exceptions.ExistingIndicatorException;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

@Observable
public class EditIndicatorVM {
	
	private String name;
	private String originalName;
	private String formula;
	private Optional<Indicator> targetIndicator = Optional.empty();
	private Boolean editing = false;
	
	public Optional<Indicator> getTargetIndicator() {
		return targetIndicator;
	}

	public EditIndicatorVM(Optional<Indicator> target){
		target.ifPresent(_target -> {
			name = _target.getName();
			originalName = _target.getName();
			formula = _target.getFormula();
			editing = true;
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

	public void accept(){
		if(!editing && IndicatorRepository.getInstance().alreadyExists(name)) throw new ExistingIndicatorException(name);
		if(editing)
		{
			if(!name.equals(originalName) && IndicatorRepository.getInstance().alreadyExists(name))
			{
				throw new ExistingIndicatorException(name);
			}
			
		}
		targetIndicator = Optional.of(new Indicator(name, formula));
		
	}
	
}
