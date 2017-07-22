package modelo.method.result;

import java.util.function.Function;

import modelo.enterprise.Enterprise;

public class Pass extends Result {
	
	public Pass(Enterprise enterprise){
		super(enterprise);
	}
	
	@Override
	public Boolean isSuccess(){
		return true;
	}

	public Result eval(Function<Enterprise, Boolean> f) {
		Result result;
		try{
			result = f.apply(enterprise) ? new Pass(enterprise) : new Fail(enterprise);
		} catch(Exception e){
			result = new Error(enterprise, e);
		}
		
		return result;
	}
}
