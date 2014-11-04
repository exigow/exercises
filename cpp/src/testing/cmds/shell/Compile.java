package testing.cmds.shell;

import java.io.File;
import java.io.IOException;

public class Compile {

  public static Process execute(String sourceName, String resultName) throws IOException {
    String[] args = {"g++", sourceName, "-o", resultName};
    ProcessBuilder pb = new ProcessBuilder(args);
    pb.directory(new File("./cpp/code/train"));
    pb.redirectErrorStream(true);
    return pb.start();
  }

}
