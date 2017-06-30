package modelo;

import java.util.List;

import org.jooq.lambda.Seq;
import org.uqbar.commons.utils.Observable; //?

@Observable
public class Method {

	private String name;
	private OrderCriterion orderCriterion;
	private List<FilterCriterion> filterCriteria;

	public Method(String name, OrderCriterion orderCriterion, List<FilterCriterion> filterCriteria) 
	{
		this.name = name;
		this.orderCriterion = orderCriterion;
		this.filterCriteria = filterCriteria;
	}

	public String getName() 
	{
		return name;
	}
	
	public List<FilterCriterion> getFilterCriteriaList() 
	{
		return filterCriteria;
	}
	
	public OrderCriterion getOrderCriterion() 
	{
		return orderCriterion;
	}
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return orderCriterion.apply(
				Seq.seq(filterCriteria.stream())
					.foldLeft(enterprises, (enterprise, filter) -> filter.apply(enterprise)));
	}
}
