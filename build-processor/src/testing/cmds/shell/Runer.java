package testing.cmds.shell;

import testing.cmds.Command;

import java.io.File;
import java.io.IOException;

public class Runer extends Command {

  private final String executableName;

  public Runer(String executableName) {
    this.executableName = executableName;
  }

  @Override
  protected String[] generateArgs() {
    return new String[] {"./" + executableName};
  }

}
