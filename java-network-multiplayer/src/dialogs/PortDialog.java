package dialogs;

public class PortDialog extends InputDialog {

  @Override
  protected String message() {
    return "What is the server port?";
  }

  @Override
  protected String title() {
    return "Enter server port";
  }

  @Override
  protected String failure() {
    return "Wrong port format!";
  }

  @Override
  protected String defaultValue() {
    return "9001";
  }

  @Override
  protected boolean validate(String str) {
    return isInteger(str);
  }

  public static boolean isInteger(String s) {
    int i = -1;
    try {
      i = Integer.parseInt(s);
    } catch(NumberFormatException e) {
      e.printStackTrace();
      System.err.println("source: " + i);
      return false;
    }
    return true;
  }

}
