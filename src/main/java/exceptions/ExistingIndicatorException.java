package exceptions;

@SuppressWarnings("serial")
public class ExistingIndicatorException extends RuntimeException {
  public ExistingIndicatorException(String nombre) {
    super("Ya existe un indicador con el nombre " + nombre + ", si lo quiere cambiar, use el boton editar");
  }
}
