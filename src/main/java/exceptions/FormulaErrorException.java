package exceptions;

@SuppressWarnings("serial")
public class FormulaErrorException extends RuntimeException {
  public FormulaErrorException(String msj) {
    super("Error al parsear la formula dada!\n" + msj);
  }
}
