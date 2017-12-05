package exceptions;

@SuppressWarnings("serial")
public class NoSelectedIndicatorException extends RuntimeException {

  public NoSelectedIndicatorException() {
    super("Debe seleccionar un Indicador!");
  }
}
