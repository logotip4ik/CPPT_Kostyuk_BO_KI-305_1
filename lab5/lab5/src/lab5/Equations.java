package lab5;

public class Equations {
  /**
   * cos(x)/tg(2x)
   * 
   * @param x
   * @version 1.0.0
   * @return Double
   * @throws CalcException
   */
  public double calculate(double x) throws CalcException {
    double res;

    try {
      res = Math.tan(2 * x);

      if (res == 0) {
        throw new ArithmeticException("value in devider (tan(2 * x)) is 0");
      }

      if (Double.isNaN(res) || Double.isInfinite(res)) {
        throw new ArithmeticException("value in devider (tan(2 * x)) is not valid");
      }

      res = Math.cos(x) / res;

      if (Double.isNaN(res) || Double.isInfinite(res)) {
        throw new ArithmeticException("result value is not valid");
      }
    } catch (ArithmeticException e) {
      throw new CalcException(e.getMessage());
    }

    return res;
  }
}
