package exceptions;

@SuppressWarnings("serial")
public class MissingIndicatorException extends RuntimeException {

	public MissingIndicatorException(String name)
	{
		super(name);
	}
}
