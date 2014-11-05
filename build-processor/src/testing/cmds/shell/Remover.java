package testing.cmds.shell;

import testing.cmds.Command;

public class Remover extends Command {

  private final String filename;

  public Remover(String filename) {
    this.filename = filename;
  }

  @Override
  protected String[] generateArgs() {
    return new String[] {"rm", filename};
  }

}
