package client.dialogs;

import java.awt.*;

public class NickDialog extends InputDialog {

  public NickDialog(Window parent) {
    super(parent);
  }

  @Override
  protected String message() {
    return "What is your nick?";
  }

  @Override
  protected String title() {
    return "Enter your nick";
  }

  @Override
  protected String failure() {
    return "Nick is not specified!";
  }

  @Override
  protected String defaultValue() {
    return "skj";
  }

  @Override
  protected boolean validate(String str) {
    return !isBlank(str);
  }

}
