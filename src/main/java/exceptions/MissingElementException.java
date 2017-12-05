package exceptions;

@SuppressWarnings("serial")
public class MissingElementException extends RuntimeException {
  public MissingElementException(String searchField, Object value, String tableName) {
    super("No existe el elemento " + searchField + " con valor " + value.toString() + " en la tabla " + tableName);
  }
}
