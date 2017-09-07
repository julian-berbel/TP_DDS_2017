
package exceptions;

@SuppressWarnings("serial")
public class ExistingCalculationException extends RuntimeException {
	public ExistingCalculationException(String nombre)
	{
		super("Ya existe una cuenta con el nombre " + nombre + ", en el periodo actual, si lo quiere cambiar, use el boton editar" );
	}
}
