package modelo;

import java.util.List;
import java.util.ArrayList;

public class Method {

	private String name;
	private List<OrderCriteria> orderCriteria;
	private List<FilterCriteria> filterCriteria;
	private List<Indicator> indicators;

	public Method() 
	{
		orderCriteria = new ArrayList<OrderCriteria>();
		filterCriteria = new ArrayList<FilterCriteria>();
		indicators = new ArrayList<Indicator>();
	}

	public void setName(String _name) 
	{
		name = _name;
	}

	public String getName() 
	{
		return name;
	}

	public List<FilterCriteria> getFilterCriteriaList() 
	{
		return filterCriteria;
	}

	public void setFilterCriteriaList(List<FilterCriteria> list) 
	{
		filterCriteria = list;
	}

	public void addFilterCriteria(FilterCriteria _filterCriteria) 
	{
		filterCriteria.add(_filterCriteria);		
	}

	public List<OrderCriteria> geOrderCriteriaList() 
	{
		return orderCriteria;
	}

	public void seOrderCriteriaList(List<OrderCriteria> list) 
	{
		orderCriteria = list;
	}

	public void addIndicator(Indicator indicator) 
	{
		indicators.add(indicator);
	}

	public List<Indicator> getIndicatorList() 
	{
		return indicators;
	}

	public void setOrderCriteriaList(List<Indicator> list)
	{
		indicators = list;
	}

	public void addOrderCriteria(OrderCriteria _orderCriteria) 
	{
		orderCriteria.add(_orderCriteria);
	}
}
