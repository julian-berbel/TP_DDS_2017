package modelo.method.criteria;

public abstract class Criterion {
	
	protected abstract String buildDescription();
	
	@Override
	public String toString(){
		return buildDescription();
	}
}
