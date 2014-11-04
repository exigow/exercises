package testing.cmds;

import java.io.File;
import java.io.IOException;

public abstract class Command {

  public Process exec() throws IOException {
    return  buildProcess(generateArgs());
  }

  protected abstract String[] generateArgs();

  private Process buildProcess(String[] args) throws IOException {
    ProcessBuilder pb = new ProcessBuilder(args);
    pb.directory(new File("./cpp/code/train"));
    pb.redirectErrorStream(true);
    return pb.start();
  }

}
