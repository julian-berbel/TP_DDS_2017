package modelo.method.result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import modelo.enterprise.Enterprise;

public class MethodReport {
	
	private List<Pass> passes = new ArrayList<Pass>();
	private List<Fail> failures = new ArrayList<Fail>();
	private List<Error> errors = new ArrayList<Error>();

	public void addPass(Pass pass) {
    passes.add(pass);
  }
	
	public void addFail(Fail fail) {
    failures.add(fail);
  }
	
	public void addError(Error error) {
    errors.add(error);
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

  public void sortPasses(Comparator<Enterprise> comparator) {
    passes.sort((aPass, anotherPass) -> comparator.compare(aPass.getEnterprise(), anotherPass.getEnterprise()));
  }

}
