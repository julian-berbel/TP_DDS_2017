package modelo.indicator.math;

import java.math.BigDecimal;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public class Negative implements Operable {

	private Operable value;
	
	public Negative(Operable value) {
		this.value = value;
	}
	
	public BigDecimal reduce(Enterprise enterprise, int year){
		return (value.reduce(enterprise, year)).negate();
	}

	public String toString(){
		return "-" + value.toString();
	}
	
	public Boolean includes(Indicator indicator){
		return value.includes(indicator);
	}
}
