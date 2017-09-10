package exceptions;

	@SuppressWarnings("serial")
	public class NoFileSelectedException extends RuntimeException{

		public NoFileSelectedException()
		{
			super("No se ha seleccionado un archivo. Seleccione uno antes de continuar.");
		}
	}
