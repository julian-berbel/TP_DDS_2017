package exceptions;


public class MissingIndicatorException extends RuntimeException {

	public MissingIndicatorException(String name)
	{
		super("El indicador @" + name + " no existe!");
	}
}
