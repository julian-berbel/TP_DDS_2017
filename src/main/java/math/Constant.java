package math;

public class Constant implements Operable {
	public double value;
	
	public Constant(double value){
		this.value = value;
	}
	
	public double reduce(){
		return value;
	}
}
