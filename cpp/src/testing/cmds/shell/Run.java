package testing.cmds.shell;

import java.io.File;
import java.io.IOException;

public class Run {

  public static Process run(String name) throws IOException {
    String[] args = {"./" + name};
    ProcessBuilder pb = new ProcessBuilder(args);
    pb.directory(new File("./cpp/code/train"));
    pb.redirectErrorStream(true);
    return pb.start();
  }

}
