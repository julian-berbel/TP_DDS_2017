package modelo.method.result;

import modelo.enterprise.Enterprise;
import modelo.method.criteria.FilterCriterion;

public class Pass extends Result {
	
	public Pass(Enterprise enterprise){
		super(enterprise);
	}

	@Override
	public Result eval(FilterCriterion criterion) {
		Result result;
		try{
			result = criterion.test(enterprise) ? new Pass(enterprise) : new Fail(enterprise);
		} catch(Exception e){
			result = new Error(enterprise, e);
		}
		
		return result;
	}
	
	public void insertInto(MethodReport report) {
	  report.addPass(this);
	}
	
}
