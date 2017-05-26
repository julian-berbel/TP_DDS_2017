package math;

import modelo.Enterprise;

public class Constant implements Operable {
	public double value;
	
	public Constant(double value){
		this.value = value;
	}
	
	public double reduce(Enterprise enterprise, int year){
		return value;
	}
}
