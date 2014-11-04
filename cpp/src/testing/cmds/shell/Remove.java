package testing.cmds.shell;

import testing.cmds.Command;

public class Remove extends Command {

  private final String filename;

  public Remove(String filename) {
    this.filename = filename;
  }

  @Override
  protected String[] generateArgs() {
    return new String[] {"rm", filename};
  }

}
