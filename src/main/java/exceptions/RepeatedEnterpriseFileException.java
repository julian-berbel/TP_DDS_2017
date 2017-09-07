
package exceptions;

@SuppressWarnings("serial")
public class RepeatedEnterpriseFileException extends RuntimeException{

	public RepeatedEnterpriseFileException(String msg)
	{
		super(msg);
	}
}
