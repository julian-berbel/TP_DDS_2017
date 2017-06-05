package math;

import modelo.Enterprise;
import modelo.Indicator;

public class Constant implements Operable {
	public double value;
	
	public Constant(double value){
		this.value = value;
	}
	
	public double reduce(Enterprise enterprise, int year){
		return value;
	}
	
	public String toString(){
		return String.valueOf(value);
	}
	
	public Boolean includes(Indicator indicator){
		return false;
	}
}
