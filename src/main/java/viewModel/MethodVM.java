package viewModel;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import exceptions.ExistingIndicatorException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import modelo.method.Method;
import modelo.method.MethodRepository;

@Observable
public class MethodVM {

	private List<Method> methods;
	private Method selectedMethod;
	private Boolean methodsChanged;
	
	public MethodVM(){
		setMethodsChanged(false);
		if(MethodRepository.getMethods() !=null)
		{
			
			refreshList();
		}	
	}
	
	public List<Method> getMethod() {
		return methods;
	}
	
	public void setMethod(List<Method> methods) {
		this.methods = methods;
	}
	
	public Method getSelectedMethod() {
		return selectedMethod;
	}
	
	public void setSelectedMethod(Method selectedMethod) {
		this.selectedMethod = selectedMethod;
	}

	public void addNewMethod(Optional<Method> newMethod) {
		
		newMethod.ifPresent(method ->MethodRepository.addMethod(method));
		refreshList();
		
	}

	public Boolean getMethodsChanged() {
		return methodsChanged;
	}

	public void setMethodsChanged(Boolean methodsChanged) {
		this.methodsChanged = methodsChanged;
	}
	
	public void refreshList(){
		
		methods = MethodRepository.getMethods();
		ObservableUtils.firePropertyChanged(this, "methods");
		methodsChanged = true;
	}
	
/*	public void refreshList(){
		indicators = IndicatorRepository.getIndicatorList();
		ObservableUtils.firePropertyChanged(this, "indicators");
		indicatorsChanged = true;
	}
	
	public Boolean verifyIfSomethingChanged()
	{
		return methodsChanged;
	}
	
	public void somethingChanged()
	{
		methodsChanged = true;
	}
	*/

}
