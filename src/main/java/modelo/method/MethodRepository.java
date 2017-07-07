package modelo.method;

import java.util.ArrayList;
import java.util.List;

public class MethodRepository {

	private static List<Method> methods;
	
	public MethodRepository()
	{
		methods = new ArrayList<Method>();
	}
	
	public static void addMethod(Method method)
	{
		
		methods.add(method);
		
	}
	
	public static List<Method> getMethods()
	{
		
		return methods;
		
	}
	
	public void setMethodList(List<Method> methodList)
	{
		methods = methodList;
	}
	public static Boolean alreadyExists(String newMethodName)
	{
		 return methods.stream()
						.map(indicator -> indicator.getName())
						.anyMatch(indicatorName->indicatorName.equals(newMethodName));
		
		
	
	}
}
