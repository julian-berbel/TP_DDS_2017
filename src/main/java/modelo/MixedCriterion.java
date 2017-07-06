package modelo;

import java.util.List;

public class MixedCriterion {
	private OrderCriterion orderCriterion;
	private FilterCriterion filterCriterion;
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return orderCriterion.apply(filterCriterion.apply(enterprises));
	}
}
