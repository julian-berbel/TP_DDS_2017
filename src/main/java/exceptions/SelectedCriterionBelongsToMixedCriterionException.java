package exceptions;

@SuppressWarnings("serial")
public class SelectedCriterionBelongsToMixedCriterionException extends RuntimeException {

  public SelectedCriterionBelongsToMixedCriterionException() {
    super("El criterio que quiere borrar pertenece a un criterio mixto!\n Si quiere proceder, borre dicho criterio.");
  }
}
