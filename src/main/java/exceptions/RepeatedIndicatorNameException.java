package exceptions;



public class RepeatedIndicatorNameException extends RuntimeException{
	
	public RepeatedIndicatorNameException(String name)
	{
		super(name);
	}

}
