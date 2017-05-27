package math;

import modelo.Enterprise;

public class Negative implements Operable {

	private Operable value;
	
	public Negative(Operable value) {
		this.value = value;
	}
	
	public double reduce(Enterprise enterprise, int year){
		return - value.reduce(enterprise, year);
	}

}
