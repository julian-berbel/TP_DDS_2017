package exceptions;

@SuppressWarnings("serial")
public class MissingFileException extends RuntimeException{

	public MissingFileException(String msg)
	{
		super(msg);
	}
}
