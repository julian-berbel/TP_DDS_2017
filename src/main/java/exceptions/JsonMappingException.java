package exceptions;


@SuppressWarnings("serial")
public class JsonMappingException extends RuntimeException{

	public JsonMappingException(String msj)
	{
		super(msj);
	}
}
