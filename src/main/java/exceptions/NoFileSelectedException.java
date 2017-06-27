package exceptions;

	@SuppressWarnings("serial")
	public class NoFileSelectedException extends RuntimeException{

		public NoFileSelectedException(String msj)
		{
			super(msj);
		}
	}
