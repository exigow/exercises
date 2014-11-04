package testing.cmds;

import java.math.BigDecimal;

public class Product {

  public long time;
  public String output;
  public int exit;

  private static String prettyTimeSeconds(long nanos) {
    BigDecimal decimal = new BigDecimal(nanos).divide(new BigDecimal(1000000000));
    return decimal.toString() + "s";
  }

  @Override
  public String toString() {
    return
      "execution time: " + prettyTimeSeconds(time) + "\n" +
      "exit value: " + prettyExitValue(exit) + "\n" +
      "output: " + output;
  }

  private String prettyExitValue(int value) {
    String result = Integer.toString(value);
    if (value == 0)
      result += " (success)";
    else
      result += " (error)";
    return result;
  }

}