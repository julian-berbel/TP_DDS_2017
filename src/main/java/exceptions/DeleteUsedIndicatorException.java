package exceptions;

@SuppressWarnings("serial")
public class DeleteUsedIndicatorException extends RuntimeException {
	
	public DeleteUsedIndicatorException()
	{
		super("El indicador que quiere borrar es utilizado por uno o mas de otros indicadores!\n Si quiere proceder, borre dichos indicadores primero.");
	}
}
