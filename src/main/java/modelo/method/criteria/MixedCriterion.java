package modelo.method.criteria;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class MixedCriterion extends Criterion
{
	private OrderCriterion orderCriterion;
	private FilterCriterion filterCriterion;
	
	public MixedCriterion(OrderCriterion orderCriterion, FilterCriterion filterCriterion) {
		this.orderCriterion = orderCriterion;
		this.filterCriterion = filterCriterion;
	}
	
	public OrderCriterion getOrderCriterion() {
		return orderCriterion;
	}

	public FilterCriterion getFilterCriterion() {
		return filterCriterion;
	}
	
	public Boolean uses(Criterion criterion){
		return orderCriterion == criterion || filterCriterion == criterion;
	}
}
