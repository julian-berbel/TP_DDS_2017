package modelo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class OrderCriterion 
{
	private String criterionName;
	
	public OrderCriterion(String name){
		criterionName = name;
	}
	
	public String getName()
	{
		return criterionName;
	}
	
	public abstract int criterion(Enterprise oneEnterprise, Enterprise anotherEnterprise); // el que esto tenga que devolver int me deprime
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		return enterprises.stream()
				.sorted((oneEnterprise, anotherEnterprise) -> criterion(oneEnterprise, anotherEnterprise))
				.collect(Collectors.toList());
	}
}
