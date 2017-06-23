package modelo;

import java.util.ArrayList;
import java.util.List;

public class MethodRepository {

	private List<Method> methods;
	
	public MethodRepository()
	{
		methods = new ArrayList<Method>();
	}
	
	public void addMethod(Method method)
	{
		methods.add(method);
	}
	
	public List<Method> getMethods()
	{
		return methods;
	}
	
	public void setMethodList(List<Method> methodList)
	{
		methods = methodList;
	}
}
