package exceptions;

@SuppressWarnings("serial")
public class ReadingFileException extends RuntimeException {

	public ReadingFileException(String msj)
	{
		super(msj);
	}
}
