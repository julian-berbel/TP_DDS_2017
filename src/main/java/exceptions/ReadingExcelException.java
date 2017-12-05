package exceptions;

@SuppressWarnings("serial")
public class ReadingExcelException extends RuntimeException {

  public ReadingExcelException(String msj) {
    super(msj);
  }
}
