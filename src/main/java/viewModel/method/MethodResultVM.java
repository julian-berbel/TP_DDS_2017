package viewModel.method;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.method.Method;

@Observable
public class MethodResultVM {

	private List<Enterprise> results;
	
	public MethodResultVM(Method selectedMethod){
		results = selectedMethod.apply(EnterpriseRepository.getEnterpriseList());
	}

	public List<Enterprise> getResults() {
		return results;
	}

	public void setResults(List<Enterprise> results) {
		this.results = results;
	}

}
