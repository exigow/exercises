package dialogs;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressDialog extends InputDialog {

  public IpAddressDialog(Window parent) {
    super(parent);
  }

  @Override
  protected String message() {
    return "What is the server IP address?";
  }

  @Override
  protected String title() {
    return "Enter server IP";
  }

  @Override
  protected String failure() {
    return "Wrong IP format!";
  }

  @Override
  protected String defaultValue() {
    return "127.0.0.1";
  }

  private static Pattern pattern = Pattern.compile("\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}");

  @Override
  protected boolean validate(String str) {
    Matcher matcher = pattern.matcher(str);
    return matcher.matches();
  }

}
