package testing.cmds.shell;

import testing.cmds.Command;

import java.io.File;
import java.io.IOException;

public class Run extends Command {

  private final String executableName;

  public Run(String executableName) {
    this.executableName = executableName;
  }

  @Override
  protected String[] generateArgs() {
    return new String[] {"./" + executableName};
  }

}
