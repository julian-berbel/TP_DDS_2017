package exceptions;

@SuppressWarnings("serial")
public class EmptyFieldException extends RuntimeException {
	public EmptyFieldException(String campo)
	{
		super("El campo " + campo + " no puede estar vacio!" );
	}
}
