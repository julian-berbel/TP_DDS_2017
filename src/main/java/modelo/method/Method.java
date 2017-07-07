package modelo.method;

import java.util.List;

import org.jooq.lambda.Seq;
import org.uqbar.commons.utils.Observable; //?

import modelo.enterprise.Enterprise;
import modelo.method.criteria.Criterion;

@Observable
public class Method {

	private String name;
	private List<Criterion> criteria;

	public Method(String name, List<Criterion> criteria) 
	{
		this.name = name;
		this.criteria = criteria;
	}

	public String getName() 
	{
		return name;
	}
	
	public List<Criterion> getCriteriaList() 
	{
		return criteria;
	}
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return Seq.seq(criteria.stream())
					.foldLeft(enterprises, (enterprise, criterion) -> criterion.apply(enterprise));
	}
}
