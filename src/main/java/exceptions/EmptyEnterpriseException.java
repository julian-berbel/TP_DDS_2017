
package exceptions;

@SuppressWarnings("serial")
public class EmptyEnterpriseException extends RuntimeException {
	
	public EmptyEnterpriseException()
	{
		super("La nueva empresa debe tener al menos un periodo");
	}
}
