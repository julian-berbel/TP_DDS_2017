package viewModel.method;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.method.Method;
import modelo.method.result.Error;

@Observable
public class MethodResultVM {

	private List<Enterprise> passes;
	private List<Enterprise> failures;
	private List<Error> errors;
	
	public MethodResultVM(Method selectedMethod){
		passes = selectedMethod.apply(EnterpriseRepository.getEnterpriseList()).stream()
					.filter(result -> result.isSuccess())
					.map(result -> result.getEnterprise())
					.collect(Collectors.toList());
		
		failures = selectedMethod.apply(EnterpriseRepository.getEnterpriseList()).stream()
				.filter(result -> result.isFailure())
				.map(result -> result.getEnterprise())
				.collect(Collectors.toList());
		
		errors = selectedMethod.apply(EnterpriseRepository.getEnterpriseList()).stream()
				.filter(result -> result.isError())
				.map(result -> (Error) result)
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
