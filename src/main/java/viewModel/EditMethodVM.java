package viewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import exceptions.ExistingIndicatorException;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import modelo.method.Method;
import modelo.method.MethodRepository;
import modelo.method.criteria.Criterion;

@Observable
public class EditMethodVM 
{

	private String name;
	private List<Criterion> criteria = new ArrayList<Criterion>();
	private Optional<Method> targetMethod;
	private Boolean editing = false;
	private Criterion selectedCriteria;
	


	public EditMethodVM(Optional<Method> target) 
	{
		target.ifPresent(_target -> {	name = _target.getName();
		criteria = _target.getCriteriaList();
		editing = true;});
	}
	
	public Optional<Method> getTargetMethod() 
	{
		return targetMethod;
	}
	
	public void setTargetMethod(Optional<Method> targetMethod) 
	{
		this.targetMethod = targetMethod;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Criterion> getCriteria()
	{
		return criteria;
	}
	
	public void setCriteria(List<Criterion> criteria)
	{
		this.criteria = criteria;
	}
	
	
	public void addCriterion(Criterion criterion)
	{
		criteria.add(criterion);
		refreshList();
	}
	public Criterion getSelectedCriteria()
	{
		return selectedCriteria;
	}

	public void setSelectedCriteria(Criterion selectedCriteria) 
	{
		this.selectedCriteria = selectedCriteria;
	}

	public void deleteCriteria() 
	{
		criteria.remove(selectedCriteria);
		refreshList();
	}

	public void refreshList()
	{
		ObservableUtils.firePropertyChanged(this, "criteria");
		editing = true;
	}

	public void accept(){
		if(!editing && MethodRepository.alreadyExists(name)) throw new ExistingIndicatorException(name);
		
		targetMethod = Optional.of(new Method(name, criteria));
	}
	
	public void cancel(){
		targetMethod = Optional.empty();
	}
	
	
	
}

