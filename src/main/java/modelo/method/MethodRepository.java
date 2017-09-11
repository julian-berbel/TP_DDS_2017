package modelo.method;

import java.util.ArrayList;
import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class MethodRepository implements WithGlobalEntityManager {

	private static MethodRepository instance;
	
	private List<Method> methods = new ArrayList<Method>();
	
	private MethodRepository(){}
	
	public static MethodRepository getInstance(){
		if(instance==null)instance = new MethodRepository();
		return instance;
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
	
	public Boolean alreadyExists(String newMethodName)
	{
		 return methods.stream()
						.map(indicator -> indicator.getName())
						.anyMatch(indicatorName->indicatorName.equals(newMethodName));
	}
	
	public void replace(Method oldMethod, Method newMethod)
	{
		methods.replaceAll(method -> method == oldMethod ? newMethod:method);
	}
	
}
