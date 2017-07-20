package viewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import exceptions.ExistingIndicatorException;
import modelo.method.Method;
import modelo.method.MethodRepository;
import modelo.method.criteria.Criterion;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.OrderCriterion;

@Observable
public class EditMethodVM 
{

	private String name;
	private List<FilterCriterion> filterCriteria = new ArrayList<FilterCriterion>();
	private List<OrderCriterion> orderCriteria = new ArrayList<OrderCriterion>();
	private List<MixedCriterion> mixedCriteria = new ArrayList<MixedCriterion>();
	private Optional<Method> targetMethod;
	private Boolean editing = false;
	private Criterion selectedFilterCriterion;
	private OrderCriterion selectedOrderCriterion;
	private MixedCriterion selectedMixedCriterion;

	public EditMethodVM(Optional<Method> target) 
	{
		target.ifPresent(_target -> {	
				name = _target.getName();
				filterCriteria = _target.getFilterCriteria();
				orderCriteria = _target.getOrderCriteria();
				mixedCriteria = _target.getMixedCriteria();
				editing = true;
			});
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
	
	public List<FilterCriterion> getFilterCriteria() {
		return filterCriteria;
	}

	public void setFilterCriteria(List<FilterCriterion> filterCriteria) {
		this.filterCriteria = filterCriteria;
	}

	public List<OrderCriterion> getOrderCriteria() {
		return orderCriteria;
	}

	public void setOrderCriteria(List<OrderCriterion> orderCriteria) {
		this.orderCriteria = orderCriteria;
	}

	public List<MixedCriterion> getMixedCriteria() {
		return mixedCriteria;
	}

	public void setMixedCriteria(List<MixedCriterion> mixedCriteria) {
		this.mixedCriteria = mixedCriteria;
	}
	
	public void addFilterCriterion(FilterCriterion filterCriterion)
	{
		filterCriteria.add(filterCriterion);
		refreshList();
	}
	
	public void addOrderCriterion(OrderCriterion orderCriterion)
	{
		orderCriteria.add(orderCriterion);
		refreshList();
	}
	
	public void addMixedCriterion(MixedCriterion mixedCriterion)
	{
		mixedCriteria.add(mixedCriterion);
		refreshList();
	}
	
	public Criterion getSelectedFilterCriterion() {
		return selectedFilterCriterion;
	}

	public void setSelectedFilterCriterion(Criterion selectedFilterCriterion) {
		this.selectedFilterCriterion = selectedFilterCriterion;
	}

	public OrderCriterion getSelectedOrderCriterion() {
		return selectedOrderCriterion;
	}

	public void setSelectedOrderCriterion(OrderCriterion selectedOrderCriterion) {
		this.selectedOrderCriterion = selectedOrderCriterion;
	}

	public MixedCriterion getSelectedMixedCriterion() {
		return selectedMixedCriterion;
	}

	public void setSelectedMixedCriterion(MixedCriterion selectedMixedCriterion) {
		this.selectedMixedCriterion = selectedMixedCriterion;
	}

	public void deleteFilterCriterion() 
	{
		filterCriteria.remove(selectedFilterCriterion);
		refreshList();
	}
	
	public void deleteOrderCriterion() 
	{
		orderCriteria.remove(selectedOrderCriterion);
		refreshList();
	}
	
	public void deleteMixedCriterion() 
	{
		mixedCriteria.remove(selectedMixedCriterion);
		refreshList();
	}

	public void refreshList()
	{
		ObservableUtils.firePropertyChanged(this, "filterCriteria");
		ObservableUtils.firePropertyChanged(this, "orderCriteria");
		ObservableUtils.firePropertyChanged(this, "mixedCriteria");
	}

	public void accept(){
		if(!editing && MethodRepository.alreadyExists(name)) throw new ExistingIndicatorException(name);
		
		targetMethod = Optional.of(new Method(name, filterCriteria, orderCriteria, mixedCriteria));
	}
	
	public void cancel(){
		targetMethod = Optional.empty();
	}
	
	
	
}

