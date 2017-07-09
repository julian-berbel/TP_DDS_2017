package exceptions;

@SuppressWarnings("serial")
public class RepeatedIndicatorInSystemException extends RuntimeException{

	public RepeatedIndicatorInSystemException(String msg)
	{
		super(msg);
	}
}
