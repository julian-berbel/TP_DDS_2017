package modelo;

public class MaximizeIndicatorCriterion extends OrderCriterion {
	private Indicator indicator;
	
	public MaximizeIndicatorCriterion(String name, Indicator indicator){
		super(name);
		this.indicator = indicator;
	}

	public int criterion(Enterprise oneEnterprise, Enterprise anotherEnterprise) {
		return indicator.reduce(oneEnterprise, 0).compareTo(indicator.reduce(anotherEnterprise, 0)); //TODO de donde saco el anio?
	}
		
}
