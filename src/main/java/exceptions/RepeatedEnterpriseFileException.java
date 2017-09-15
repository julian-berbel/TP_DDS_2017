
package exceptions;

@SuppressWarnings("serial")
public class RepeatedEnterpriseFileException extends RuntimeException{

	public RepeatedEnterpriseFileException()
	{
		super("El archivo contiene una o mas empresas con un nombre ya cargado, modifiquelo y vuelva a cargar");
	}
}
