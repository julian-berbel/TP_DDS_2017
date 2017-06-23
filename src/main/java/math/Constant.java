package math;

import java.math.BigDecimal;
import modelo.Enterprise;
import modelo.Indicator;

public class Constant implements Operable {
	public BigDecimal value;
	
	public Constant(BigDecimal value){
		this.value = value;
	}
	
	public BigDecimal reduce(Enterprise enterprise, int year){
		return value;
	}
	
	public String toString(){
		return String.valueOf(value);
	}
	
	public Boolean includes(Indicator indicator){
		return false;
	}
}
