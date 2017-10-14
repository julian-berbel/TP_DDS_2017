package viewModel.method;

import java.util.List;
import java.util.Optional;

import modelo.method.Method;
import modelo.method.MethodRepository;


public class MethodVM {

	private List<Method> methods = MethodRepository.getInstance().getList();;
	private Method selectedMethod;
	private Boolean methodsChanged = false;

	public List<Method> getMethods() {
		return methods;
	}
	
	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}
	
	public Method getSelectedMethod() {
		return selectedMethod;
	}
	
	public void setSelectedMethod(Method selectedMethod) {
		this.selectedMethod = selectedMethod;
	}

	public void addNewMethod(Optional<Method> newMethod) {
		newMethod.ifPresent(method -> {
			MethodRepository.getInstance().addElement(method);
			methods.add(method);
		});
		refreshList();
	}

	public Boolean getMethodsChanged() {
		return methodsChanged;
	}

	public void setMethodsChanged(Boolean methodsChanged) {
		this.methodsChanged = methodsChanged;
	}
	
	public void refreshList(){
		methodsChanged = true;
	}
	
	public void deleteMethod(){
		MethodRepository.getInstance().deleteElement(selectedMethod);
		methods.remove(selectedMethod);
		refreshList();
	}
	
	private int selectedIndex(){
		return methods.indexOf(selectedMethod);
	}
	
	public void updateMethod(Optional<Method> method){
		method.ifPresent(newMethod -> {
			MethodRepository.getInstance().updateElement(newMethod);
			methods.set(selectedIndex(), newMethod);
		});
 		refreshList();
 	}

}
