package testing;
import testing.tests.Test;
import testing.tests.TestFinder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class Testing {

  private final static String TEMP_COMPILED = "_temp";

  public static void main(String[] args) throws IOException, InterruptedException {
    Path root = Paths.get("build-processor/code");
    Collection<Test> tests = new TestFinder().collect(root);
    for (Test test : tests)
      System.out.println(test);

    /*Process compiler = new Compile("main.c", TEMP_COMPILED).run();
    Product product = Executor.execute(compiler);
    System.out.println("[compilation]\n" + product.toString());

    Process instance = new Run(TEMP_COMPILED).run();
    Product test = Executor.executeWithStream(instance, new FileInputStream("./build-processor/code/train/binary.in"));
    System.out.println("[testing]\n" + test.toString());

    Process remover = new Remove(TEMP_COMPILED).run();
    Product rem = Executor.execute(remover);
    System.out.println("[removing]\n" + rem.toString());*/
  }

}
