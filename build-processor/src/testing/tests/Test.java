package testing.tests;

import java.io.File;

public class Test {

  public String name;
  public File input, output;

  @Override
  public String toString() {
    return "Test{" +
      "name='" + name + '\'' +
      ", input=" + input +
      ", output=" + output +
      '}';
  }

}
