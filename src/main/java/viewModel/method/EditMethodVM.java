package viewModel.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import exceptions.ExistingMethodException;
import exceptions.SelectedCriterionBelongsToMixedCriterionException;
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
	private Criterion selectedFilterCriterion;
	private OrderCriterion selectedOrderCriterion;
	private MixedCriterion selectedMixedCriterion;

	public EditMethodVM(Optional<Method> target) 
	{
		targetMethod = target;
		target.ifPresent(_target -> {	
				name = _target.getName();
				filterCriteria = new ArrayList<FilterCriterion>(_target.getFilterCriteria());
				orderCriteria = new ArrayList<OrderCriterion>(_target.getOrderCriteria());
				mixedCriteria = new ArrayList<MixedCriterion>(_target.getMixedCriteria());
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
	
	public void addFilterCriterion(Optional<FilterCriterion> filterCriterion)
	{
		filterCriterion.ifPresent(_filterCriterion -> filterCriteria.add(_filterCriterion));
		refreshList();
	}
	
	public void addOrderCriterion(Optional<OrderCriterion> orderCriterion)
	{
		orderCriterion.ifPresent(_orderCriterion -> orderCriteria.add(_orderCriterion));
		refreshList();
	}
	
	public void addMixedCriterion(Optional<MixedCriterion> mixedCriterion)
	{
		mixedCriterion.ifPresent(_mixedCriterion -> {
			mixedCriteria.add(_mixedCriterion);
			filterCriteria.add(_mixedCriterion.getFilterCriterion());
			orderCriteria.add(_mixedCriterion.getOrderCriterion());
		});
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
		if(belongsToMixedCriterion(selectedFilterCriterion)) throw new SelectedCriterionBelongsToMixedCriterionException();
		filterCriteria.remove(selectedFilterCriterion);
		refreshList();
	}
	
	public void deleteOrderCriterion() 
	{
		if(belongsToMixedCriterion(selectedOrderCriterion)) throw new SelectedCriterionBelongsToMixedCriterionException();
		orderCriteria.remove(selectedOrderCriterion);
		refreshList();
	}
	
	public void deleteMixedCriterion() 
	{
		if(selectedMixedCriterion != null){
			filterCriteria.remove(selectedMixedCriterion.getFilterCriterion());
			orderCriteria.remove(selectedMixedCriterion.getOrderCriterion());
			mixedCriteria.remove(selectedMixedCriterion);
			refreshList();
		}
	}

	public void refreshList()
	{
		ObservableUtils.firePropertyChanged(this, "filterCriteria");
		ObservableUtils.firePropertyChanged(this, "orderCriteria");
		ObservableUtils.firePropertyChanged(this, "mixedCriteria");
	}
	
	private boolean editing(){
		return targetMethod.isPresent();
	}
	
	private boolean nameViolation(){
		return (!editing() && MethodRepository.getInstance().alreadyExists(name)) ||
				(editing() && !name.equals(targetMethod.get().getName()) && MethodRepository.getInstance().alreadyExists(name));
	}

	public void accept(){
		if(nameViolation()) throw new ExistingMethodException(name);
		
		
		targetMethod = Optional.of(
				editing() ? new Method(name, filterCriteria, orderCriteria, mixedCriteria, targetMethod.get().getId()) : new Method(name, filterCriteria, orderCriteria, mixedCriteria));
	}
	
	private Boolean belongsToMixedCriterion(Criterion criterion){
		return mixedCriteria.stream().anyMatch(mixedCriterion -> mixedCriterion.uses(criterion));
	}
	
	public void switchUp(){
		swapWithRelativePosition(-1);
	}
	
	public void switchDown(){
		swapWithRelativePosition(1);
	}
	
	public void swapWithRelativePosition(int b){
		int selectedIndex = orderCriteria.indexOf(selectedOrderCriterion);
		
		try{
			Collections.swap(orderCriteria, selectedIndex, selectedIndex + b);
		} catch(IndexOutOfBoundsException e){
			
		}
		
		OrderCriterion auxCriterion = selectedOrderCriterion;	// por alguna razon al swappear para arriba la vista no se actualiza
		List<OrderCriterion> auxList = orderCriteria;			// y un firePropertyChanged no lo arregla tampoco
		orderCriteria = null;									// ENCONTRAR UN FIX MEJOR! ESTO ES HORRIBLE! TODO
		orderCriteria = auxList;
		selectedOrderCriterion = auxCriterion;
	}
	
}

