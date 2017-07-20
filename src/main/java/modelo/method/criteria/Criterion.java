package modelo.method.criteria;

public abstract class Criterion {
	private String description;
	
	public Criterion(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return description;
	}
	
	@Override
	public String toString(){
		return description;
	}
}
