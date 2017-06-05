package math;

import modelo.Enterprise;
import modelo.Indicator;

public class Negative implements Operable {

	private Operable value;
	
	public Negative(Operable value) {
		this.value = value;
	}
	
	public double reduce(Enterprise enterprise, int year){
		return - value.reduce(enterprise, year);
	}

	public String toString(){
		return "-" + value.toString();
	}
	
	public Boolean includes(Indicator indicator){
		return value.includes(indicator);
	}
}
