package testing.cmds;

import java.io.File;
import java.io.IOException;

public abstract class Command {

  protected abstract String[] generateArgs();

  public Process run() throws IOException {
    return buildProcess(generateArgs());
  }

  private Process buildProcess(String[] args) throws IOException {
    ProcessBuilder pb = new ProcessBuilder(args);
    pb.directory(new File("./build-processor/code/train"));
    pb.redirectErrorStream(true);
    return pb.start();
  }

}
