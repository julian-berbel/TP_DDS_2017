package modelo.method.result;

import java.util.List;

public class MethodReport {
	
	private List<Pass> passes;
	private List<Fail> failures;
	private List<Error> errors;

	public MethodReport(List<Pass> passes, List<Fail> failures, List<Error> errors) {
		this.passes = passes;
		this.failures = failures;
		this.errors = errors;
	}

	public List<Pass> getPasses() {
		return passes;
	}

	public List<Fail> getFailures() {
		return failures;
	}

	public List<Error> getErrors() {
		return errors;
	}

}
