package modelo.method.criteria;

import javax.persistence.MappedSuperclass;

import modelo.ModelEntity;

@MappedSuperclass
public abstract class Criterion extends ModelEntity{
	
	protected abstract String buildDescription();
	
	@Override
	public String toString(){
		return buildDescription();
	}
}
