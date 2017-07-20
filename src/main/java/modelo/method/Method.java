package modelo.method;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.lambda.Seq;
import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.order.Unordered;

@Observable
public class Method {

	private String name;
	private List<FilterCriterion> filterCriteria;
	private List<OrderCriterion> orderCriteria;
	private List<MixedCriterion> mixedCriteria;

	public Method(String name, List<FilterCriterion> filterCriteria, List<OrderCriterion> orderCriteria, List<MixedCriterion> mixedCriteria)
	{
		this.name = name;
		this.filterCriteria = filterCriteria;
		this.orderCriteria = orderCriteria;
		this.mixedCriteria = mixedCriteria;
	}

	public String getName()
	{
		return name;
	}
	
	public List<FilterCriterion> getFilterCriteria() 
	{
		return filterCriteria;
	}
	
	public List<OrderCriterion> getOrderCriteria() 
	{
		return orderCriteria;
	}
	
	public List<MixedCriterion> getMixedCriteria() {
		return mixedCriteria;
	}
	
	private Comparator<Enterprise> buildComparator(){
		return Seq.seq(orderCriteria.stream())
				.foldLeft((Comparator<Enterprise>) new Unordered(), (seed, comp) -> seed.thenComparing(comp));
	}
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return enterprises.stream()
				.filter(enterprise -> 
					filterCriteria.stream()
						.allMatch(filterCriterion -> 
							filterCriterion.isMetBy(enterprise)))
				.sorted(buildComparator())
				.collect(Collectors.toList());
	}
}
