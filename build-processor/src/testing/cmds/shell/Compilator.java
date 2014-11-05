package testing.cmds.shell;

import testing.cmds.Command;

public class Compilator extends Command {

  private final String sourceName, compiledName;

  public Compilator(String sourceName, String compiledName) {
    this.sourceName = sourceName;
    this.compiledName = compiledName;
  }

  @Override
  protected String[] generateArgs() {
    return new String[] {"g++", sourceName, "-o", compiledName};
  }

}
