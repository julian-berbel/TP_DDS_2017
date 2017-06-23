package math;

import java.math.BigDecimal;
import modelo.Enterprise;
import modelo.Indicator;

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
