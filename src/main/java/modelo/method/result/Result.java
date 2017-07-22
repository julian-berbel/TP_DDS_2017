package modelo.method.result;

import java.util.function.Function;

import modelo.enterprise.Enterprise;

public abstract class Result{
	
	protected Enterprise enterprise;
	
	public Result(Enterprise enterprise){
		this.enterprise = enterprise;
	}

	public Boolean isSuccess(){
		return false;
	}
	
	public Boolean isFailure(){
		return false;
	}
	
	public Boolean isError(){
		return false;
	}
	
	public Result eval(Function<Enterprise, Boolean> f) {
		return this;
	}
	
	public Enterprise getEnterprise(){
		return enterprise;
	}
}
