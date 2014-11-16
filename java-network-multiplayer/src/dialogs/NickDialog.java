package dialogs;

public class NickDialog extends InputDialog {

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
    return "nick_" + (int) (Math.random() * 128);
  }

  @Override
  protected boolean validate(String str) {
    return !isBlank(str);
  }

}
