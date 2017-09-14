package exceptions;

@SuppressWarnings("serial")
public class ExistingMethodException extends RuntimeException {
	public ExistingMethodException(String nombre)
	{
		super("Ya existe un metodo con el nombre " + nombre + ", si lo quiere cambiar, use el boton editar" );
	}
}
