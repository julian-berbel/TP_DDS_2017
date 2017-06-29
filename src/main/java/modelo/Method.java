package modelo;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import parser.IndicatorParser;

import java.util.ArrayList;

@Observable
public class Method {

	private String name;
	private List<OrderCriteria> orderCriteria;
	private List<FilterCriteria> filterCriteria;
	private List<Indicator> indicators;
	private String formula;

	public Method(String name, String formula) 
	{
		orderCriteria = new ArrayList<OrderCriteria>();
		filterCriteria = new ArrayList<FilterCriteria>();
		indicators = new ArrayList<Indicator>();
		this.name = name;
		this.formula = formula;
//		this.value = IndicatorParser.parseIndicator(formula);
	}

	public void setName(String _name) 
	{
		name = _name;
	}

	public String getName() 
	{
		return name;
	}
	
	public String getFormula()
	{
		return formula;
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

	public void setOrderCriteriaList(List<OrderCriteria> list) 
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

	public void setIndicatorList(List<Indicator> list)
	{
		indicators = list;
	}

	public void addOrderCriteria(OrderCriteria _orderCriteria) 
	{
		orderCriteria.add(_orderCriteria);
	}
}
