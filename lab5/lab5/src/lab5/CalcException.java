package lab5;

public class CalcException extends ArithmeticException {
  public CalcException() {
  }

  public CalcException(String cause) {
    super("[CALC ERROR] " + cause);
  }
}
