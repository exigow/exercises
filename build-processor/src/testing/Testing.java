package testing;

import testing.cmds.Product;
import testing.cmds.shell.Compilator;
import testing.cmds.shell.Remover;
import testing.cmds.shell.Runer;
import testing.tests.TestFinder;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Testing {

  private final static String TEMP_COMPILED = "_temp";
  private final static String WORKING_PATH = "build-processor/code/";

  public static void main(String[] args) throws IOException, InterruptedException {
    Path root = Paths.get(WORKING_PATH);
    Set<String> tests = new TestFinder().collect(root);
    for (String test : tests)
      System.out.println(test);

    Process compiler = new Compilator("main.c", TEMP_COMPILED).run();
    Product product = Executor.execute(compiler);
    System.out.println("[compilation]\n" + product.toString());

    Process instance = new Runer(TEMP_COMPILED).run();
    Product test = Executor.executeWithStream(instance, new FileInputStream("./" + WORKING_PATH + "train/binary.in"));
    System.out.println("[testing]\n" + test.toString());

    Process remover = new Remover(TEMP_COMPILED).run();
    Product rem = Executor.execute(remover);
    System.out.println("[removing]\n" + rem.toString());
  }

}
