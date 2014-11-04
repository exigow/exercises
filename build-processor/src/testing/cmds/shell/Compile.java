package testing.cmds.shell;

import testing.cmds.Command;

public class Compile extends Command {

  private final String sourceName, compiledName;

  public Compile(String sourceName, String compiledName) {
    this.sourceName = sourceName;
    this.compiledName = compiledName;
  }

  @Override
  protected String[] generateArgs() {
    return new String[] {"g++", sourceName, "-o", compiledName};
  }

}
