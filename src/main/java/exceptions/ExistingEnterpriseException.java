
package exceptions;

@SuppressWarnings("serial")
public class ExistingEnterpriseException extends RuntimeException {
	public ExistingEnterpriseException(String nombre)
	{
		super("Ya existe una empresa con el nombre " + nombre );
	}
}
