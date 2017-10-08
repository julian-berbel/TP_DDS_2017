package viewModel.method;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.method.Method;
import modelo.method.result.Error;
import modelo.method.result.Fail;
import modelo.method.result.Pass;
import modelo.method.result.Result;

@Observable
public class MethodResultVM {

	private List<Enterprise> passes;
	private List<Enterprise> failures;
	private List<Error> errors;
	
	public MethodResultVM(Method selectedMethod){
		List<Result> results = selectedMethod.apply(EnterpriseRepository.getInstance().getList());
		
		passes = getMappedBy(results, Pass.class, result -> result.getEnterprise());
		
		failures = getMappedBy(results, Fail.class, result -> result.getEnterprise());
		
		errors = getMappedBy(results, Error.class, result -> (Error) result);
	}
	
	private <T> List<T> getMappedBy(List<Result> results, Class<?> a, Function<Result, T> f){
		return results.stream()
				.filter(result -> a.isInstance(result))
				.map(f)
				.collect(Collectors.toList());
	}
	
	public List<Enterprise> getPasses() {
		return passes;
	}

	public void setPasses(List<Enterprise> passes) {
		this.passes = passes;
	}

	public List<Enterprise> getFailures() {
		return failures;
	}

	public void setFailures(List<Enterprise> failures) {
		this.failures = failures;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}