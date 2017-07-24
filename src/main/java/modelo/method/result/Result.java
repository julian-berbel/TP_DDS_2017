package modelo.method.result;

import java.util.function.Predicate;

import modelo.enterprise.Enterprise;

public abstract class Result{
	
	protected Enterprise enterprise;
	
	public Result(Enterprise enterprise){
		this.enterprise = enterprise;
	}
	
	public Result eval(Predicate<Enterprise> f) {
		return this;
	}
	
	public Enterprise getEnterprise(){
		return enterprise;
	}
}
