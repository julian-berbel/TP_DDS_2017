package modelo.method.result;

import java.util.function.Predicate;

import modelo.enterprise.Enterprise;

public class Pass extends Result {
	
	public Pass(Enterprise enterprise){
		super(enterprise);
	}

	@Override
	public Result eval(Predicate<Enterprise> f) {
		Result result;
		try{
			result = f.test(enterprise) ? new Pass(enterprise) : new Fail(enterprise);
		} catch(Exception e){
			result = new Error(enterprise, e);
		}
		
		return result;
	}
}
