package dialogs;

import javax.swing.*;

public abstract class InputDialog {

  protected abstract String message();

  protected abstract String title();

  protected abstract String failure();

  protected abstract String defaultValue();

  protected abstract boolean validate(String str);

  public String execute() {
    String str = (String)JOptionPane.showInputDialog(null, message(),
      title(), JOptionPane.QUESTION_MESSAGE, null, null, defaultValue());
    if (validate(str))
      return str;
    JOptionPane.showMessageDialog(null, failure());
    return null;
  }

  protected static boolean isBlank(String str) {
    return str == null || str.isEmpty();
  }

}
