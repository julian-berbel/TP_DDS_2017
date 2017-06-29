package viewModel;

import java.io.IOException;
import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import modelo.Method;

@Observable
public class MethodVM {

	private List<Method> methods;
	private Method selectedMethod;
	private Boolean methodsChanged;
	
	public MethodVM(){
		methodsChanged = false;
//		refreshList();
	}
	
	public List<Method> getMethod() {
		return methods;
	}
	
	public void setMethod(List<Method> Method) {
		this.methods = methods;
	}
	
	public Method getSelectedMethod() {
		return selectedMethod;
	}
	
	public void setSelectedMethod(Method selectedMethod) {
		this.selectedMethod = selectedMethod;
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
