package client.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public abstract class InputDialog {

  private final Window parent;

  public InputDialog(Window parent) {
    this.parent = parent;
  }

  private void close() {
    parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
  }

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
    close();
    return null;
  }

  protected static boolean isBlank(String str) {
    return str == null || str.isEmpty();
  }

}
