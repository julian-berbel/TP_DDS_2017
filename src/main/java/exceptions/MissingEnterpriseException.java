package exceptions;


@SuppressWarnings("serial")
public class MissingEnterpriseException extends RuntimeException {

	public MissingEnterpriseException(String name)
	{
		super("La empresa @" + name + " no existe!");
	}
}
